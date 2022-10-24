package pl.esovisco.lab1.character.dto;

import lombok.*;
import pl.esovisco.lab1.profession.Profession;
import pl.esovisco.lab1.character.Character;

import java.util.function.Function;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateCharacterRequest {

    private String name;

    private Long profession;

    private int level;

    /**
     *
     * @param request character from JSON
     * @param professionFunction function that takes profession id and returns Profession object
     * @return
     */
    public static Character toCharacter(CreateCharacterRequest request,Function<Long,Profession> professionFunction){
        return Character.builder()
                .name(request.getName())
                .level(request.getLevel())
                .profession(professionFunction.apply(request.getProfession()))
                .build();
    }
}
