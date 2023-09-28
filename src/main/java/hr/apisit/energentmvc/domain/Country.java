package hr.apisit.energentmvc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@Data
@Getter
@Setter
@Entity
@Table(name="COUNTRY")
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

//    @JsonIgnoreProperties("country")
//    @JsonIgnore

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<City> cities;

}
