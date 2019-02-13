package com.stas.Models.User;

import com.stas.Enum.PostType;
import com.stas.Enum.Role;
import com.stas.Models.Tweet.Postable;
import com.stas.Models.Tweet.Reaction;
import com.stas.Models.Tweet.Tweet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User.
 */

@Table(name = "user")
@Entity
@NamedQueries({
        @NamedQuery(name = "User.getAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.get", query = "SELECT u FROM User u")
})
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String bio;
    @OneToMany
    private List<User> following = new ArrayList<User>();
    @OneToMany
    private List<User> followers;
    private String location;
    private String profilePicture;
    @OneToMany
    private List<Postable> postsLiked = new ArrayList<Postable>();
    @OneToMany
    private List<Postable> createdPosts = new ArrayList<Postable>();
    private String password;
    private Role role;
    private String website;

    /**
     * Instantiates a new User.
     *
     * @param userName the user name
     * @param password the password
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User () {}


    /**
     * Like post.
     *
     * @param post the post
     */
    public void likePost(Postable post) {
        post.likePost(this);
        postsLiked.add(post);
    }

    public void removeLike(Postable post) {
        if(postsLiked.contains(post)) {
            postsLiked.remove(post);
        }
    }

    /**
     * Create tweet.
     *
     * @param content the content
     */
    public void createTweet(String content) {
        Tweet tweet = new Tweet(content, this, PostType.TWEET);
        createdPosts.add(tweet);
    }

    public void createReaction(String content, Postable post) {
        Reaction reaction = new Reaction(content, this, post, PostType.REACTION);
        reaction.setReactedOn(post);
        post.addReaction(reaction);
        createdPosts.add(reaction);
    }

    /**
     * Follow user.
     *
     * @param user the user
     */
    public void followUser(User user) {
        following.add(user);
        user.addFollower(this);
    }

    /**
     * Add follower.
     *
     * @param user the user
     */
    public void addFollower(User user) {
        followers.add(user);
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets bio.
     *
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * Sets bio.
     *
     * @param bio the bio
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * Gets following.
     *
     * @return the following
     */
    public ArrayList<User> getFollowing() {
        return (ArrayList<User>) following;
    }

    /**
     * Sets following.
     *
     * @param following the following
     */
    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

    /**
     * Gets followers.
     *
     * @return the followers
     */
    public ArrayList<User> getFollowers() {
        return (ArrayList<User>) followers;
    }

    /**
     * Sets followers.
     *
     * @param followers the followers
     */
    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets profile picture.
     *
     * @return the profile picture
     */
    public String getProfilePicture() {
        return profilePicture;
    }

    /**
     * Sets profile picture.
     *
     * @param profilePicture the profile picture
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets website.
     *
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets website.
     *
     * @param website the website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Gets posts liked.
     *
     * @return the posts liked
     */
    public ArrayList<Postable> getPostsLiked() {
        return (ArrayList<Postable>) postsLiked;
    }

    /**
     * Sets posts liked.
     *
     * @param postsLiked the posts liked
     */
    public void setPostsLiked(ArrayList<Postable> postsLiked) {
        this.postsLiked = postsLiked;
    }

    /**
     * Gets created posts.
     *
     * @return the created posts
     */
    public ArrayList<Postable> getCreatedPosts() {
        return (ArrayList<Postable>) createdPosts;
    }

    /**
     * Sets created posts.
     *
     * @param createdPosts the created posts
     */
    public void setCreatedPosts(ArrayList<Postable> createdPosts) {
        this.createdPosts = createdPosts;
    }
}
