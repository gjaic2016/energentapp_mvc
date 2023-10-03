package hr.apisit.energentmvc.domain;

import jakarta.persistence.*;
import lombok.*;

//@Data
@Getter
@Setter
@Entity
@Table(name = "ADDRESS")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="address")
    private String addressname;

    @ManyToOne
    @JoinColumn(name = "city_id",referencedColumnName = "id")
    private City city;

//    @OneToOne(mappedBy = "adresa")
//    @JsonIgnore
//    private ServiceProvider provider;

}
