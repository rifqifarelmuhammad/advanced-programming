package id.ac.ui.cs.advprog.tutorial4.authentication.core;

import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.InvalidTokenException;
import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.UsernameAlreadyLoggedIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthentiationManagerTest {

    private AuthentiationManager authenticationManager;

    private String token;

    @BeforeEach
    void setUp() {
        authenticationManager = AuthentiationManager.getInstance();
    }

    @Test
    void whenRegisterNewTokenShouldAddToTokenMappingAndReturnUsername() {
        token = Util.generateToken();
        authenticationManager.registerNewToken(token, "email1");
        assertEquals("email1", authenticationManager.getUsername(token));
    }

    @Test
    void whenRegisterWithExistingUsernameShouldThrowsError() {
        token = Util.generateToken();
        assertThrows(UsernameAlreadyLoggedIn.class, () -> authenticationManager.registerNewToken(token, "email1"));

    }

    @Test
    void whenRemoveTokenShouldDeleteTokenFromMapping() {
        token = Util.generateToken();
        authenticationManager.registerNewToken(token, "email2");
        authenticationManager.removeToken(token);
        assertThrows(InvalidTokenException.class, () -> authenticationManager.getUsername(token));
    }

    @Test
    void whenGetUsernameWithInvalidToken() {
        assertThrows(InvalidTokenException.class, () -> authenticationManager.getUsername("invalid"));
    }

}