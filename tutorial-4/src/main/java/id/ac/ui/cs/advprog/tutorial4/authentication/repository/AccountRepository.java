package id.ac.ui.cs.advprog.tutorial4.authentication.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {
    // Please do not modify this class
    
    Map<String, String> usernamePasswordMapping = new HashMap<>();
    
    public void register(String username, String password){
        usernamePasswordMapping.put(username, password);
    }
    
    public String getPassword(String username){
        return usernamePasswordMapping.getOrDefault(username, null);
    }
    
    
    public boolean doesUsernameExist(String username){
        return usernamePasswordMapping.containsKey(username);
    }
}
