package hr.apisit.energentmvc.domain;

import jakarta.persistence.*;
import lombok.*;

//@Data
@Getter
@Setter
@Entity
@Table(name = "SERVICE_PROVIDER")
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String naziv;

//    @OneToOne
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address adresa;

}
