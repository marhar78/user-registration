#User Registration Plugin

##Registration Servlet
###Use
This plugin is used to kick off a user registration process with form data.
###Url
<site-url>/suite/servlet/plugins/registration
###Required Rules
* **cons!COMMON_CAPTCHA_PRIVATE_KEY** 											reCaptcha Private key used for Registration page
* **cons!COMMON_CAPTCHA_PUBLIC_KEY**  											reCaptcha Public key used for Registration page
* **cons!TERMS_LINK**                 											used for terms and conditions link on login page
* **cons!COMMON_REGISTRATION_MODEL_UUID** 										used to select model for Registration
* **rule!COMMON_isUsernameTaken** 												used to determine if username is taken
* **rule!COMMON_doesOrganisationExist** 										used to determine if organisation name is taken
* **rule!COMMON_isUsernameActive**												used to determine if username is active
* **cons!COMMON_TERMS_LINK**													url of terms and conditions link
* **cons!COMMON_PLUGIN_REGISTRATION_DISCLAIMER** 								Registration disclaimer text
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_MAX_LENGTH_LAST_NAME**	   			Message to display if the maximum number of characters are surpassed for last name
* **cons!COMMON_PLUGIN_REGISTRATION_MAX_LENGTH_LAST_NAME**						Maximum character length of last name field
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_MAX_LENGTH_FIRST_NAME**				Message to display if the maximum number of characters are surpassed for first name
* **cons!COMMON_PLUGIN_REGISTRATION_MAX_LENGTH_FIRST_NAME**						Maximum character length of first name field
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_MAX_LENGTH_PRIMARY_PHONE_NUMBER**	Maximum character length message of primary phone number field
* **cons!COMMON_PLUGIN_REGISTRATION_MAX_LENGTH_PRIMARY_PHONE_NUMBER**			Maximum character length of primary phone number field
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_MAX_LENGTH_SECONDARY_PHONE_NUMBER**	Maximum character length message of secondary phone number field
* **cons!COMMON_PLUGIN_REGISTRATION_MAX_LENGTH_SECONDARY_PHONE_NUMBER**			Maximum character length of secondary phone number field
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_MAX_LENGTH_OTHER_TITLE**			Maximum character length message of other title field
* **cons!COMMON_PLUGIN_REGISTRATION_MAX_LENGTH_OTHER_TITLE**					Maximum character length of other title field
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_DIGIT_PRIMARY_PHONE_NUMBER** 		Validation message on primary phone number field if digits are not used
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_DIGIT_SECONDARY_PHONE_NUMBER**		Validation message on secondary phone number field if digits are not used
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_VALID_EMAIL**						Validation message on email
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_EMAIL**					Required validation message on email
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_TITLE**					Required validation message on title
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_OTHER_TITLE** 				Required validation message on other title
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_FIRST_NAME**				Required validation message on first name
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_LAST_NAME**				Required validation message on last name
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_TERMS**					Required validation on terms and conditions acceptance
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_PRIMARY_PHONE_NUMBER**		Required validation message on primary phone number
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_ACCOUNT_TYPE**				Required validation message on account type field
* **cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_CAPTCHA**					Required validation message on reCAPTCHA
* **cons!COMMON_DSDIP_EMAIL_ADDRESS**
* **cons!COMMON_PLUGIN_REGISTRATION_HTML_EXISTING_PAGE**						HTML text for existing user result page
* **cons!COMMON_PLUGIN_REGISTRATION_HTML_FAILED_PAGE**							HTML text for registration failed page
* **cons!COMMON_PLUGIN_REGISTRATION_HTML_SUCCESS_PAGE**							HTML text for successful registration submission page
* **rule!COMMON_componentDropDownPlaceholder**									Placeholder text for a dropdown list
* **cons!COMMON_SAIL_DISPLAY_USER_TITLES**										User titles label array
* **cons!COMMON_SAIL_CODE_USER_TITLES**											User titles value array
* **cons!COMMON_SAIL_DISPLAY_SERVICE_COUNTRYLIST**								Country label array
* **cons!COMMON_SAIL_CODE_SERVICE_COUNTRYLIST**									Country value array
* **cons!COMMON_SAIL_DISPLAY_SERVICE_TITLES**									Job titles label array
* **cons!COMMON_SAIL_CODE_SERVICE_TITLES**										Job titles value array
* **cons!COMMON_PAGE_TITLE														Page title to be displayed

