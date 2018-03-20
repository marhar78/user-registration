(function() {
  // frame buster; make sure we are not loaded within a frameset
  if (top != self) { top.location.replace(self.location.href); }
  // if redirection to login occurs in a window opened from 
  // the main one, then redirect the main window to the login
  // page and close the child
  var ENVIRONMENT_PARAM_NAME = 'appian_environment';
  try{
      if(top.opener && top.opener.location.href) {
        var environmentRegex = new RegExp(ENVIRONMENT_PARAM_NAME + "=\\S+$");
        top.opener.location.replace(location.pathname.replace(environmentRegex, top.opener.location.pathname.match(environmentRegex)));
        top.close();
      }
    } 
  catch(e){}
})();
var login_jsp = {
  validateForCookies : function() {
    document.cookie = '__appianCookieCheck=isEnabled';
    var re = new RegExp('__appianCookieCheck=([^;]*);?','gi');
    var appianCookie = re.exec(document.cookie)||[];
    var isCookieEnabled = 'isEnabled' === (appianCookie.length>1?appianCookie[1]:'');
    document.cookie = '__appianCookieCheck=;expires=Fri, 02-Jan-1970 00:00:00 GMT';
    if (!isCookieEnabled) {
      var noCookieMsg = document.getElementById('login_jsp_cookiesMsg');
      noCookieMsg.style.display = '';
      return false;
    }
    return true;
  }
};