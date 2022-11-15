package pl.esovisco.lab1.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.esovisco.lab1.player.Player;
import pl.esovisco.lab1.player.PlayerService;
import pl.esovisco.lab1.player.dto.GetPlayersResponse;
import pl.esovisco.lab1.player.dto.UpdatePlayerRequest;
import pl.esovisco.lab1.club.dto.CreateClubRequest;
import pl.esovisco.lab1.club.dto.GetClubResponse;
import pl.esovisco.lab1.club.dto.GetClubsResponse;
import pl.esovisco.lab1.club.dto.UpdateClubRequest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clubs")
public class ClubController {
    private final ClubService clubService;

    private final PlayerService playerService;

    @Autowired
    public ClubController(ClubService clubService, PlayerService playerService) {
        this.clubService = clubService;
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Void> createClub(@RequestBody CreateClubRequest request){
        Club club = CreateClubRequest.toClub(request);
        club = clubService.create(club);
        return ResponseEntity.created(URI.create(String.format("clubs/%d",club.getId()))).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<GetClubResponse> getClub(@PathVariable long id){
        Optional<Club> club = clubService.find(id);
        return club.map(value -> ResponseEntity.ok(GetClubResponse.toClubResponse(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<GetClubsResponse> getClubs(){
        return ResponseEntity.ok(GetClubsResponse.toClubsResponse(clubService.findAll()));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateClub(@RequestBody UpdateClubRequest request, @PathVariable long id){
        Optional<Club> club = clubService.find(id);
        if(club.isPresent()){
            UpdateClubRequest.updateClub(club.get(),request);
            clubService.update(club.get());
            return ResponseEntity.accepted().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}/players")
    public ResponseEntity<GetPlayersResponse> getClubsPlayers(@PathVariable long id){
        Optional<Club> club = clubService.find(id);
        return club.map(value -> ResponseEntity.ok(GetPlayersResponse
                        .toPlayersResponse(value.getPlayers())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable long id){
        Optional<Club> club = clubService.find(id);
        if(club.isPresent()){
            List<Player> playerList = club.get().getPlayers();
            for(Player player : playerList){
                playerService.delete(player);
            }
            clubService.delete(club.get());
            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
