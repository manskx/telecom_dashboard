package com.tele.ahmedmansy.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tele.ahmedmansy.model.ChargeCard;
import com.tele.ahmedmansy.model.InternetPackage;
import com.tele.ahmedmansy.model.SmsCallPackage;
import com.tele.ahmedmansy.model.User;
import com.tele.ahmedmansy.model.UserInternetPackage;
import com.tele.ahmedmansy.model.UserSmsCallPackage;
import com.tele.ahmedmansy.service.ChargeCardService;
import com.tele.ahmedmansy.service.InternetPackageService;
import com.tele.ahmedmansy.service.SmsCallPackageService;
import com.tele.ahmedmansy.service.UserInternetPackageService;
//import com.telecommunication.ahmedmansy.model.UserProfile;
//import com.telecommunication.ahmedmansy.service.UserProfileService;
import com.tele.ahmedmansy.service.UserService;
import com.tele.ahmedmansy.service.UserSmsCallPackageService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
	/**
	 * This is the main controller 
	 * it contains all required services or routes to be used for the visitor,
	 * the main route mapping for this controller is "/"
	 */
	
	@Autowired
	UserService userService;

	@Autowired
	InternetPackageService internetpackageService;
	@Autowired
	UserInternetPackageService userinternetpackageService;

	@Autowired
	SmsCallPackageService smsCallpackageService;
	@Autowired
	UserSmsCallPackageService usersmsCallpackageService;

	@Autowired
	ChargeCardService chargeCardService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	/**
	 * This method will redirect user to the right dashboard
	 */
	@RequestMapping(value = { "/", "/profile" }, method = RequestMethod.GET)
	public String UserProfile(ModelMap model) {

		String LoggedUserName = getPrincipal();
		User LoggedUser = userService.findByPhoneID(LoggedUserName);
		if (LoggedUser.getType().equals("ADMIN"))
			return "redirect:/admindashboard/";

		else if(LoggedUser.getType().equals("USER"))
			return "redirect:/userdashboard/";


		return "redirect:/login";

	}

	/**
	 * This method will provide adding new user.
	 */
	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("reg", true);
		// model.addAttribute("loggedinuser", getPrincipal());

		return "login";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {
		model.addAttribute("reg", true);

		if (!userService.isUserPhoneIDUnique(user.getId(), user.getPhoneID())) {
			FieldError phoneIDError = new FieldError("user", "phoneID", messageSource.getMessage("non.unique.phoneId",
					new String[] { user.getPhoneID() }, Locale.getDefault()));
			result.addError(phoneIDError);
			return "login";
		}

		if (!userService.isUserEmailUnique(user.getId(), user.getEmail())) {
			FieldError emailError = new FieldError("user", "email", messageSource.getMessage("non.unique.email",
					new String[] { user.getEmail() }, Locale.getDefault()));
			result.addError(emailError);
			return "login";
		}

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors().toString());
			System.out.println("ERRORRROR"+user.toString());
			return "login";
		}

		System.out.println(user.toString());
		userService.saveUser(user);
		System.out.println(user.toString());

		model.addAttribute("success", "User " + user.getName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		// return "success";
		model.addAttribute("reg_success", true);
		return "login";
	}
	
	/**
	 * This method us used to handle post request for lost password
	 * the work flow id lost password is the following:
	 * - user should set a foget password answer when he registed
	 * - used is asked for his email address and the question he set when registration
	 * - System generates new temporary password for the user 
	 *  * Another workflow can be used sending email contains new passwod 
	 *  * SMTP server should implemented.
	 */
	@RequestMapping(value = { "/lostpassword" }, method = RequestMethod.POST)
	public String lostpasswordUser(@Valid User user, BindingResult result, ModelMap model) {
		model.addAttribute("lostpass", true);
		// if the email not found
		if (userService.isUserEmailUnique(user.getId(), user.getEmail())) {
			FieldError emailError = new FieldError("user", "email", messageSource.getMessage("non.registered.email",
					new String[] { user.getEmail() }, Locale.getDefault()));
			result.addError(emailError);
			model.addAttribute("lostpass_error", true);
			return "login";
		}
		
		User RegistredUser	=	userService.findByEmail(user.getEmail());
		// if the answer if not right
		if(!RegistredUser.getLostpassanswer().equals(user.getLostpassanswer())){
			FieldError LostpassanswerError = new FieldError("user", "lostpassanswer", messageSource.getMessage("non.registered.email",
					new String[] { user.getEmail() }, Locale.getDefault()));
			result.addError(LostpassanswerError);
			model.addAttribute("lostpass_error", true);
			return "login";
		}
		
		String NewPassword	=	generateTempPassword();
		RegistredUser.setPassword(NewPassword);
		userService.updateUser(RegistredUser);
		// add data to be viwed in the view
		model.addAttribute("success", "User " + user.getName() + " Changed Password successfully");
		model.addAttribute("loggedinuser", getPrincipal());		
		model.addAttribute("NewPassword", NewPassword);
		model.addAttribute("lostpass_success", true);
		return "login";
	}
	
	/**
	 * 
	 * @return random string number with length of 14
	 */
	private String generateTempPassword() {
		int length = 6;
		String Code = "";
		for (int i = 0; i < length; i++) {
			Code += (int) (Math.random() * 9);
		}
		return Code;
	}

	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getLoggedUser());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests. If users is already logged-in and
	 * tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		if (isCurrentAuthenticationAnonymous()) {
			model.addAttribute("login", true);
			return "login";
		} else {

			return "redirect:/profile";
		}
	}

	/**
	 * This method handles logout requests. 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			// new SecurityContextLogoutHandler().logout(request, response,
			// auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}
	
	private User getLoggedUser() {
		String LoggedUserName = getPrincipal();
		User LoggedUser = userService.findByPhoneID(LoggedUserName);
		return LoggedUser;
	}
		
	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	/**
	 * This method returns true if users is already authenticated [logged-in],
	 * else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}

}