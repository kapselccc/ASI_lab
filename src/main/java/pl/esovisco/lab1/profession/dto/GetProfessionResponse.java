package pl.esovisco.lab1.profession.dto;

import lombok.*;
import pl.esovisco.lab1.profession.Profession;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetProfessionResponse {
    private String name;

    private double moveSpeed;

    private int armor;

    public static GetProfessionResponse toProfessionResponse(Profession profession){
        return GetProfessionResponse.builder()
                .name(profession.getName())
                .armor(profession.getBaseArmor())
                .moveSpeed(profession.getMoveSpeed())
                .build();
    }
}
