package com.tele.ahmedmansy.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
import com.tele.ahmedmansy.service.UserService;
import com.tele.ahmedmansy.service.UserSmsCallPackageService;

@Controller
@RequestMapping("/admindashboard")
@SessionAttributes("roles")
public class AdminDashBoardController {
	/**
	 * This is the controller of the admin dashboard 
	 * it contains all required services or routes to be used,
	 * the main route mapping for this controller is "/admindashboard"
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
	 * This is the main dashboard mapping for admin 
	 */
	@RequestMapping(value = { "/", "/profile" }, method = RequestMethod.GET)
	public String UserProfile(ModelMap model) {

		String LoggedUserName = getPrincipal();
		User LoggedUser = userService.findByPhoneID(LoggedUserName);
		if (!LoggedUser.getType().equals("ADMIN"))
			return "redirect:/login";

		
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		
		List<ChargeCard> cards = chargeCardService.findAllChargeCards();
		model.addAttribute("cards", cards);
		
		model.addAttribute("loggedinuser", LoggedUser);
		return "profile";
	}
	
	/**
	 * This method provides the admin to generate charging cards to be used by users
	 */
	@RequestMapping(value = { "/generatecreditcharging" }, method = RequestMethod.GET)
	public String generateCreditCharging(ModelMap model) {
		// generate 10 cards with 10 LE
		for (int i = 0; i < 10; i++) {
			ChargeCard generatedChargeCard = new ChargeCard();
			generatedChargeCard.setCode(generateChargeCode());
			generatedChargeCard.setValue(10);
			generatedChargeCard.setUsed(false);
			chargeCardService.saveChargeCard(generatedChargeCard);
		}
		
		// generate 10 cards with 20 LE
		for (int i = 0; i < 10; i++) {
			ChargeCard generatedChargeCard = new ChargeCard();
			generatedChargeCard.setCode(generateChargeCode());
			generatedChargeCard.setValue(20);
			generatedChargeCard.setUsed(false);
			chargeCardService.saveChargeCard(generatedChargeCard);

		}

		User LoggedUser = getLoggedUser();
		model.addAttribute("loggedinuser", LoggedUser);
		return "chargecredit";
	}
	
	/**
	 * This method will provide the medium to update an existing user. 
	 * ## note completed yet
	
	@RequestMapping(value = { "/edit-user-{phoneID}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String phoneID, ModelMap model) {
		User user = userService.findByPhoneID(phoneID);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	 */
	/**
	 * This method will be used to edit user from admin dashboard.
	 * ## note completed yet
	@RequestMapping(value = { "/edit-user-{phoneID}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable String phoneID) {

		if (result.hasErrors()) {
			return "registration";
		}

		userService.updateUser(user);

		model.addAttribute("success", "User " + user.getName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	*/
	
	/**
	 * This method will delete an user by it's phoneID value.
	 * #Note: it is not visible in the GUI
	 */
	@RequestMapping(value = { "/delete-user-{phoneID}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String phoneID) {
		userService.deleteUserByPhoneID(phoneID);
		return "redirect:/admindashboard/profile";
	}	
	
	/**
	 * 
	 * @return random string number with length of 14
	 */
	private String generateChargeCode() {
		int length = 14;
		String Code = "";
		for (int i = 0; i < length; i++) {
			Code += (int) (Math.random() * 9);
		}
		return Code;
	}
	
	/**
	 * This method returns the the logged-in user.
	 */
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
		
}