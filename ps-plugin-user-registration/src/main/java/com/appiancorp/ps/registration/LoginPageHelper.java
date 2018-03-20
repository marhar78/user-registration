package com.appiancorp.ps.registration;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.security.core.context.SecurityContext;

import com.appiancorp.common.config.ApplicationContextHolder;
import com.appiancorp.ps.registration.LoginPage;
import com.appiancorp.security.auth.SpringSecurityContextHelper;
import com.appiancorp.services.ServiceContext;
import com.appiancorp.suite.SuiteConfiguration;
import com.appiancorp.suite.cfg.ConfigurationFactory;
import com.appiancorp.suite.cfg.CustomBrandingService;
import com.appiancorp.suite.cfg.CustomBrandingServiceImplHelper;
import com.appiancorp.type.cdt.CustomBranding;


public class LoginPageHelper {
	
	private static final Logger LOG = Logger.getLogger(ExpressionHelper.class);
	
	/* This code is partially pulled from the include_branding.jsp */	
	public static void setBrandingStyle(ServiceContext sc, LoginPage reg) {

		final SecurityContext origSpringSecCtx = SpringSecurityContextHelper.getSpringSecurityContext();

		try {
			LOG.debug("Setting branding style");
			CustomBranding b;

			SpringSecurityContextHelper.setSpringSecurityContextLazy(sc.getName());
			b = ApplicationContextHolder.getBean(CustomBrandingService.class).getCustomBranding();

			LOG.debug("-- Setting Generic Variables");
			String logoUri = b.getLogoUri();
			reg.setLogoUri(logoUri);
			
			String pageTitle = (String)ExpressionHelper.evaluateExpression(sc,  "cons!COMMON_PAGE_TITLE");
			reg.setPageTitle(pageTitle);
			
			String defaultSelectLabel = (String)ExpressionHelper.evaluateExpression(sc, "rule!COMMON_componentDropDownPlaceholder()");
			JSONArray orgTypedisplayLabels = (JSONArray)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_SAIL_DISPLAY_SERVICE_ORGTYPES");
			JSONArray orgTypedisplayValue = (JSONArray)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_SAIL_CODE_SERVICE_ORGTYPES");
			  
			JSONArray countryDisplayLabels = (JSONArray)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_SAIL_DISPLAY_SERVICE_COUNTRYLIST");
			JSONArray countryDisplayValue = (JSONArray)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_SAIL_CODE_SERVICE_COUNTRYLIST"); 
			
			JSONArray displayTitleLabels = (JSONArray)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_SAIL_DISPLAY_USER_TITLES");
			JSONArray displayTitleValue = (JSONArray)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_SAIL_CODE_USER_TITLES"); 
			

			JSONArray displayCompTypeLabels = (JSONArray)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_SAIL_DISPLAY_SERVICE_COMPTYPE");
			JSONArray displayCompTypeValue = (JSONArray)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_SAIL_CODE_SERVICE_COMPTYPE"); 

			String faviconUri = b.getFaviconUri();
			if (ConfigurationFactory.getConfiguration(SuiteConfiguration.class).isShowFavicon()) {
				reg.setFavicon("<link rel=\"shortcut icon\" href=\"" + faviconUri + "\" />");
			} else {
				reg.setFavicon("");
			}

			String loginCss = CustomBrandingServiceImplHelper.getLoginCss(b);
			reg.setLoginCss(loginCss);

			String siteName = b.getSitename();
			reg.setSiteName(siteName);
			
			String terms = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_TERMS_LINK");
			reg.setTerms(terms);

			String disclaimer = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_DISCLAIMER");
			reg.setDisclaimer(disclaimer);
			
			
			String titles = createDropDownList(sc,defaultSelectLabel,displayTitleLabels,displayTitleValue );
			reg.setTitles(titles);
			
			String services = createRadioList(sc);
			reg.setServices(services);
			
			String orgTypes = createDropDownList(sc,defaultSelectLabel,orgTypedisplayLabels,orgTypedisplayValue);
			reg.setOrgTypes(orgTypes);
			
			String compTypes = createDropDownList(sc,defaultSelectLabel,displayCompTypeLabels,displayCompTypeValue);
			reg.setCompTypes(compTypes);

			String countryList = createDropDownList(sc,defaultSelectLabel,countryDisplayLabels,countryDisplayValue);
			reg.setCountryList(countryList);

			LOG.debug("-- Completed");	
			
			LOG.debug("-- Setting Validation Variables...");			
			String messageMaxLengthLastName = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_MAX_LENGTH_LAST_NAME");
			reg.setMessageMaxLengthLastName(messageMaxLengthLastName);

			String maxLengthLastName = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MAX_LENGTH_LAST_NAME");
			reg.setMaxLengthLastName(maxLengthLastName);
			
			String messageMaxLengthFirstName = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_MAX_LENGTH_FIRST_NAME");
			reg.setMessageMaxLengthFirstName(messageMaxLengthFirstName);

			String maxLengthFirstName = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MAX_LENGTH_FIRST_NAME");
			reg.setMaxLengthFirstName(maxLengthFirstName);

			
			String messageMaxLengthPrimaryPhoneNumber = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_MAX_LENGTH_PRIMARY_PHONE_NUMBER");
			reg.setMessageMaxLengthPrimaryPhoneNumber(messageMaxLengthPrimaryPhoneNumber);

			String maxLengthPrimaryPhoneNumber = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MAX_LENGTH_PRIMARY_PHONE_NUMBER");
			reg.setMaxLengthPrimaryPhoneNumber(maxLengthPrimaryPhoneNumber);
			
			String messageMaxLengthSecondaryPhoneNumber = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_MAX_LENGTH_SECONDARY_PHONE_NUMBER");
			reg.setMessageMaxLengthSecondaryPhoneNumber(messageMaxLengthSecondaryPhoneNumber);

			String maxLengthSecondaryPhoneNumber = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MAX_LENGTH_SECONDARY_PHONE_NUMBER");
			reg.setMaxLengthSecondaryPhoneNumber(maxLengthSecondaryPhoneNumber);

			
			
			String messageMaxLengthOtherTitle = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_MAX_LENGTH_OTHER_TITLE");
			reg.setMessageMaxLengthOtherTitle(messageMaxLengthOtherTitle);

			String maxLengthOtherTitle = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MAX_LENGTH_OTHER_TITLE");
			reg.setMaxLengthOtherTitle(maxLengthOtherTitle);

//			DIGIT
			String messageDigitPrimaryPhoneNumber = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_DIGIT_PRIMARY_PHONE_NUMBER");  
			reg.setMessageDigitPrimaryPhoneNumber(messageDigitPrimaryPhoneNumber);
			
			String messageDigitSecondaryPhoneNumber = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_DIGIT_SECONDARY_PHONE_NUMBER");  
			reg.setMessageDigitSecondaryPhoneNumber(messageDigitSecondaryPhoneNumber);
			
//			EMAIL VALID
			String messageValidEmail = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_VALID_EMAIL");  
			reg.setMessageValidEmail(messageValidEmail);
			
//			REQUIRED (NOT EMPTY)	
			//
			String messageRequiredEmail = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_EMAIL");  
			reg.setMessageRequiredEmail(messageRequiredEmail);
			
			String messageRequiredTitle = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_TITLE");  
			reg.setMessageRequiredTitle(messageRequiredTitle);
						
			String messageRequiredOtherTitle = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_OTHER_TITLE");  
			reg.setMessageRequiredOtherTitle(messageRequiredOtherTitle);
						
			String messageRequiredFirstName = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_FIRST_NAME");  
			reg.setMessageRequiredFirstName(messageRequiredFirstName);
			
			String messageRequiredLastName = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_LAST_NAME");  
			reg.setMessageRequiredLastName(messageRequiredLastName);
						
			String messageRequiredTerms = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_TERMS");  
			reg.setMessageRequiredTerms(messageRequiredTerms);
							
			String messageRequiredPrimaryPhoneNumber = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_PRIMARY_PHONE_NUMBER");  
			reg.setMessageRequiredPrimaryPhoneNumber(messageRequiredPrimaryPhoneNumber);
			
			String messageRequiredAccountType = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_ACCOUNT_TYPE");  
			reg.setMessageRequiredAccountType(messageRequiredAccountType);
						
			String messageRequiredCaptcha = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_MESSAGE_REQUIRED_CAPTCHA");  
			reg.setMessageRequiredCaptcha(messageRequiredCaptcha);					
			
			String publicKey = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_CAPTCHA_PUBLIC_KEY");
			reg.setPublicKey(publicKey);

			String contactEmail = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_DSDIP_EMAIL_ADDRESS");   
			reg.setContactEmail(contactEmail);			

			LOG.debug("-- Completed");						
			LOG.debug("-- Setting Outcome HTML Pages...");									
			String existingUserPageHTML = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_HTML_EXISTING_PAGE");  
			reg.setExistingUserPageHTML(existingUserPageHTML);

			String failedPageHTML = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_HTML_FAILED_PAGE");  
			reg.setFailedPageHTML(failedPageHTML);			

			String successPageHTML = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_PLUGIN_REGISTRATION_HTML_SUCCESS_PAGE");  
			reg.setSuccessPageHTML(successPageHTML);			
						
			LOG.debug("-- Completed");									
			
			
			
			LOG.debug("Completing branding style");
		} catch (Exception e) {
			if (e instanceof RuntimeException) {
				throw (RuntimeException)e;
			} else {
				throw new RuntimeException(e);
			}
		} finally {
			SpringSecurityContextHelper.setSpringSecurityContext(origSpringSecCtx);
		}
	}

