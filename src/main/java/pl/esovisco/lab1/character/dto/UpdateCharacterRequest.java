package pl.esovisco.lab1.character.dto;

import lombok.*;
import pl.esovisco.lab1.character.Character;
import pl.esovisco.lab1.profession.Profession;

import java.util.function.Function;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UpdateCharacterRequest {

    private String name;

    private int level;

    public static Character toCharacterUpdate(Character character, UpdateCharacterRequest request){
        character.setLevel(request.getLevel());
        character.setName(request.getName());
        return character;
    }
}
