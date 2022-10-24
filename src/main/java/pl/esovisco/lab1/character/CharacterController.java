package pl.esovisco.lab1.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.esovisco.lab1.character.dto.CreateCharacterRequest;
import pl.esovisco.lab1.character.dto.GetCharacterResponse;
import pl.esovisco.lab1.character.dto.GetCharactersResponse;
import pl.esovisco.lab1.character.dto.UpdateCharacterRequest;
import pl.esovisco.lab1.profession.ProfessionService;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path = "/characters")
public class CharacterController {

    private final CharacterService characterService;

    private final ProfessionService professionService;

    @Autowired
    public CharacterController(CharacterService characterService, ProfessionService professionService) {
        this.characterService = characterService;
        this.professionService = professionService;
    }

    @GetMapping
    public ResponseEntity<GetCharactersResponse> getCharacters(){
        return ResponseEntity.ok(GetCharactersResponse.toCharactersResponse(characterService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<GetCharacterResponse> getCharacter(@PathVariable long id){
        Optional<Character> character = characterService.find(id);
        return character.map(val -> ResponseEntity.ok(GetCharacterResponse.toCharacterResponse(val)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createCharacter(@RequestBody CreateCharacterRequest request){
        Character character = CreateCharacterRequest.toCharacter(request,(id) -> professionService.find(id).orElseThrow());
        character = characterService.create(character);
        return ResponseEntity.created(URI.create(String.format("characters/%d",character.getId()))).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCharacter(@RequestBody UpdateCharacterRequest request, @PathVariable long id){
        Optional<Character> character = characterService.find(id);
        if(character.isPresent()){
            UpdateCharacterRequest.toCharacterUpdate(character.get(),request);
            characterService.update(character.get());
            return ResponseEntity.accepted().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
