package com.stas.DAO;

import com.stas.Models.User.User;
import java.util.List;

public interface IUser {
    public Long addUser(User user, String password);
    public User getUserById(Long id);
    public User login(User user, String password);
    public List<User> getAllUsers();
    public User searchUser(String query);
    public User editUser(User user);
}
