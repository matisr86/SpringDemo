package pl.mr.demoapp.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.mr.demoapp.constants.AppDemoConstants;
import pl.mr.demoapp.user.User;
import pl.mr.demoapp.utilities.AppDemoUtils;

public class UserRegisterValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User u = (User) o ;

        ValidationUtils.rejectIfEmpty(errors,"name", "error.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "email" , "error.userEmail.empty");
        ValidationUtils.rejectIfEmpty(errors, "password" , "error.userPassword");

        if(!u.getEmail().equals(null)){
            boolean isMatch = AppDemoUtils.checkEmailOrPassword(AppDemoConstants.emailPattern, u.getEmail());
            if(!isMatch){
                errors.rejectValue("email" , "error.userEmailIsNotMatch");
            }
        }

        if(!u.getPassword().equals(null)){
            boolean isMatch = AppDemoUtils.checkEmailOrPassword(AppDemoConstants.passwordPattern, u.getPassword());
            if(!isMatch){
                errors.rejectValue("password" , "error.userPasswordIsNotMatch");
            }
        }
    }

    public void validateEmailExist(User user, Errors errors) {
         if (user != null){
             errors.rejectValue("email" , "error.userEmailExist");
         }
    }
}
