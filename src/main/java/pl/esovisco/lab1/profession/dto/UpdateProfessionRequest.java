package pl.esovisco.lab1.profession.dto;

import lombok.*;
import pl.esovisco.lab1.profession.Profession;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UpdateProfessionRequest {
    private String name;

    private double moveSpeed;

    private int armor;

    public static Profession updateProfession(Profession profession, UpdateProfessionRequest request){
        profession.setName(request.getName());
        profession.setBaseArmor(request.getArmor());
        profession.setMoveSpeed(request.moveSpeed);
        return profession;
    }
}
