package id.ac.ui.cs.advprog.tutorial3.auth.service;

import id.ac.ui.cs.advprog.tutorial3.auth.core.Encryptor;
import id.ac.ui.cs.advprog.tutorial3.auth.core.User;
import id.ac.ui.cs.advprog.tutorial3.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean login(String username, String password) {
        User supposedUser = userRepository.getUser(username);
        return supposedUser != null &&
                toCipher(password).equals(supposedUser.getPassword());
    }

    @Override
    public void register(String username, String password) {
        userRepository.addUser(username, toCipher(password));
    }

    private String toCipher(String password) {
        // TODO: Complete this function
        Encryptor encryptor = new Encryptor();
        return encryptor.encrypt(password);
    }
}
