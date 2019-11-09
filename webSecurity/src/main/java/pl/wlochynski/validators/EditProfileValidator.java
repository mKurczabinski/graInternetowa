package pl.wlochynski.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.wlochynski.constants.WebSecurityConstants;
import pl.wlochynski.models.User;
import pl.wlochynski.utilites.WebSecurityUtils;

public class EditProfileValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		// TODO Auto-generated method stub
		return User.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		User u = (User) obj;

		ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");

		if (!u.getEmail().equals(null)) {
			boolean isMatch = WebSecurityUtils.checkEmailOrPassword(WebSecurityConstants.EMAIL_PATTERN, u.getEmail());
			if (!isMatch) {
				errors.rejectValue("email", "error.userEmailIsNotMatch");
			}
		}
	}

}
