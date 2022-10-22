package pl.esovisco.lab1.profession;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.esovisco.lab1.character.Character;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "professions")
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "move_speed")
    private double moveSpeed;

    @Column(name = "base_armor")
    private int baseArmor;

    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Character> characters;


}
