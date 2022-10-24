package pl.esovisco.lab1.profession.dto;

import lombok.*;
import pl.esovisco.lab1.character.dto.CreateCharacterRequest;
import pl.esovisco.lab1.profession.Profession;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateProfessionRequest {
    private String name;

    private double moveSpeed;

    private int armor;

    public static Profession toProfession(CreateProfessionRequest request){
        return Profession.builder()
                .name(request.getName())
                .baseArmor(request.getArmor())
                .moveSpeed(request.getMoveSpeed())
                .build();
    }
}
