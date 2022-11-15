package pl.esovisco.lab1.club.dto;

import lombok.*;
import pl.esovisco.lab1.club.Club;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetClubResponse {
    private String name;

    private double money;

    private int armor;

    public static GetClubResponse toClubResponse(Club club){
        return GetClubResponse.builder()
                .name(club.getName())
                .armor(club.getLeague())
                .money(club.getMoney())
                .build();
    }
}
