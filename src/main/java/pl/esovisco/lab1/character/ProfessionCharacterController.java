package pl.esovisco.lab1.character;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.esovisco.lab1.character.dto.GetCharacterResponse;
import pl.esovisco.lab1.character.dto.GetCharactersResponse;
import pl.esovisco.lab1.profession.Profession;
import pl.esovisco.lab1.profession.ProfessionService;

import java.util.Optional;

@RestController
@RequestMapping("/professions")
public class ProfessionCharacterController {

    private final CharacterService characterService;

    private final ProfessionService professionService;

    public ProfessionCharacterController(CharacterService characterService, ProfessionService professionService) {
        this.characterService = characterService;
        this.professionService = professionService;
    }

    @GetMapping("{id}/characters")
    public ResponseEntity<GetCharactersResponse> getProfessionCharacters(@PathVariable long id){
        Optional<Profession> profession = professionService.find(id);

        return profession.map(value -> ResponseEntity.ok(
                GetCharactersResponse.toCharactersResponse(value.getCharacters())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
