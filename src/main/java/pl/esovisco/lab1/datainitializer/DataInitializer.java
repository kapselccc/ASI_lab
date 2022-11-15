package pl.esovisco.lab1.datainitializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.esovisco.lab1.player.Player;
import pl.esovisco.lab1.player.PlayerRepository;
import pl.esovisco.lab1.player.PlayerService;
import pl.esovisco.lab1.datastore.DataStore;
import pl.esovisco.lab1.club.Club;
import pl.esovisco.lab1.club.ClubRepository;
import pl.esovisco.lab1.club.ClubService;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final PlayerService playerService;
    private final ClubService clubService;

    @Autowired
    public DataInitializer(PlayerService playerService, ClubService clubService){
        this.playerService = playerService;
        this.clubService = clubService;
    }

    @PostConstruct
    public void init(){
        Club wiesniak = Club.builder().name("Wieśniak").baseArmor(0).moveSpeed(5).build();
        Club szeregowy = Club.builder().name("Szeregowy").baseArmor(2).moveSpeed(7).build();
        Club wot = Club.builder().name("Wojsko Obrony Terytorialnej").baseArmor(8).moveSpeed(4).build();

        clubService.create(wiesniak);
        clubService.create(szeregowy);
        clubService.create(wot);

        Player janek = Player.builder().name("Jan").league(1).club(wiesniak).build();
        Player darek = Player.builder().name("Dariusz").league(7).club(wiesniak).build();
        Player marek = Player.builder().name("Marek").league(11).club(szeregowy).build();
        Player czarek = Player.builder().name("Cezary").league(17).club(szeregowy).build();
        Player arek = Player.builder().name("Arkadiusz").league(23).club(wot).build();
        Player franek = Player.builder().name("Franciszek").league(29).club(wot).build();

        playerService.create(janek);
        playerService.create(darek);
        playerService.create(marek);
        playerService.create(czarek);
        playerService.create(arek);
        playerService.create(franek);


    }
}
