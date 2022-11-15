package pl.esovisco.lab1.player;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.esovisco.lab1.club.Club;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Player {
    private String name;

    private Club club;

    private int age;

    private long id;

}
