package pl.esovisco.lab1.character;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.esovisco.lab1.datastore.DataStore;

import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepository {
    DataStore dataStore;

    @Autowired
    public CharacterRepository(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void create(Character character){
        dataStore.createCharacter(character);
    }

    public void delete(Character character){
        try {
            dataStore.deleteCharacter(character.getId());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

    public List<Character> findAll(){
        return dataStore.findAllCharacters();
    }

    public Optional<Character> find(long id){
        return dataStore.findCharacterById(id);
    }
}
