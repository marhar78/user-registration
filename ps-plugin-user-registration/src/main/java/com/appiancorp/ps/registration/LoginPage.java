package com.appiancorp.ps.registration;

public class LoginPage {

// MISC 	-------------------------------------------------------------

	private String siteName;
	private String logoUri;
	private String favicon;
	private String loginCss;
	private String form;
	private String terms;
	private String titles;
	private String publicKey;
	private String contactEmail;
	private String existingUserPageHTML;
	private String failedPageHTML;
	private String successPageHTML;
	private String disclaimer;
	private String services;
	private String compTypes;
	private String orgTypes;
	private String countryList;
	private String pageTitle;

// VALIDATION TRIGGERS	--------------------------------------------------
//
//	LENGTH

	private String maxLengthOtherTitle;
	private String maxLengthFirstName;
	private String maxLengthLastName;	
	private String maxLengthPrimaryPhoneNumber;
	private String maxLengthSecondaryPhoneNumber;	

	
//	
//	
// VALIDATION MESSAGES	--------------------------------------------------
//	
//	LENGTH
	private String messageMaxLengthPrimaryPhoneNumber;
	private String messageMaxLengthSecondaryPhoneNumber;

	private String messageMaxLengthOtherTitle;
	private String messageMaxLengthFirstName;
	private String messageMaxLengthLastName;	
//		

//	EMAIL
	private String messageValidEmail;
	
//	
//	
//	DIGIT
	private String messageDigitPrimaryPhoneNumber;
	private String messageDigitSecondaryPhoneNumber;	
//		
//	REQUIRED
	private String messageRequiredEmail;
	private String messageRequiredTitle;	
	private String messageRequiredOtherTitle;
	private String messageRequiredFirstName;
	private String messageRequiredLastName;	
	private String messageRequiredTerms;		
	private String messageRequiredPrimaryPhoneNumber;
	private String messageRequiredAccountType;	
	private String messageRequiredCaptcha;	
//	

//	
// FUNCTIONS	--------------------------------------------------
	
	public LoginPage() {};

	public void setSiteName(String val) {
		this.siteName = val;
	}
	public String getSiteName() {
		return this.siteName;
	}
	
	public void setLogoUri(String val) {
		this.logoUri = val;
	}
	public String getLogoUri() {
		return this.logoUri;
	}
	
	public void setFavicon(String val) {
		this.favicon = val;
	}
	public String getFavicon() {
		return this.favicon;
	}
	
	public void setLoginCss(String val) {
		this.loginCss = val;
	}
	public String getLoginCss() {
		return this.loginCss;
	}
	
	public void setForm(String val) {
		this.form = val;
	}
	public String getForm() {
		return this.form;
	}
	
	public void setTerms(String val) {
		this.terms = val;
	}
	public String getTerms() {
		return this.terms;
	}
	
	public String getPageTitle() {
		return this.pageTitle;
	}
    public void setPageTitle(String val) {
    	this.pageTitle = val;
    }
	public void setDisclaimer(String val) {
		this.disclaimer = val;
	}
	public String getDisclaimer() {
		return this.disclaimer;
	}	
	
	public void setTitles(String val) {
		this.titles = val;
	}
	public String getTitles() {
		return this.titles;
	}
	public void setServices(String val) {
		this.services = val;
	}
	public String getServices() {
		return this.services;
	}
	public void setOrgTypes(String val) {
		this.orgTypes = val;
	}
	public String getOrgTypes() {
		return this.orgTypes;
	}
	public void setCompTypes(String val) {
		this.compTypes = val;
	}
	public String getCompTypes() {
		return this.compTypes;
	}
	public void setCountryList(String val) {
		this.countryList = val;
	}
	public String getCountryList() {
		return this.countryList;
	}
	public void setContactEmail(String val) {
		this.contactEmail = val;
	}
	public String getContactEmail() {
		return this.contactEmail;
	}	
				
	public void setExistingUserPageHTML(String val) {
		this.existingUserPageHTML = val;
	}
	public String getExistingUserPageHTML() {
		return this.existingUserPageHTML;
	}	

	public void setFailedPageHTML(String val) {
		this.failedPageHTML = val;
	}
	public String getFailedPageHTML() {
		return this.failedPageHTML;
	}	
	
	public void setSuccessPageHTML(String val) {
		this.successPageHTML = val;
	}
	public String getSuccessPageHTML() {
		return this.successPageHTML;
	}	
	
	public void setPublicKey(String val) {
		this.publicKey = val;
	}
	public String getPublicKey() {
		return this.publicKey;
	}	

	public void setMessageMaxLengthPrimaryPhoneNumber(String val) {
		this.messageMaxLengthPrimaryPhoneNumber = val;
	}
	public String getMessageMaxLengthPrimaryPhoneNumber() {
		return this.messageMaxLengthPrimaryPhoneNumber;
	}

