function validateWebsite(){
	return this.optional( element ) || /^(?:(?:(?:https?|ftp):)?\/\/)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})).?)(?::\d{2,5})?(?:[/?#]\S*)?$/i.test( value );
}

function displayQuestion(answer) {

	 if (answer == "Limited Company") { // hide the div that is not selected

			document.getElementById('vatReg').style.display = "block";
			document.getElementById('coReg').style.display = "block";

	  } else {

		    document.getElementById('vatReg').style.display = "none";
		    document.getElementById('coReg').style.display = "none";

	  }

	}

function recaptchaCallback() {
	$('#hiddenRecaptcha').valid();
	document.getElementById("signupbutton").disabled = false;
};



$(document).ready(function() {

document.getElementById("signupbutton").disabled = true;

	// Initially hide other position field and select Australia as country
	$('#otherTitleDiv').hide();

	// Show Other Position box if other is selected
	$('#title').change(function() {
		// Other is selected
		if($(this).find(":selected").val() == "Other") {
			$('#otherTitleDiv').show();
			$('#otherTitle').prop("required",true);

		} else {
			$('#otherTitleDiv').hide();
			$('#otherTitle').prop("required",false);
		}
	});


	    $('#form').validate({
	      ignore: ".ignore",
	        rules: {
	            hiddenRecaptcha: {
	                required: function () {
	                    if (grecaptcha.getResponse() == '') {
	                        return true;
	                    } else {
	                        return false;
	                    }
	                }
	            },
					title: {
						required: true
	            },
					otherTitle: {
						required: function () {
									if ($("#title").find(":selected").val() == "Other") {
										return true;
									} else {
										return false;
									}
								},
						maxlength: $loginPage.maxLengthOtherTitle
	            },
					firstName: {
						required: true,
						maxlength: $loginPage.maxLengthFirstName
	            },
					lastName: {
						required: true,
						maxlength: $loginPage.maxLengthLastName
	            },
					email: {
						required: true,
						email: true
	            },
					phoneNumber: {
						required: true,
						digits: true,
						maxlength: $loginPage.maxLengthPrimaryPhoneNumber
	            },
					mobileNumber: {
						digits:true,
						maxlength: $loginPage.maxLengthSecondaryPhoneNumber
				},
					terms: {
						required: true
	            },
					isAccountTypeMultiUser: {
						required: true
	            }
	        },
					messages: {
						hiddenRecaptcha: "$loginPage.messageRequiredCaptcha",
						firstName: {
							required:"$loginPage.messageRequiredFirstName",
							maxlength: "$loginPage.messageMaxLengthFirstName"
						},
						lastName: {
							required:'$loginPage.messageRequiredLastName',
							maxlength: "$loginPage.messageMaxLengthLastName"
						},
						title: "$loginPage.messageRequiredTitle",
						otherTitle: {
							required: '$loginPage.messageRequiredOtherTitle',
							maxlength: "$loginPage.messageMaxLengthOtherTitle"
						},
						email:{
							required: "$loginPage.messageRequiredEmail",
							email: "$loginPage.messageValidEmail"
						},
						phoneNumber: {
							required:"$loginPage.messageRequiredPrimaryPhoneNumber",
							digits: "$loginPage.messageDigitPrimaryPhoneNumber",
							maxlength: "$loginPage.messageMaxLengthPrimaryPhoneNumber"

						},
						mobileNumber: {
							digits: "$loginPage.messageDigitSecondaryPhoneNumber",
							maxlength: "$loginPage.messageMaxLengthSecondaryPhoneNumber"							
						},
						terms: "$loginPage.messageRequiredTerms",
						isAccountTypeMultiUser: "$loginPage.messageRequiredAccountType"

	        },
					errorElement: 'small',
					successClass: 'has-success',
					errorClass: 'help-block error',

					errorPlacement: function(error, element) {

						if (element.attr("name") == "isAccountTypeMultiUser") {
								error.insertAfter("#radio-error");
    } else if (element.attr("name") == "terms") {
              error.insertAfter("#checkbox-error");
            } else {
                error.insertAfter(element);
            }


	        }
	    });

});
