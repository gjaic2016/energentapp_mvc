package hr.apisit.energentmvc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="CITY")
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="city_zip")
    private String city_zip;

    @Column(name="city_name")
    private String city_name;


    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

//    @ManyToOne
//    @JsonBackReference
//    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Address> address;

}
