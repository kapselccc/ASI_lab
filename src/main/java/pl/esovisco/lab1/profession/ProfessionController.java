package pl.esovisco.lab1.profession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.esovisco.lab1.character.Character;
import pl.esovisco.lab1.character.CharacterService;
import pl.esovisco.lab1.profession.dto.CreateProfessionRequest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professions")
public class ProfessionController {
    private final ProfessionService professionService;

    private final CharacterService characterService;

    @Autowired
    public ProfessionController(ProfessionService professionService, CharacterService characterService) {
        this.professionService = professionService;
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<Void> createProfession(@RequestBody CreateProfessionRequest request){
        Profession profession = CreateProfessionRequest.toProfession(request);
        profession = professionService.create(profession);
        return ResponseEntity.created(URI.create(String.format("professions/%d",profession.getId()))).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProfession(@PathVariable long id){
        Optional<Profession> profession = professionService.find(id);
        if(profession.isPresent()){
            List<Character> characterList = profession.get().getCharacters();
            for(Character character : characterList){
                characterService.delete(character);
            }
            professionService.delete(profession.get());
            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
