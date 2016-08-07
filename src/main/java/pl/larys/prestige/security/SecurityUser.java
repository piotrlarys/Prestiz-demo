package pl.larys.prestige.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.larys.prestige.domain.entity.Employee;
import pl.larys.prestige.domain.entity.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by piotr on 09.07.16.
 */
public class SecurityUser extends Employee implements UserDetails {

    private static final long serialVersionUID = 1L;

    public SecurityUser(Employee employee) {
        if(employee != null)
        {
            this.setId(employee.getId());
            this.setEmail(employee.getEmail());
            this.setPassword(employee.getPassword());
            this.setRoles(employee.getRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> userRoles = this.getRoles();

        if(userRoles != null)
        {
            for (Role role : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
