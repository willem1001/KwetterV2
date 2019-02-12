package com.stas.Models.Tweet;

import com.stas.Enum.PostType;
import com.stas.Models.User.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * The type Postable.
 */
public abstract class Postable {
    private Long id;
    private String content;
    private ArrayList<Reaction> reactions = new ArrayList<Reaction>();
    private ArrayList<User> likes = new ArrayList<User>();
    private Date date;
    private User creator;
    private PostType postType;

    /**
     * Instantiates a new Postable.
     *
     * @param content the content
     * @param creator the creator
     */
    public Postable(String content, User creator, PostType postType) {
        this.content = content;
        this.creator = creator;
        this.postType = postType;
        this.date = new Date();
    }

    /**
     * Add a like to the post
     *
     * @param user the user who liked the post
     */
    public void likePost(User user) {
        if(likes.contains(user)) {
           likes.remove(user);
            user.removeLike(this);
        } else {
            likes.add(user);
        }
    }

    public void addReaction(Reaction reaction) {
        reactions.add(reaction);
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
     * @param id the post id;
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content of the post
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets reactions.
     *
     * @return the reactions
     */
    public ArrayList<Reaction> getReactions() {
        return reactions;
    }

    /**
     * Sets reactions.
     *
     * @param reactions the reactions on the post
     */
    public void setReactions(ArrayList<Reaction> reactions) {
        this.reactions = reactions;
    }

    /**
     * Gets likes.
     *
     * @return the likes
     */
    public ArrayList<User> getLikes() {
        return likes;
    }

    /**
     * Sets likes.
     *
     * @param likes the likes on the post
     */
    public void setLikes(ArrayList<User> likes) {
        this.likes = likes;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date of creation
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets creator.
     *
     * @return the creator
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Sets creator.
     *
     * @param creator the creator of the post
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    public PostType getPostType() {
        return postType;
    }
}
