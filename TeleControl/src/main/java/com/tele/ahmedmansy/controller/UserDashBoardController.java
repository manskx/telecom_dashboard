package com.tele.ahmedmansy.controller;

import java.util.List;
import java.util.Locale;

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
@RequestMapping("/userdashboard")
@SessionAttributes("roles")
public class UserDashBoardController {
	/**
	 * This is the controller of the user dashboard 
	 * it contains all required services or routes to be used,
	 * the main route mapping for this controller is "/userdashboard"
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
	
	@RequestMapping(value = { "/", "/profile" }, method = RequestMethod.GET)
	public String UserProfile(ModelMap model) {

		String LoggedUserName = getPrincipal();
		User LoggedUser = userService.findByPhoneID(LoggedUserName);
		if (LoggedUser.getType() == "ADMIN")
			return "userslist";

		// model.addAttribute("users", users);

		model.addAttribute("loggedinuser", LoggedUser);
		return "profile";
	}
	/**
	 * This method maps to package subscription to view current
	 * package and subscribe , unsubscribe, and view details of the subscribed package
	 */
	@RequestMapping(value = { "/internetpackage" }, method = RequestMethod.GET)
	public String internetPackage(ModelMap model) {

		List<InternetPackage> iservices = internetpackageService.findAllInternetPackages();
		model.addAttribute("iservices", iservices);
		String LoggedUserName = getPrincipal();
		User LoggedUser = userService.findByPhoneID(LoggedUserName);
		model.addAttribute("loggedinuser", LoggedUser);

		// get activated internet package
		UserInternetPackage CurrentSubscribtion = userinternetpackageService
				.getActivatedUsersInternetPackageByUserID(LoggedUser.getId());

		InternetPackage CurrentUsedInternetPackage = (CurrentSubscribtion != null)
				? internetpackageService.findById(CurrentSubscribtion.getInternetPackageID()) : null;
		// inject current package details to view
		model.addAttribute("activeiservice", CurrentUsedInternetPackage);
		model.addAttribute("CurrentSubscribtion", CurrentSubscribtion);
		return "internetpackage";
	}
	/**
	 * This method maps to package subscription with package ID
	 */
	@RequestMapping(value = { "/internetpackage-subscribe-{packageID}" }, method = RequestMethod.GET)
	public String internetpackageSubscribe(@PathVariable String packageID, ModelMap model) {

		User LoggedUser = getLoggedUser();
		if (userinternetpackageService.ifUserSubscribedBefore(LoggedUser.getId())) {
			model.addAttribute("SubscribeError", messageSource.getMessage("subscribe.before.internetpackage",
					new String[] { "a" }, Locale.getDefault()));
			return "redirect:/userdashboard/internetpackage";
		}

		InternetPackage currentInternetPackage = internetpackageService.findById(Integer.parseInt(packageID));
		if (!userService.ifHasEnoughCredit(LoggedUser.getId(), currentInternetPackage.getFees())) {
			model.addAttribute("SubscribeError",
					messageSource.getMessage("enough.credit", new String[] { "Internet" }, Locale.getDefault()));
			return "redirect:/userdashboard/internetpackage";
		}
		// new package Subscription
		UserInternetPackage NewSubscription = new UserInternetPackage();
		NewSubscription.setActivated(true);
		NewSubscription.setUserID(LoggedUser.getId());
		NewSubscription.setInternetPackageID(currentInternetPackage.getId());
		// deduct package fees from user credit
		
		LoggedUser.setCredit(LoggedUser.getCredit()-currentInternetPackage.getFees());
		userService.updateUser(LoggedUser);
		userinternetpackageService.saveUserInternetPackage(NewSubscription);
		model.addAttribute("loggedinuser", LoggedUser);

		return "redirect:/userdashboard/internetpackage";
	}
	
	/**
	 * This method maps to package Unsubscription with package ID
	 */
	@RequestMapping(value = { "/internetpackage-unsubscribe-{subscribepackageID}" }, method = RequestMethod.GET)
	public String internetpackageUnSubscribe(@PathVariable String subscribepackageID, ModelMap model) {

		User LoggedUser = getLoggedUser();
		if (!userinternetpackageService.ifUserSubscribedBefore(LoggedUser.getId())) {
			System.out.println("User is not subscribed before");
			model.addAttribute("SubscribeError", messageSource.getMessage("subscribe.before.internetpackage",
					new String[] { "a" }, Locale.getDefault()));
			return "redirect:/userdashboard/internetpackage";
		}

		UserInternetPackage NewSubscription = userinternetpackageService.findById(Integer.parseInt(subscribepackageID));

		// set package activated to false
		NewSubscription.setActivated(false);
		userinternetpackageService.updateUserInternetPackage(NewSubscription);

		model.addAttribute("loggedinuser", LoggedUser);

		return "redirect:/userdashboard/internetpackage";
	}
	
