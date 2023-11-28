package id.ac.ui.cs.advprog.tutorial4.authentication.service;

public interface AuthenticationService {
    // Please do not modify this class
    
    void register(String username, String password);
    
    String login(String username, String password);
    
    void logout(String token);
}
