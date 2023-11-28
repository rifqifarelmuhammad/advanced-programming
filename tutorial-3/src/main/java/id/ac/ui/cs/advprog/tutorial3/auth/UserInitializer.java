package id.ac.ui.cs.advprog.tutorial3.auth;

import id.ac.ui.cs.advprog.tutorial3.auth.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init() {
        // Username | Password
        // ---------------------------------------
        // Alicia   | UlangTahunSayaAdalahHariIni
        // Bob      | BOBisAPalindrome
        // Charlie  | CHARLIEcharlie

        // initialize users
        userRepository.addUser("Alicia", "jrLzrEPyYRlkyrCurECErrrIZxz");
        userRepository.addUser("Bob", "IFuSJRfCEzzrSDgv");
        userRepository.addUser("Charlie", "CRrIvYziZVtyTc");

    }
}
