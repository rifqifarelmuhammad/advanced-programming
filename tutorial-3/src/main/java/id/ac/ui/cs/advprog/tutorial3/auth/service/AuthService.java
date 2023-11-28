package id.ac.ui.cs.advprog.tutorial3.auth.service;

public interface AuthService {
    boolean login(String username, String password);
    void register(String username, String password);
}
