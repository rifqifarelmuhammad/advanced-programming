package id.ac.ui.cs.advprog.tutorial4.authentication.core;

import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.UsernameAlreadyExistsException;
import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.UsernameAlreadyLoggedIn;
import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.InvalidTokenException;
import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.UsernameDoesNotExistException;

import java.util.HashMap;
import java.util.Map;

public class AuthentiationManager {
    // TODO Buat private constructor

    // TODO lengkapi method getInstance
    // boleh mengedit static attribute jika diperlukan
    private static AuthentiationManager instance;

    private AuthentiationManager(){}

    public static AuthentiationManager getInstance(){
        if (instance == null){
            instance = new AuthentiationManager();
        }

        return instance;
    }

    private Map<String, String> tokenToUsernameMapping = new HashMap<>();

    // TODO
    //  lengkapi method-method di bawah ini, serta jangan lupa mengimplementasi supaya
    //  method-method tersebut throw exception yang tepat.
    //  Jangan lupa juga untuk mempelajari kegunaan @ControllerAdvice
    //  dan peran dari masing-masing class pada bagian tutorial ini
    
    public void registerNewToken(String token, String username){
        // TODO
        if (tokenToUsernameMapping.containsValue(username)){
            throw new UsernameAlreadyLoggedIn();
        }else{
            tokenToUsernameMapping.put(token, username);
        }
    }
    
    public void removeToken(String token){
        // TODO
        tokenToUsernameMapping.remove(token);
    }
    
    public String getUsername(String token){
        // TODO
        if (!tokenToUsernameMapping.containsKey(token)){
            throw new InvalidTokenException();
        }else{
            return tokenToUsernameMapping.get(token);
        }
    }
    
}
