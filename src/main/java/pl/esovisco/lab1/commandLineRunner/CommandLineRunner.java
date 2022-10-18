package pl.esovisco.lab1.commandLineRunner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.esovisco.lab1.character.Character;
import pl.esovisco.lab1.character.CharacterService;
import pl.esovisco.lab1.profession.Profession;
import pl.esovisco.lab1.profession.ProfessionService;

import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final CharacterService characterService;
    private final ProfessionService professionService;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public CommandLineRunner(CharacterService characterService, ProfessionService professionService) {
        this.characterService = characterService;
        this.professionService = professionService;
    }

    @Override
    public void run(String... args) throws Exception {
        String command = "commands";
        while( true ){

            if(command.equals("quit")){
                break;
            }

            if(command.equals("commands")){
                System.out.println("Available commands:\nquit\nprint_characters\nprint_professions\nprint_all");
            }

            if(command.equals("print_characters")){
                List<Character> characters = characterService.findAll();
                for(Character character : characters){
                    System.out.println(character);
                }
            }

            if(command.equals("print_professions")){
                List<Profession> professions = professionService.findAll();
                for(Profession profession : professions){
                    System.out.println(profession);
                }
            }

            if(command.equals("print_all")){
                List<Profession> professions = professionService.findAll();
                for(Profession profession : professions){
                    System.out.println(profession);
                }
                List<Character> characters = characterService.findAll();
                for(Character character : characters){
                    System.out.println(character);
                }
            }

            command = scanner.nextLine();
        }

    }
}
