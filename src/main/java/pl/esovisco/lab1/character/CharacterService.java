package pl.esovisco.lab1.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository repository;

    @Autowired
    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public Character create(Character character){
        return repository.save(character);
    }

    public void delete(Character character){
            repository.delete(character);
    }

    public List<Character> findAll(){
        return repository.findAll();
    }

    public Optional<Character> find(long id){
        return repository.findById(id);
    }

    public void update(Character character){repository.save(character);}
}
