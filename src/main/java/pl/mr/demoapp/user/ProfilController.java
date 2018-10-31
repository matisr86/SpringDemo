package pl.mr.demoapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mr.demoapp.utilities.UserUtilities;

import javax.ws.rs.GET;

@Controller
public class ProfilController {

    @Autowired
    private UserService userService ;


    @GET
    @RequestMapping(value = "/profil")
    public String showUserProfilePage(Model model){
        String userName = UserUtilities.getLoggedUser() ;

        User user = userService.findUserByEmail(userName) ;

        int numerRoli = user.getRoles().iterator().next().getId() ;
        user.setNrRoli(numerRoli);

        model.addAttribute("user", user) ;

        return "profil" ;
    }


}
