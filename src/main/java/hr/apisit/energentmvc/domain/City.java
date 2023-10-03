package hr.apisit.energentmvc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@Data
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

//    @JsonBackReference
    @OneToMany(mappedBy = "city")
    private List<Address> address;

//    public City(Integer id, String city_zip, String city_name, Country country) {
//        this.id = id;
//        this.city_zip = city_zip;
//        this.city_name = city_name;
//        this.country = country;
//    }

}
