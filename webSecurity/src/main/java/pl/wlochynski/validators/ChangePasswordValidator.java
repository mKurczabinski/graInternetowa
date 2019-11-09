package pl.wlochynski.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.wlochynski.constants.WebSecurityConstants;
import pl.wlochynski.models.User;
import pl.wlochynski.utilites.WebSecurityUtils;

public class ChangePasswordValidator implements Validator {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean supports(Class<?> cls) {
		return User.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		User u = (User) obj;

		ValidationUtils.rejectIfEmpty(errors, "newPassword", "error.userPassword.empty");
		ValidationUtils.rejectIfEmpty(errors, "comparePassword", "error.error.oldPassword.empty");
	}

	public void checkPasswords(String newPass, Errors errors) {
		if (!newPass.equals(null)) {
			boolean isMatch = WebSecurityUtils.checkEmailOrPassword(WebSecurityConstants.PASSWORD_PATTERN, newPass);
			if (!isMatch) {
				errors.rejectValue("newPassword", "error.userPasswordIsNotMatch");
			}
		}
	}

	public void comparePasswords(String oldPass, String comparePass, Errors errors) {
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		if (!comparePass.equals(null)) {
			if (!bCryptPasswordEncoder.matches(comparePass, oldPass)) {
					errors.rejectValue("comparePassword", "error.oldPasswordNotMatch");
			}
		}

	}
}
