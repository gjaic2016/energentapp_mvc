package hr.apisit.energentmvc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Integer id;

    private String username;

    private String password;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="USER_ROLE",
            joinColumns=@JoinColumn(name="USERID"),
            inverseJoinColumns = @JoinColumn(name="ROLEID"))
    private Set<Role> roles;

}
