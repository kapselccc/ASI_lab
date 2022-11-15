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
        Club wiesniak = Club.builder().name("Wieśniak").league(0).money(5).build();
        Club szeregowy = Club.builder().name("Szeregowy").league(2).money(7).build();
        Club wot = Club.builder().name("Wojsko Obrony Terytorialnej").league(8).money(4).build();

        clubService.create(wiesniak);
        clubService.create(szeregowy);
        clubService.create(wot);

        Player janek = Player.builder().name("Jan").age(1).club(wiesniak).build();
        Player darek = Player.builder().name("Dariusz").age(7).club(wiesniak).build();
        Player marek = Player.builder().name("Marek").age(11).club(szeregowy).build();
        Player czarek = Player.builder().name("Cezary").age(17).club(szeregowy).build();
        Player arek = Player.builder().name("Arkadiusz").age(23).club(wot).build();
        Player franek = Player.builder().name("Franciszek").age(29).club(wot).build();

        playerService.create(janek);
        playerService.create(darek);
        playerService.create(marek);
        playerService.create(czarek);
        playerService.create(arek);
        playerService.create(franek);


    }
}
