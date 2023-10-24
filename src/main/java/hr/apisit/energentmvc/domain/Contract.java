package hr.apisit.energentmvc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="CONTRACT")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CONTRACT_TYPE_ID")
    private ContractType contractType;

    @ManyToOne
    @JoinColumn(name = "HOUSEHOLD_ID")
    private Household household;

    @ManyToOne
    @JoinColumn(name = "SERVICE_ID")
    private ServiceSP serviceSP;

    @Column(name="start_date")
    private LocalDate start_date;

    @Column(name="end_date")
    private LocalDate enddate;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

}