	private static String createRadioList(ServiceContext sc) throws Exception {
		 
		JSONArray displayLabels = (JSONArray)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_SAIL_DISPLAY_SERVICE_TITLES");
		JSONArray displayValue = (JSONArray)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_SAIL_CODE_SERVICE_TITLES");   

		int itemCount = displayLabels.length();
		
		String titleListHTML = "";
		
		for (int i=0;i<itemCount;i++) {
					
			titleListHTML += "<label><input type='radio' name='serviceRequest' id='serviceRequest"+i+"' value='"
			+ displayValue.get(i).toString()+"' unchecked>"
			+displayLabels.get(i).toString()+"</label><br/>";
            		}

		return titleListHTML;

	}
	
    private static String createDropDownList(ServiceContext sc, String defaultSelectLabel, JSONArray displayLabels, JSONArray displayValue) throws Exception {
		
		int itemCount = displayLabels.length();
		
	    String orgTypeListHTML = "<option value=''>"+defaultSelectLabel+"</option>";
		
		for (int i=0;i<itemCount;i++) {
			orgTypeListHTML +=
					"<option value='"+
			displayValue.get(i).toString()+
			"'>"+displayLabels.get(i).toString()+
			"</option>";
		}

		return orgTypeListHTML;
		
	}	
    }
