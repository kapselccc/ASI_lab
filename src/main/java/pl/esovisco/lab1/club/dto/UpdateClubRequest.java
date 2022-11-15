package pl.esovisco.lab1.club.dto;

import lombok.*;
import pl.esovisco.lab1.club.Club;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UpdateClubRequest {
    private String name;

    private double money;

    private int armor;

    public static Club updateClub(Club club, UpdateClubRequest request){
        club.setName(request.getName());
        club.setLeague(request.getArmor());
        club.setMoney(request.money);
        return club;
    }
}
