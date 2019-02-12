package com.stas.Models.Tweet;

import com.stas.Enum.PostType;
import com.stas.Models.User.User;

/**
 * The type Tweet.
 */
public class Tweet extends Postable {

    /**
     * Instantiates a new Tweet.
     *
     * @param content the content
     * @param creator the creator
     */
    public Tweet(String content, User creator, PostType postType) {
        super(content, creator, postType);
    }
}

