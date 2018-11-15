package pl.mr.demoapp.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.mr.demoapp.constants.AppDemoConstants;
import pl.mr.demoapp.user.User;
import pl.mr.demoapp.utilities.AppDemoUtils;

public class ChangePasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        @SuppressWarnings("unused")
                User u = (User) o ;

    }

    public void checkPasswords(String newPass, Errors errors){
        if(!newPass.equals(null)){
            boolean isMatch = AppDemoUtils.checkEmailOrPassword(AppDemoConstants.passwordPattern, newPass);
            if(!isMatch){
                errors.rejectValue("newPassword", "error.userPasswordInNotMatch");
            }
        }
    }
}
