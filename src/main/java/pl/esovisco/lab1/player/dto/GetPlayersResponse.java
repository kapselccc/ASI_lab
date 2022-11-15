package pl.esovisco.lab1.player.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pl.esovisco.lab1.player.Player;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetPlayersResponse {

    private List<String> players;

    public static GetPlayersResponse toPlayersResponse(List<Player> players){
        return GetPlayersResponse.builder()
                .players(players.stream()
                            .map(Player::getName)
                            .collect(Collectors.toList()))
                            .build();
    }
}
