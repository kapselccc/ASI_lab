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
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profession")
    @ToString.Exclude
    private List<Character> characters;


}
