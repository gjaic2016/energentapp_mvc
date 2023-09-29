package hr.apisit.energentmvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String address;

    @ManyToOne
    private City city;

    @OneToOne(mappedBy = "adresa")
    @JsonIgnore
    private ServiceProvider provider;
//    fetch = FetchType.LAZY
}