	public void setMessageMaxLengthSecondaryPhoneNumber(String val) {
		this.messageMaxLengthSecondaryPhoneNumber = val;
	}
	public String getMessageMaxLengthSecondaryPhoneNumber() {
		return this.messageMaxLengthSecondaryPhoneNumber;
	}
	
	
	public void setMessageMaxLengthLastName(String val) {
		this.messageMaxLengthLastName = val;
	}
	public String getMessageMaxLengthLastName() {
		return this.messageMaxLengthLastName;
	}

	public void setMaxLengthLastName(String val) {
		this.maxLengthLastName = val;
	}
	public String getMaxLengthLastName() {
		return this.maxLengthLastName;
	}
		
	public void setMessageMaxLengthFirstName(String val) {
		this.messageMaxLengthFirstName = val;
	}
	public String getMessageMaxLengthFirstName() {
		return this.messageMaxLengthFirstName;
	}

	public void setMaxLengthFirstName(String val) {
		this.maxLengthFirstName = val;
	}
	public String getMaxLengthFirstName() {
		return this.maxLengthFirstName;
	}
	
	public void setMessageMaxLengthOtherTitle(String val) {
		this.messageMaxLengthOtherTitle = val;
	}
	public String getMessageMaxLengthOtherTitle() {
		return this.messageMaxLengthOtherTitle;
	}

	public void setMaxLengthOtherTitle(String val) {
		this.maxLengthOtherTitle = val;
	}
	public String getMaxLengthOtherTitle() {
		return this.maxLengthOtherTitle;
	}

	public void setMaxLengthPrimaryPhoneNumber(String val) {
		this.maxLengthPrimaryPhoneNumber = val;
	}
	public String getMaxLengthPrimaryPhoneNumber() {
		return this.maxLengthPrimaryPhoneNumber;
	}

	public void setMaxLengthSecondaryPhoneNumber(String val) {
		this.maxLengthSecondaryPhoneNumber = val;
	}
	public String getMaxLengthSecondaryPhoneNumber() {
		return this.maxLengthSecondaryPhoneNumber;
	}

	
	public void setMessageValidEmail(String val) {
		this.messageValidEmail = val;
	}
	public String getMessageValidEmail() {
		return this.messageValidEmail;
	}
	
	public void setMessageDigitPrimaryPhoneNumber(String val) {
		this.messageDigitPrimaryPhoneNumber = val;
	}
	public String getMessageDigitPrimaryPhoneNumber() {
		return this.messageDigitPrimaryPhoneNumber;
	}
	
	public void setMessageDigitSecondaryPhoneNumber(String val) {
		this.messageDigitSecondaryPhoneNumber = val;
	}
	public String getMessageDigitSecondaryPhoneNumber() {
		return this.messageDigitSecondaryPhoneNumber;
	}
		
	public void setMessageRequiredEmail(String val) {
		this.messageRequiredEmail = val;
	}
	public String getMessageRequiredEmail() {
		return this.messageRequiredEmail;
	}
			
	public void setMessageRequiredTitle(String val) {
		this.messageRequiredTitle = val;
	}
	public String getMessageRequiredTitle() {
		return this.messageRequiredTitle;
	}
	
	public void setMessageRequiredOtherTitle(String val) {
		this.messageRequiredOtherTitle = val;
	}
	public String getMessageRequiredOtherTitle() {
		return this.messageRequiredOtherTitle;
	}

	public void setMessageRequiredFirstName(String val) {
		this.messageRequiredFirstName = val;
	}
	public String getMessageRequiredFirstName() {
		return this.messageRequiredFirstName;
	}
	
	public void setMessageRequiredLastName(String val) {
		this.messageRequiredLastName = val;
	}
	public String getMessageRequiredLastName() {
		return this.messageRequiredLastName;
	}

	public void setMessageRequiredTerms(String val) {
		this.messageRequiredTerms = val;
	}
	public String getMessageRequiredTerms() {
		return this.messageRequiredTerms;
	}
	
	public void setMessageRequiredPrimaryPhoneNumber(String val) {
		this.messageRequiredPrimaryPhoneNumber = val;
	}
	public String getMessageRequiredPrimaryPhoneNumber() {
		return this.messageRequiredPrimaryPhoneNumber;
	}

	public void setMessageRequiredAccountType(String val) {
		this.messageRequiredAccountType = val;
	}
	public String getMessageRequiredAccountType() {
		return this.messageRequiredAccountType;
	}	
	

	public void setMessageRequiredCaptcha(String val) {
		this.messageRequiredCaptcha = val;
	}
	public String getMessageRequiredCaptcha() {
		return this.messageRequiredCaptcha;
	}	
		
	



}

