package pl.larys.prestige.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.larys.prestige.domain.entity.Role;

/**
 * Created by piotr on 02.07.16.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
