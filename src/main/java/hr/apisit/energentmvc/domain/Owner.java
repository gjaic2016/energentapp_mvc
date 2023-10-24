package hr.apisit.energentmvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "OWNER")
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IME")
    private String ime;

    @Column(name = "PREZIME")
    private String prezime;

    @Column(name = "DATUM_RODENJA")
    private LocalDate datumRodenja;

    @Column(name = "OIB")
    private String oib;

    @ManyToMany(mappedBy = "vlasnik")
    @JsonIgnore
    private List<Household> householdList;

}
