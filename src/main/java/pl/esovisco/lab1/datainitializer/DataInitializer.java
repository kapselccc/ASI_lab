package pl.esovisco.lab1.datainitializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.esovisco.lab1.player.Player;
import pl.esovisco.lab1.player.PlayerService;
import pl.esovisco.lab1.club.Club;
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
        Club kormoran = Club.builder().name("Kormoran").league(1).money(5).build();
        Club legia = Club.builder().name("Legia").league(2).money(7).build();
        Club wisla = Club.builder().name("Wisła").league(8).money(4).build();

        clubService.create(kormoran);
        clubService.create(legia);
        clubService.create(wisla);

        Player janek = Player.builder().name("Jan").age(20).club(kormoran).build();
        Player darek = Player.builder().name("Dariusz").age(27).club(kormoran).build();
        Player marek = Player.builder().name("Marek").age(19).club(legia).build();
        Player czarek = Player.builder().name("Cezary").age(17).club(legia).build();
        Player arek = Player.builder().name("Arkadiusz").age(23).club(wisla).build();
        Player franek = Player.builder().name("Franciszek").age(29).club(wisla).build();

        playerService.create(janek);
        playerService.create(darek);
        playerService.create(marek);
        playerService.create(czarek);
        playerService.create(arek);
        playerService.create(franek);


    }
}
