package pl.mr.demoapp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleReposiotory")
public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findByRole(String role) ;

}
