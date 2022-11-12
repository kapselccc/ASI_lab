package pl.esovisco.lab1.character.dto;

import lombok.*;
import pl.esovisco.lab1.character.Character;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetCharacterResponse {

    private String name;

    private Long profession;

    private int level;

    public static GetCharacterResponse toCharacterResponse(Character character){
        return GetCharacterResponse.builder().name(character.getName())
                .profession(character.getProfession().getId())
                .level(character.getLevel())
                .build();
    }
}
