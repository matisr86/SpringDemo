package pl.mr.demoapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mr.demoapp.validators.UserRegisterValidator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.sql.Struct;
import java.util.Locale;

@Controller
public class RegisterUserContoller {

    @Autowired
    private UserService userService ;

    @Autowired
    MessageSource messageSource;

    @GET
    @RequestMapping(value = "/register")
    public String registerForm(Model model){
        User u = new User() ;
        model.addAttribute("user" , u);
        return "register";
    }

    @POST
    @RequestMapping("/addUser")
    public String registerAction(User user, BindingResult result, Model model, Locale locale){
        String returnPage = null;
        User userExist= userService.findUserByEmail(user.getEmail()) ;
        new UserRegisterValidator().validate(user, result);
        if (userExist!= null){
            result.rejectValue("email" , messageSource.getMessage("error.userEmailExist",null,locale));
        }
        if (result.hasErrors()){
            returnPage = "register" ;
        }else {
            userService.saveUser(user);
            model.addAttribute("message", messageSource.getMessage("user."))
        }

    }
}