	/**
	 * This method maps to package subscription to view current
	 * package and subscribe , unsubscribe, and view details of the subscribed package
	 */
	@RequestMapping(value = { "/smscallpackage" }, method = RequestMethod.GET)
	public String smscallpackage(ModelMap model) {

		List<SmsCallPackage> iservices = smsCallpackageService.findAllSmsCallPackages();
		model.addAttribute("iservices", iservices);
		String LoggedUserName = getPrincipal();
		User LoggedUser = userService.findByPhoneID(LoggedUserName);
		model.addAttribute("loggedinuser", LoggedUser);

		// get activated internet package

		UserSmsCallPackage CurrentSubscribtion = usersmsCallpackageService
				.getActivatedUsersSmsCallPackageByUserID(LoggedUser.getId());

		SmsCallPackage CurrentUsedSmsCallPackage = (CurrentSubscribtion != null)
				? smsCallpackageService.findById(CurrentSubscribtion.getSmsCallPackageID()) : null;

		model.addAttribute("activeiservice", CurrentUsedSmsCallPackage);
		model.addAttribute("CurrentSubscribtion", CurrentSubscribtion);
		return "smsCallpackage";
	}
	/**
	 * This method maps to package Unsubscription with package ID
	 */
	@RequestMapping(value = { "/smsCallpackage-unsubscribe-{subscribepackageID}" }, method = RequestMethod.GET)
	public String smsCallpackageUnSubscribe(@PathVariable String subscribepackageID, ModelMap model) {

		User LoggedUser = getLoggedUser();
		if (!usersmsCallpackageService.ifUserSubscribedBefore(LoggedUser.getId())) {
			System.out.println("User is not subscribed before");
			model.addAttribute("SubscribeError", messageSource.getMessage("subscribe.before.smsCallpackage",
					new String[] { "a" }, Locale.getDefault()));
			return "redirect:/userdashboard/smsCallpackage";
		}

		UserSmsCallPackage NewSubscription = usersmsCallpackageService.findById(Integer.parseInt(subscribepackageID));

		NewSubscription.setActivated(false);
		usersmsCallpackageService.updateUserSmsCallPackage(NewSubscription);
		model.addAttribute("loggedinuser", LoggedUser);
		return "redirect:/userdashboard/smscallpackage";
	}
	
	/**
	 * This method maps to package subscription with package ID
	 */
	@RequestMapping(value = { "/smsCallpackage-subscribe-{packageID}" }, method = RequestMethod.GET)
	public String smsCallpackageSubscribe(@PathVariable String packageID, ModelMap model) {

		User LoggedUser = getLoggedUser();
		if (usersmsCallpackageService.ifUserSubscribedBefore(LoggedUser.getId())) {
			model.addAttribute("SubscribeError", messageSource.getMessage("subscribe.before.smsCallpackage",
					new String[] { "a" }, Locale.getDefault()));
			return "redirect:/userdashboard/smscallpackage";
		}

		SmsCallPackage currentSmsCallPackage = smsCallpackageService.findById(Integer.parseInt(packageID));
		if (!userService.ifHasEnoughCredit(LoggedUser.getId(), currentSmsCallPackage.getFees())) {
			model.addAttribute("SubscribeError",
					messageSource.getMessage("enough.credit", new String[] { "SmsCall" }, Locale.getDefault()));
			return "redirect:/userdashboard/smscallpackage";
		}

		UserSmsCallPackage NewSubscription = new UserSmsCallPackage();
		NewSubscription.setActivated(true);
		NewSubscription.setUserID(LoggedUser.getId());
		NewSubscription.setSmsCallPackageID(currentSmsCallPackage.getId());
		
		// deduct package fees from user credit

		LoggedUser.setCredit(LoggedUser.getCredit()-currentSmsCallPackage.getFees());
		userService.updateUser(LoggedUser);
		usersmsCallpackageService.saveUserSmsCallPackage(NewSubscription);
		model.addAttribute("loggedinuser", LoggedUser);

		return "redirect:/userdashboard/smscallpackage";
	}
	
	@RequestMapping(value = { "/creditcharging" }, method = RequestMethod.GET)
	public String creditCharging(ModelMap model) {

		User LoggedUser = getLoggedUser();
		model.addAttribute("loggedinuser", LoggedUser);

		return "chargecredit";
	}

	/**
	 *This method handles post requests for charge user's credit
	 *
	 */
	@RequestMapping(value = { "/creditcharging" }, method = RequestMethod.POST)
	public String creditChargingCheck( ChargeCard card, BindingResult result, ModelMap model) {
		User LoggedUser = getLoggedUser();
		System.out.println(card.toString());
		ChargeCard userChargeCard = chargeCardService.findByCode(card.getCode());
		if (userChargeCard == null || userChargeCard.isUsed()) {

			model.addAttribute("chargeerror", true);
			model.addAttribute("loggedinuser", LoggedUser);
			return "chargecredit";
		}
		LoggedUser.setCredit(LoggedUser.getCredit() + userChargeCard.getValue());
		userChargeCard.setUsed(true);
		chargeCardService.updateChargeCard(userChargeCard);
		userService.updateUser(LoggedUser);
		model.addAttribute("chargesuccess", true);
		model.addAttribute("loggedinuser", LoggedUser);
		return "chargecredit";
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
	
	
}