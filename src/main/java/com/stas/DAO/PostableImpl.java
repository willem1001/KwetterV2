package com.stas.DAO;

import com.stas.Models.Tweet.Postable;
import com.stas.Models.Tweet.Reaction;
import com.stas.Models.User.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PostableImpl implements IPostable {
   @PersistenceContext
   private EntityManager em;

   @Override
   public void addPost(Postable post) {
      em.persist(post);
   }

   @Override
   public void removePost(Postable post) {
      em.remove(post);
   }

   @Override
   public Postable getParent(Reaction post) {
      return null;
   }

   @Override
   public List<Postable> getFromCreator(User user) {
      return null;
   }

   @Override
   public Postable getPostableById(Long id) {
      return null;
   }

   @Override
   public Postable searchPost(String query) {
      return null;
   }

   @Override
   public List<Postable> getAll() {
      return null;
   }

   @Override
   public List<Postable> getAll(int count) {
      return null;
   }

   @Override
   public void editPost(Postable post) {
      em.merge(post);
   }
}
