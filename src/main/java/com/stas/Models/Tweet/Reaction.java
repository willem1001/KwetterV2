package com.stas.Models.Tweet;

import com.stas.Enum.PostType;
import com.stas.Models.User.User;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The type Reaction.
 */
@Entity
public class Reaction extends Postable {
    private Postable reactedOn;

    /**
     * Instantiates a new Reaction.
     *
     * @param content the content of the post
     * @param creator the creator of the post
     */
    public Reaction(String content, User creator, Postable postable, PostType postType) {
        super(content, creator, postType);
        this.reactedOn = postable;
    }


    /**
     * Gets reacted on.
     *
     * @return the parent post
     */
    public Postable getReactedOn() {
        return reactedOn;
    }

    /**
     * Sets reacted on.
     *
     * @param reactedOn the parent post
     */
    public void setReactedOn(Postable reactedOn) {
        this.reactedOn = reactedOn;
    }
}
