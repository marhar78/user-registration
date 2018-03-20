package com.appiancorp.ps.registration.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.appiancorp.ps.registration.CaptchaResponse;
import com.appiancorp.ps.registration.ExpressionHelper;
import com.appiancorp.ps.registration.LoginPage;
import com.appiancorp.ps.registration.LoginPageHelper;
import com.appiancorp.services.ServiceContext;
import com.appiancorp.services.ServiceContextFactory;
import com.appiancorp.suiteapi.common.ServiceLocator;
import com.appiancorp.suiteapi.process.ProcessDesignService;
import com.appiancorp.suiteapi.process.ProcessStartConfig;
import com.appiancorp.suiteapi.process.ProcessVariable;
import com.appiancorp.suiteapi.type.NamedTypedValue;
import com.google.gson.Gson;
import com.appiancorp.suiteapi.type.AppianType;

public class RegistrationServlet extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(RegistrationServlet.class);

	private static final long serialVersionUID = -1114265201343408354L;
	private static final ServiceContext sc = ServiceContextFactory.getServiceContext("registrator");
	private static final ProcessDesignService pds = ServiceLocator.getProcessDesignService(sc);
	
	private static final long REGISTRATION_DISABLED = -1;

	private String registrationUuid;
	private long registrationId;
	private VelocityEngine ve;
	
	@Override
	public void init() throws ServletException {
		try {
			LOG.debug("Initializing velocity engine");
			ve = new VelocityEngine();
			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

			Velocity.init();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("Get");
		
		try {			
			LOG.debug("Obtaining constant with registration model UUID");
			registrationUuid = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_REGISTRATION_MODEL_UUID");
			LOG.debug("Searching for process model UUID: " + registrationUuid);
			registrationId = pds.getProcessModelIdByUuid(registrationUuid);
		} catch (Exception e) {
			registrationId = REGISTRATION_DISABLED;
			LOG.debug("Did not find process model UUID: " + registrationUuid);
			e.printStackTrace();
		}
		
		// User is already logged in, don't show them the registration page.
		if (req.getRemoteUser() != null) {
			LOG.debug("User already logged in");
			resp.sendRedirect("/suite");
			return;
		}

		resp.setContentType("text/html");

		if (registrationId == REGISTRATION_DISABLED) {
			LOG.debug("Registration disabled, outputting disabled form");
			outputForm(resp, "disabled");
		} else {
			LOG.debug("Registration enabled, outputting signup form");
			outputForm(resp, "registrationForm");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("Post");
		
		// User is already logged in, don't show them the registration page.
		if (req.getRemoteUser() != null) {
			LOG.debug("User already logged in");
			resp.sendRedirect("/suite");
			return;
		}

		resp.setContentType("text/html");

		ProcessStartConfig config = new ProcessStartConfig(
				getProcessParameters(
						req,
						new String[] {
								"orgName",
								"orgAddr1",
								"orgAddr2",
								"orgAddr3",
								"orgAddr4",
								"city",
								"county",
								"country",
								"postcode",
								"website",
								"legalType",
								"busType",
								"VATReg",
								"coReg",
								"email",
								"title",
								"firstName",
								"lastName",
								"jobTitle",
								"telephone",
								"serviceRequest",
								"otherTitle",
								"terms"
						}
				)
			);
		String targetForm = getOutputForm(req, resp);
		LOG.debug(targetForm);

		try {			
//			outputs existing form if existing user found
			if (targetForm.equals("existing")) {
				outputForm(resp, "existing");
//			output failed form if validation failed on recaptcha or catch all
			} else if (targetForm.equals("failed")) {
				LOG.debug("Process initiation failed ");
				outputForm(resp, "failed");
			} else if (targetForm.equals("existingOrg")) {
				LOG.debug("Existing organisation");
				outputForm(resp, "existingOrg");
			}
//			output success if all passed
			else {				
				LOG.debug("Initiating process");
				pds.initiateProcess(registrationId, config);
				LOG.debug("Process initiated");

				outputForm(resp, "success");
			}
//			output failed if catch all failure triggered
		} catch (Exception e) {
			LOG.debug("Process initiation failed");
			outputForm(resp, "failed");
		}
	}

	private ProcessVariable[] getProcessParameters(HttpServletRequest req, String[] paramKeys) {
		List<ProcessVariable> paramList = new ArrayList<ProcessVariable>();

		for (String key : paramKeys) {
			paramList.add(new ProcessVariable(new NamedTypedValue(key, (long) AppianType.STRING, req.getParameter(key))));
		}

		return paramList.toArray(new ProcessVariable[paramList.size()]);
	}
	
//  ------------
	
	private boolean getCaptchaResult(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		LOG.debug("Begin verifying Google Recaptcha");
		
    // Get input parameter values (form data)
    String recap = req.getParameter("g-recaptcha-response");

	String privateKey = (String)ExpressionHelper.evaluateExpression(sc, "cons!COMMON_CAPTCHA_PRIVATE_KEY");    
    
    // Send get request to Google reCaptcha server with secret key  
    URL url = new URL("https://www.google.com/recaptcha/api/siteverify?secret="+privateKey+"&response="+recap+"&remoteip="+req.getRemoteAddr());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    String line, outputString = "";
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream()));
    while ((line = reader.readLine()) != null) {
        outputString += line;
    }
    

    
    // Convert response into Object
    CaptchaResponse capRes = new Gson().fromJson(outputString, CaptchaResponse.class);
    
    // Verify whether the input from Human or Robot 
    if(capRes.isSuccess()) {
		LOG.debug("Google Recaptcha Success");
        // Input by Human
        req.setAttribute("verified", "true");   
        return true;
    } else {
		LOG.debug("Google Recaptcha failed");
    	// Input by Robot
        req.setAttribute("verified", "false");
        return false;
    }	
}
	
	private String getOutputForm(HttpServletRequest req, HttpServletResponse resp) {

		String result = null;
		try {	
			LOG.debug("Verifying reCaptcha");
			boolean captchaPass = getCaptchaResult(req, resp);
			LOG.debug("reCaptcha Outcome: " + captchaPass);

			
      String email = req.getParameter("email");
      
      Boolean usernameTaken = ((Long)ExpressionHelper.evaluateExpression(sc, "rule!COMMON_isUsernameTaken(\"" + email + "\")")).intValue() == 1;
      

        LOG.debug("Verifying username for registration");
//        will send user to success form
        if (!usernameTaken && captchaPass ) {
        	LOG.debug("Verification success, create user");
        	result = "success";
//		will send user to login form
        } else if (usernameTaken && captchaPass ) {
        	LOG.debug("Username taken, redirect to existing user form");
        	result = "existing";
//        	will send user to existing organisation form
        }  else {
        	LOG.debug("Verification failed, redirect to catch all fail form");
        	result = "failed";
        }
      
      
		} catch (Exception e) {
			LOG.debug("An error has occurred during verification",e);
        	result = "failed";

		}
		return result;

	
	}	
	
	
//	-------------------------------------------------------------------------
	
	private void outputForm(HttpServletResponse resp, String name) {
		try {
			
			LoginPage loginPage = new LoginPage();
			loginPage.setForm(name);

			LoginPageHelper.setBrandingStyle(sc, loginPage);
			
			VelocityContext context = new VelocityContext();
			LOG.debug("Locating template");
			Template template = ve.getTemplate("templates/loginPage.htm");

			context.put("loginPage", loginPage);
			LOG.debug("Merging template");
			template.merge(context, resp.getWriter());
		} catch (Exception e) {
			LOG.debug("An error has occurred in generating the registration template" + e.getMessage(),e);
		}
		
	}


	
	
}
