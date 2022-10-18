package pl.esovisco.lab1.profession;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.esovisco.lab1.datastore.DataStore;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfessionRepository {

    private DataStore dataStore;

    @Autowired
    public ProfessionRepository(DataStore dataStore){
        this.dataStore = dataStore;
    }

    public void create(Profession profession){
        dataStore.createProfession(profession);
    }

    public Optional<Profession> find(long id){
        return dataStore.findProfessionById(id);
    }

    public List<Profession> findAll(){
        return dataStore.findAllProfessions();
    }

    public void delete(Profession profession){
        try{
            dataStore.deleteProfession(profession.getId());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
