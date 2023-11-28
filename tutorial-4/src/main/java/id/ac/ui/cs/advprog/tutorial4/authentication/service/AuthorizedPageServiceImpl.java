package id.ac.ui.cs.advprog.tutorial4.authentication.service;

import id.ac.ui.cs.advprog.tutorial4.authentication.core.AuthentiationManager;
import org.springframework.stereotype.Service;

@Service
public class AuthorizedPageServiceImpl implements AuthorizedPageService {
    // Please do not modify this class
    
    AuthentiationManager authenticationManager = AuthentiationManager.getInstance();
    @Override
    public String getUsername(String token){
        return authenticationManager.getUsername(token);
    }
}
