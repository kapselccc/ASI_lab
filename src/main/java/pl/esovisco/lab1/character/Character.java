package pl.esovisco.lab1.character;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.esovisco.lab1.profession.Profession;

import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name="characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profession")
    @ToString.Exclude
    private Profession profession;

    private int level;



}
