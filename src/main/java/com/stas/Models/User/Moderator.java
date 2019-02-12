package com.stas.Models.User;

import com.stas.Enum.Role;
import com.stas.Models.Tweet.Postable;

import java.util.ArrayList;

/**
 * The type Moderator.
 */
public class Moderator extends User {
    /**
     * Instantiates a new Moderator.
     *
     * @param userName the user name
     * @param password the password
     */
    public Moderator(String userName, String password) {
        super(userName, password);
    }

    /**
     * removes a post
     *
     * @param postable the postable
     */
    public void removePost(Postable postable) {
        //todo
    }

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public ArrayList<User> getAllUsers() {
        //todo
        return null;
    }

    /**
     * Change user role.
     *
     * @param user the user
     * @param role the role
     */
    public void changeUserRole(User user, Role role) {
        user.setRole(role);
    }
}
