package id.ac.ui.cs.advprog.tutorial3.auth.repository;

import id.ac.ui.cs.advprog.tutorial3.auth.core.User;

public interface UserRepository {
    void addUser(String username, String password);
    User getUser(String username);
}
