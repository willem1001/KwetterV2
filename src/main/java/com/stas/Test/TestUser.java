package com.stas.Test;

import com.stas.Enum.PostType;
import com.stas.Enum.Role;
import com.stas.Models.Tweet.Postable;
import com.stas.Models.Tweet.Reaction;
import com.stas.Models.User.Moderator;
import com.stas.Models.User.Regular;
import org.junit.Assert;
import org.junit.Test;

public class TestUser {

    Regular user1 = new Regular("regularUser", "regularPassword");
    Moderator user2 = new Moderator("moderatorUser", "moderatorPassword");

    @Test
    public void TestChangeRole() {
        user1.setRole(Role.REGULAR);
        Assert.assertEquals(Role.REGULAR, user1.getRole());

        user2.changeUserRole(user1, Role.MODERATOR);
        Assert.assertEquals(Role.MODERATOR, user1.getRole());
    }

    @Test
    public void TestCreatePost() {
        user1.createTweet("Content");
        Postable createdTweet = user1.getCreatedPosts().get(0);

        Assert.assertEquals(createdTweet.getContent(), "Content");
        Assert.assertEquals(createdTweet.getPostType(), PostType.TWEET);
        Assert.assertNotNull(createdTweet.getDate());

        user1.createReaction("Reaction", createdTweet);
        Assert.assertEquals(1, createdTweet.getReactions().size());

        Postable createdReaction1 = createdTweet.getReactions().get(0);

        Assert.assertEquals("Reaction", createdReaction1.getContent());
        Assert.assertEquals(createdTweet, ((Reaction) createdReaction1).getReactedOn());

        user1.createReaction("ReactionOnReaction", createdReaction1);
        Assert.assertEquals(1, createdReaction1.getReactions().size());

        Postable createdReaction2 = createdReaction1.getReactions().get(0);

        Assert.assertEquals(createdReaction2.getContent(), "ReactionOnReaction");
        Assert.assertEquals(createdReaction1, ((Reaction) createdReaction2).getReactedOn());
    }

    @Test
    public void TestFollow() {
        user1.followUser(user2);
        Assert.assertEquals(1, user1.getFollowing().size());
        Assert.assertEquals(1, user2.getFollowers().size());
    }

    @Test
    public void TestLike() {
        user1.createTweet("Content");
        Postable createdTweet = user1.getCreatedPosts().get(0);

        user1.likePost(createdTweet);
        Assert.assertEquals(1, createdTweet.getLikes().size());

        user1.likePost(createdTweet);
        Assert.assertEquals(0, createdTweet.getLikes().size());
    }




}
