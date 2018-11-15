package pl.mr.demoapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

@Autowired
private UserReposiotory userReposiotory ;

@Autowired
private RoleRepository roleRepository ;

@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoderl;


    @Override
    public User findUserByEmail(String email) {
        return userReposiotory.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoderl.encode(user.getPassword()));
        user.setActive(1);

        Role role = roleRepository.findByRole("ROLE_USER") ;
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));

        userReposiotory.save(user) ;
    }

    @Override
    public void updateUserPassword(String newPassword, String email) {
        userReposiotory.updateUserPassword(bCryptPasswordEncoderl.encode(newPassword), email);

    }


}
