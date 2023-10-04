package hr.apisit.energentmvc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Role {

    @Id
    private Integer id;

    @Column(name = "ROLE_NAME")
    private String rolename;
}
