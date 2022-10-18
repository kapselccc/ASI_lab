package pl.esovisco.lab1.character;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.esovisco.lab1.profession.Profession;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Character {
    private String name;

    private Profession profession;

    private int level;

    private long id;

}
