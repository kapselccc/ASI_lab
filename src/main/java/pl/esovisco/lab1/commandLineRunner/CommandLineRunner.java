package pl.esovisco.lab1.commandLineRunner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.esovisco.lab1.character.Character;
import pl.esovisco.lab1.character.CharacterService;
import pl.esovisco.lab1.profession.Profession;
import pl.esovisco.lab1.profession.ProfessionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    private String[] commands = new String[]{"quit","print_characters","print_professions","print_all",
            "add_character", "add_profession"};

    private void print_commands(){
        System.out.println("Available commands:");
        for(String c : commands){
            System.out.println(c);
        }
    }

    private void add_character(){
        System.out.println("Type name:");
        String name = scanner.nextLine();
        System.out.println("Type level:");
        int level,id;
        Profession profession;
        try {
            level = Integer.parseInt(scanner.nextLine());
            System.out.println("Type profession ID:");
            id = Integer.parseInt(scanner.nextLine());
            profession = professionService.find(id).get();

        }catch (Exception e){
            if(e instanceof NumberFormatException){
                System.out.println("Value given is not an integer!");
            }
            else{
                System.out.println("There's no Profession with that ID");
            }
            return;
        }
        Character ch = Character.builder().name(name).level(level).profession(profession).build();
        characterService.create(ch);
    }

    @Override
    public void run(String... args) throws Exception {
        String command;
        print_commands();
        while( true ){

            command = scanner.nextLine();

            if(command.equals("quit")){
                break;
            }

            if(command.equals("commands")){
                print_commands();
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

            if(command.equals("add_character")){
                add_character();
                continue;
            }



        }

    }
}
