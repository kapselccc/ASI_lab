package pl.esovisco.lab1.profession.dto;

import lombok.*;
import pl.esovisco.lab1.profession.Profession;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GetProfessionsResponse {
    private List<String> professions;

    public static GetProfessionsResponse toProfessionsResponse(List<Profession> professions){
       return GetProfessionsResponse.builder()
               .professions(professions.stream()
                       .map(Profession::getName)
                       .collect(Collectors.toList()))
               .build();
    }
}
