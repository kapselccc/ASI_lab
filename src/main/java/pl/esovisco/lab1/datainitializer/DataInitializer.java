package pl.esovisco.lab1.datainitializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.esovisco.lab1.character.Character;
import pl.esovisco.lab1.character.CharacterRepository;
import pl.esovisco.lab1.character.CharacterService;
import pl.esovisco.lab1.datastore.DataStore;
import pl.esovisco.lab1.profession.Profession;
import pl.esovisco.lab1.profession.ProfessionRepository;
import pl.esovisco.lab1.profession.ProfessionService;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final CharacterService characterService;
    private final ProfessionService professionService;

    @Autowired
    public DataInitializer(CharacterService characterService, ProfessionService professionService){
        this.characterService = characterService;
        this.professionService = professionService;
    }

    @PostConstruct
    public void init(){
        Profession wiesniak = Profession.builder().id(1L).build();
        Profession szeregowy = Profession.builder().id(2L).build();
        Profession wot = Profession.builder().id(3L).build();

        professionService.create(wiesniak);
        professionService.create(szeregowy);
        professionService.create(wot);

        Character janek = Character.builder().name("Jan").level(1).profession(wiesniak).build();
        Character darek = Character.builder().name("Dariusz").level(7).profession(wiesniak).build();
        Character marek = Character.builder().name("Marek").level(11).profession(szeregowy).build();
        Character czarek = Character.builder().name("Cezary").level(17).profession(szeregowy).build();
        Character arek = Character.builder().name("Arkadiusz").level(23).profession(wot).build();
        Character franek = Character.builder().name("Franciszek").level(29).profession(wot).build();

        characterService.create(janek);
        characterService.create(darek);
        characterService.create(marek);
        characterService.create(czarek);
        characterService.create(arek);
        characterService.create(franek);


    }
}
