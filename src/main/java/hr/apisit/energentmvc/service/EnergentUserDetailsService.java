package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.jpaRepository.UserRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnergentUserDetailsService implements UserDetailsService {

    private UserRepositoryJpa userRepositoryJpa;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        hr.apisit.energentmvc.domain.User user = userRepositoryJpa.findByUsername(username);

        List<SimpleGrantedAuthority> grantedAuthorityList =
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(
                                role.getRolename()))
                        .toList();

        return new User(user.getUsername(),
                user.getPassword(),
                grantedAuthorityList);
    }

}
