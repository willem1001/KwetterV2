package com.stas.DAO;

import com.stas.Models.Tweet.Postable;
import com.stas.Models.Tweet.Reaction;
import com.stas.Models.User.User;
import java.util.List;

public interface IPostable {
    public void addPost(Postable post);
    public void removePost(Postable post);
    public Postable getParent(Reaction post);
    public List<Postable> getFromCreator(User user);
    public Postable getPostableById(Long id);
    public Postable searchPost(String query);
    public List<Postable> getAll();
    public List<Postable> getAll(int count);
    public void editPost(Postable post);
}
