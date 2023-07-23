package com.udemy.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//retaining Value from Frontend in model, For use across multiple requests.I retain name.
@SessionAttributes("name")
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());


//    //Pass param by url
//    //if you want pass param to JSP.It needs ModelMap
//    @RequestMapping("login")
//    public String gotoLoginPage(@RequestParam String name, ModelMap modelMap) {
//        modelMap.put("name", name); //Pass to JSP
//        //It doesn't log because in Application.properties Logging level is info that level below debug.
//        logger.debug("Show param by Debug Level is {}", name); //NOT RECOMMEND FOR PROD CODE
//        logger.info("Show param by Info Level is {}", name); //NOT RECOMMEND FOR PROD CODE
//        return "login"; // Redirect to login.jsp
//    }

    //Step 12 of video in Udemy
    //method is make this gotoLoginPage use only GET
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap modelMap) {
        modelMap.put("name", getLoggingUsername());
        return "welcome"; // Redirect to welcome.jsp
    }

    private String getLoggingUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


    //Authentication
    //if correct go welcome page
    //else go login page
    //name - bill
    //password - 1234
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
//
//        if(!authenticationLoginService.authenticate(name,password)){
//            modelMap.put("errorMessage","Invalid Credentials! Try again.");
//            return "login";
//        }
//        modelMap.put("name", name);
//        modelMap.put("password", password);
//
//        return "welcome"; // Redirect to login.jsp
//    }

}
