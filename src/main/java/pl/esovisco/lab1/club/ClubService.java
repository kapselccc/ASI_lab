package pl.esovisco.lab1.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    private final ClubRepository repository;

    @Autowired
    public ClubService(ClubRepository repository) {
        this.repository = repository;
    }

    public void create(Club club){
        repository.create(club);
    }

    public Optional<Club> find(long id){
        return repository.find(id);
    }

    public List<Club> findAll(){
        return repository.findAll();
    }

    public void delete(Club club){
            repository.delete(club);
    }
}
