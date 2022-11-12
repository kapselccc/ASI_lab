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
    private Long id;

    public static Profession toProfession(CreateProfessionRequest request){
        return Profession.builder()
                .id(request.getId())
                .build();
    }
}
