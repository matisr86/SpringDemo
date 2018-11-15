package pl.mr.demoapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mr.demoapp.utilities.UserUtilities;
import pl.mr.demoapp.validators.ChangePasswordValidator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.Locale;

@Controller
public class ProfilController {

    @Autowired
    private UserService userService ;


    @GET
    @RequestMapping(value ="/editpassword")
    public String editUserPassword(Model model){
        String username= UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username) ;
        model.addAttribute("user", user);
        return "editpassword";
    }


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
