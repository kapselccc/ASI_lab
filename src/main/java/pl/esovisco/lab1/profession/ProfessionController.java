package pl.esovisco.lab1.profession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.esovisco.lab1.character.Character;
import pl.esovisco.lab1.character.dto.UpdateCharacterRequest;
import pl.esovisco.lab1.profession.dto.CreateProfessionRequest;
import pl.esovisco.lab1.profession.dto.GetProfessionResponse;
import pl.esovisco.lab1.profession.dto.GetProfessionsResponse;
import pl.esovisco.lab1.profession.dto.UpdateProfessionRequest;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/professions")
public class ProfessionController {
    private final ProfessionService professionService;

    @Autowired
    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @PostMapping
    public ResponseEntity<Void> createProfession(@RequestBody CreateProfessionRequest request){
        Profession profession = CreateProfessionRequest.toProfession(request);
        profession = professionService.create(profession);
        return ResponseEntity.created(URI.create(String.format("professions/%d",profession.getId()))).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<GetProfessionResponse> getProfession(@PathVariable long id){
        Optional<Profession> profession = professionService.find(id);
        return profession.map(value -> ResponseEntity.ok(GetProfessionResponse.toProfessionResponse(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<GetProfessionsResponse> getProfessions(){
        return ResponseEntity.ok(GetProfessionsResponse.toProfessionsResponse(professionService.findAll()));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateProfession(@RequestBody UpdateProfessionRequest request, @PathVariable long id){
        Optional<Profession> profession = professionService.find(id);
        if(profession.isPresent()){
            UpdateProfessionRequest.updateProfession(profession.get(),request);
            professionService.update(profession.get());
            return ResponseEntity.accepted().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
