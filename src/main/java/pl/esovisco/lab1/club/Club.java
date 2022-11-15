package pl.esovisco.lab1.club;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.esovisco.lab1.player.Player;

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
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "money")
    private double money;

    @Column(name = "league")
    private int league;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "club")
    @ToString.Exclude
    private List<Player> players;


}
