package pl.esovisco.lab1.profession;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Profession {
    private String name;

    private double moveSpeed;

    private int baseArmor;

    private long id;
}
