package id.ac.ui.cs.advprog.tutorial4.authentication.controller.advice;


import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String ERR_MSG_ATTR = "errMsg";
    private static final String ERROR_ENDPOINT = "authentication/error";
    
    
    @ExceptionHandler(value = {InvalidPasswordException.class})
    public String invalidIdentityInformation(Model model) {
        model.addAttribute(ERR_MSG_ATTR, "Invalid Password");
        return ERROR_ENDPOINT;
    }
    
    
    @ExceptionHandler(value = {InvalidTokenException.class})
    public String invalidTokenException(Model model) {
        model.addAttribute(ERR_MSG_ATTR, "Invalid token");
        return ERROR_ENDPOINT;
    }
    
    
    @ExceptionHandler(value = {UsernameDoesNotExistException.class})
    public String usernameDoesNotExist(Model model) {
        model.addAttribute(ERR_MSG_ATTR, "Username does not exist");
        return ERROR_ENDPOINT;
    }
    
    
    @ExceptionHandler(value = {UsernameAlreadyExistsException.class})
    public String usernameAlreadyExists(Model model) {
        model.addAttribute(ERR_MSG_ATTR, "Username already exists");
        return ERROR_ENDPOINT;
    }
    
    @ExceptionHandler(value = {UsernameAlreadyLoggedIn.class})
    public String usernameAlreadyLoggedIn(Model model) {
        model.addAttribute(ERR_MSG_ATTR, "The username has already logged-in in another device");
        return ERROR_ENDPOINT;
    }
}
