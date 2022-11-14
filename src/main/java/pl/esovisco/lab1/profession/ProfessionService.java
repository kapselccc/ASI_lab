package pl.esovisco.lab1.profession;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessionService {
    private final ProfessionRepository repository;

    @Autowired
    public ProfessionService(ProfessionRepository repository) {
        this.repository = repository;
    }

    public Profession create(Profession profession){
        return repository.save(profession);
    }

    public Optional<Profession> find(long id){
        return repository.findById(id);
    }


    public List<Profession> findAll(){
        return repository.findAll();
    }

    public void delete(Profession profession){
            repository.delete(profession);
    }

    public void update(Profession profession){
        repository.save(profession);
    }
}
