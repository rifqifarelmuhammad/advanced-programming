package id.ac.ui.cs.advprog.tutorial4.authentication.service;

import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.InvalidPasswordException;
import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.UsernameAlreadyExistsException;
import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.UsernameAlreadyLoggedIn;
import id.ac.ui.cs.advprog.tutorial4.authentication.exceptions.UsernameDoesNotExistException;
import id.ac.ui.cs.advprog.tutorial4.authentication.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceImplTest {

    @Spy
    AccountRepository accountRepository;

    @InjectMocks
    AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl();


    @Test
    void testAuthServiceRegisterShouldAddToRepository() throws Exception {
        authenticationService.register("email", "password");
        assertTrue(accountRepository.doesUsernameExist("email"));
    }

    @Test
    void testAuthServiceRegisterTwiceShouldThrowsError() {
        authenticationService.register("error", "password");
        assertThrows(UsernameAlreadyExistsException.class, () -> authenticationService.register("error", "password"));
    }

    @Test
    void testLoginWithUnexpectedInputShouldThrowsError() {
        accountRepository.register("email", "password");
        assertThrows(InvalidPasswordException.class, () -> authenticationService.login("email", "salah"));
        assertThrows(UsernameDoesNotExistException.class, () -> authenticationService.login("liame", "password"));
    }
}