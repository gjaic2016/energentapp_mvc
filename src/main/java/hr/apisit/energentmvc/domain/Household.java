package hr.apisit.energentmvc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@Data
@Getter
@Setter
@Entity
@Table(name = "HOUSEHOLD")
@NoArgsConstructor
@AllArgsConstructor
public class Household {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "ADDRESS")
    private String adresa;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "HOUSEHOLD_OWNER",
            joinColumns = @JoinColumn(name = "HOUSEHOLD_ID"),
            inverseJoinColumns = @JoinColumn (name = "OWNER_ID")
    )
    private List<Owner> vlasnik;

}
