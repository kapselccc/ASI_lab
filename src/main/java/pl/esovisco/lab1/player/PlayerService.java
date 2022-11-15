package pl.esovisco.lab1.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository repository;

    @Autowired
    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public void create(Player player){
        repository.create(player);
    }

    public void delete(Player player){
            repository.delete(player);
    }

    public List<Player> findAll(){
        return repository.findAll();
    }

    public Optional<Player> find(long id){
        return repository.find(id);
    }
}
