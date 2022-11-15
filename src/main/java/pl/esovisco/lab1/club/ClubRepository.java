package pl.esovisco.lab1.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.esovisco.lab1.datastore.DataStore;

import java.util.List;
import java.util.Optional;

@Repository
public class ClubRepository {

    private DataStore dataStore;

    @Autowired
    public ClubRepository(DataStore dataStore){
        this.dataStore = dataStore;
    }

    public void create(Club club){
        dataStore.createClub(club);
    }

    public Optional<Club> find(long id){
        return dataStore.findClubById(id);
    }

    public List<Club> findAll(){
        return dataStore.findAllClubs();
    }

    public void delete(Club club){
        try{
            dataStore.deleteClub(club.getId());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
