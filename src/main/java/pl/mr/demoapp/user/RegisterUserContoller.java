package pl.mr.demoapp.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
public class RegisterUserContoller {

    @GET
    @RequestMapping(value = "/register")
    public String registerForm(Model model){
        User u = new User() ;
        model.addAttribute("user" , u);
        return "register";
    }
}
