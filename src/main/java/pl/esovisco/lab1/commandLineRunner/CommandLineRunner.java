package pl.esovisco.lab1.commandLineRunner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.esovisco.lab1.character.Character;
import pl.esovisco.lab1.character.CharacterRepository;
import pl.esovisco.lab1.character.CharacterService;
import pl.esovisco.lab1.profession.Profession;
import pl.esovisco.lab1.profession.ProfessionService;

import java.util.*;

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

    private final String[] commands = new String[]{"commands","quit","print_characters","print_professions","print_all",
            "add_character", "add_profession", "delete_character", "delete_profession"};

    private void print_commands(){
        System.out.println("Available commands:");
        for(String c : commands){
            System.out.println(c);
        }
    }

    private void add_character(){
        System.out.println("Type name:");
        String name = scanner.nextLine();
        System.out.println("Type level (int):");
        int level,id;
        Profession profession;
        try {
            level = Integer.parseInt(scanner.nextLine());
            System.out.println("Type profession ID (long):");
            id = Integer.parseInt(scanner.nextLine());
            profession = professionService.find(id).orElseThrow();

        }catch (Exception e){
            if(e instanceof NumberFormatException){
                System.out.println("Input is not an integer!");
            }
            else{
                System.out.println("There's no Profession with that ID");
            }
            return;
        }
        Character ch = Character.builder().name(name).level(level).profession(profession).build();
        characterService.create(ch);
        System.out.println("Added successfully");
    }

    private void add_profession(){
        System.out.println("Type ID:");
        Long id;
        try{
            id =  Long.parseLong(scanner.nextLine());
        }
        catch (NumberFormatException e){
                System.out.println("Input is not a long");
                return;
        }

        Profession p = Profession.builder().id(id).build();
        professionService.create(p);
        System.out.println("Added successfully");
    }

    private void delete_character(){
        System.out.println("Type Character ID:");
        long id;
        Character character;
        try{
            id = Integer.parseInt(scanner.nextLine());
            character = characterService.find(id).orElseThrow();

        }
        catch (Exception e){
            if(e instanceof NumberFormatException){
                System.out.println("Input is not a long");
            }
            if(e instanceof NoSuchElementException){
                System.out.println("No character with such ID");
            }
            return;
        }
        characterService.delete(character);
        System.out.println("Deleted successfully");
    }

    private void delete_profession() {

        System.out.println("Type profession ID:");
        long id;
        Profession profession;

        try{
            id = Integer.parseInt(scanner.nextLine());
            profession = professionService.find(id).orElseThrow();
        }
        catch (Exception e){
            if(e instanceof NumberFormatException){
                System.out.println("Input is not a long");
            }
            if(e instanceof NoSuchElementException){
                System.out.println("No Profession with such ID");
            }
            return;
        }

        professionService.delete(profession);
        System.out.println("Deleted successfully");
    }

    @Override
    public void run(String... args){
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

            if(command.equals("add_profession")){
                add_profession();
                continue;
            }

            if(command.equals("delete_character")){
                delete_character();
                continue;
            }

            if(command.equals("delete_profession")){
                delete_profession();
            }
        }

    }


}
