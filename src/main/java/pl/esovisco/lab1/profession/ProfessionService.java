package pl.esovisco.lab1.profession;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionService {
    private final ProfessionRepository repository;

    @Autowired
    public ProfessionService(ProfessionRepository repository) {
        this.repository = repository;
    }

    public void create(Profession profession){
        repository.create(profession);
    }

    public Optional<Profession> find(long id){
        return repository.find(id);
    }

    public List<Profession> findAll(){
        return repository.findAll();
    }

    public void delete(Profession profession){
            repository.delete(profession);
    }
}
