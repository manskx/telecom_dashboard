# README #
8
Note: This is sample project for using some technologies


### Contents ###

* TeleControl - Eclipse Project
* tele_db.sql - database file

### Technologies used: ###

-	Spring 4.2.5.RELEASE.
-	Spring Security 4.0.4.RELEASE.
-	Hibernate Core 4.3.11.Final.
-	validation-api 1.1.0.Final.
-	hibernate-validator 5.1.3.Final.
-	MySQL Server.
-	Maven 3.
-	Tomcat 8.0.33.
-	Eclipse MARS.2 Release 4.5.2.
-	Bootstrap 3.
-	Ace Bootstrap Theme.

### Technical features: ###

-	Secure login model.
-	Encrypted password using BCrypt.
-	Provide RememberMe functionality using PersistentTokenRepository.
-	CSRF token protection.
-	Secure registration model.
-	Unique email/phone number in registration.
-	Random generating single usage 14 digit credit charging code.
-	Tracking application in console log using logback.
-	MCV-based architecture.

### How do I get set up? ###

* Deploy war file in your tomcat server
* Configure database with the provided schema or import the provided backup.
* Configure database configurations in "application.properties" file.
* Pre-defined admin user is user: 01220002323 pass: admin123
* you can register new users.
* If you want to change user type we can do it manually in database from type "USER" to "ADMIN"

##########Info###########

* ahmed.mansy156@gmail.com
