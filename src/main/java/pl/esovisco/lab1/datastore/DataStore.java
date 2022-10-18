package pl.esovisco.lab1.datastore;

import org.springframework.stereotype.Component;
import pl.esovisco.lab1.profession.Profession;
import pl.esovisco.lab1.character.Character;

import java.util.*;


@Component
public class DataStore {

    private Set<Profession> professions = new HashSet<>();

    private Set<Character> characters = new HashSet<>();


    public List<Profession> findAllProfessions(){return new ArrayList<>(professions);}

    public List<Character> findAllCharacters(){return new ArrayList<>(characters);}


    public void createProfession(Profession profession) {
        profession.setId(findAllProfessions().stream().mapToLong(Profession::getId).max().orElse(0) + 1);
        professions.add(profession);
    }

    public void createCharacter(Character character) {
        character.setId(findAllCharacters().stream().mapToLong(Character::getId).max().orElse(0) + 1);
        characters.add(character);
    }

    public Optional<Profession> findProfessionById(long id){
        return professions.stream().filter(profession -> profession.getId() == id ).findFirst();
    }

    public Optional<Character> findCharacterById(long id){
        return characters.stream().filter(character -> character.getId() == id ).findFirst();
    }

    public void deleteCharacter(long id)throws IllegalArgumentException{
        findCharacterById(id).ifPresentOrElse(
                original -> characters.remove(original),
                () -> {
                    throw new IllegalArgumentException(
                            String.format("The character with id \"%d\" does not exist", id));
                });
    }

    public void deleteProfession(long id)throws IllegalArgumentException{
        findCharacterById(id).ifPresentOrElse(
                original -> professions.remove(original),
                () -> {
                    throw new IllegalArgumentException(
                            String.format("The profession with id \"%d\" does not exist", id));
                });
    }
}
