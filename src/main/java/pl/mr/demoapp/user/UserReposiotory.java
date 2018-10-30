package pl.mr.demoapp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserReposiotory extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
}
