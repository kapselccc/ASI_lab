package pl.esovisco.lab1.player;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.esovisco.lab1.datastore.DataStore;

import java.util.List;
import java.util.Optional;

@Repository
public class PlayerRepository {
    DataStore dataStore;

    @Autowired
    public PlayerRepository(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void create(Player player){
        dataStore.createPlayer(player);
    }

    public void delete(Player player){
        try {
            dataStore.deletePlayer(player.getId());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

    public List<Player> findAll(){
        return dataStore.findAllPlayers();
    }

    public Optional<Player> find(long id){
        return dataStore.findPlayerById(id);
    }
}
