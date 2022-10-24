package pl.esovisco.lab1.character.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pl.esovisco.lab1.character.Character;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetCharactersResponse {

    private List<String> characters;

    public static GetCharactersResponse toCharactersResponse(List<Character> characters){
        return GetCharactersResponse.builder()
                .characters(characters.stream()
                            .map(Character::getName)
                            .collect(Collectors.toList()))
                            .build();
    }
}
