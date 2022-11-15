package pl.esovisco.lab1.club.dto;

import lombok.*;
import pl.esovisco.lab1.player.dto.CreatePlayerRequest;
import pl.esovisco.lab1.club.Club;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateClubRequest {
    private String name;

    private double moveSpeed;

    private int armor;

    public static Club toClub(CreateClubRequest request){
        return Club.builder()
                .name(request.getName())
                .baseArmor(request.getArmor())
                .moveSpeed(request.getMoveSpeed())
                .build();
    }
}
