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
        Assert.assertEquals(user1.getRole(), Role.REGULAR);

        user2.changeUserRole(user1, Role.MODERATOR);
        Assert.assertEquals(user1.getRole(), Role.MODERATOR);
    }

    @Test
    public void TestCreatePost() {
        user1.createTweet("Content");
        Postable createdTweet = user1.getCreatedPosts().get(0);
        Assert.assertEquals(createdTweet.getContent(), "Content");
        Assert.assertEquals(createdTweet.getPostType(), PostType.TWEET);
        Assert.assertNotNull(createdTweet.getDate());

        user1.createReaction("Reaction", createdTweet);
        Assert.assertEquals(createdTweet.getReactions().size(), 1);

        Postable createdReaction1 = createdTweet.getReactions().get(0);

        Assert.assertEquals(createdReaction1.getContent(), "Reaction");
        Assert.assertEquals(((Reaction) createdReaction1).getReactedOn(), createdTweet);

        user1.createReaction("ReactionOnReaction", createdReaction1);
        Assert.assertEquals(createdReaction1.getReactions().size(), 1);

        Postable createdReaction2 = createdReaction1.getReactions().get(0);

        Assert.assertEquals(createdReaction2.getContent(), "ReactionOnReaction");
        Assert.assertEquals(((Reaction) createdReaction2).getReactedOn(), createdReaction1);
    }

    @Test
    public void TestFollow() {
        user1.followUser(user2);
        Assert.assertEquals(user1.getFollowing().size(), 1);
        Assert.assertEquals(user2.getFollowers().size(), 1);
    }




}
