package hr.apisit.energentmvc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

//    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="USER_ROLE",
            joinColumns=@JoinColumn(name="USERID"),
            inverseJoinColumns = @JoinColumn(name="ROLEID"))
    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, password, roles);
    }
}
