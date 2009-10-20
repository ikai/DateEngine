package com.dateengine;

import javax.jdo.annotations.*;
import javax.jdo.PersistenceManager;
import javax.jdo.JDOObjectNotFoundException;

import com.google.appengine.api.users.User;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Profile {

   public enum MaritalStatus {
      SINGLE, DIVORCED, MARRIED 
   }

   @PrimaryKey
   @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
   private Key key;

   @Persistent
   private String username;
   
   @Persistent
   private int age;

   @Persistent
   private MaritalStatus maritalStatus;

   @Persistent
   private String aboutMe;

   // D'oh, guess I need to update my SDK to get Geo
   // @Persistent
   // private GeoPt location;

   public static Profile findForUser(User user) {
      Key key = KeyFactory.createKey(Profile.class.getSimpleName(), user.getEmail());

      PersistenceManager pm = PMF.get().getPersistenceManager();
      Profile profile = null;
      try {
         profile = pm.getObjectById(Profile.class, key);
      } catch (JDOObjectNotFoundException e) {
         // Maybe we should do something here?         
      } finally {
         pm.close();
      }

      return profile;
   }

   public Key getKey() {
      return key;
   }

   public void setKey(Key key) {
      this.key = key;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public MaritalStatus getMaritalStatus() {
      return maritalStatus;
   }

   public void setMaritalStatus(MaritalStatus maritalStatus) {
      this.maritalStatus = maritalStatus;
   }

   public String getAboutMe() {
      return aboutMe;
   }

   public void setAboutMe(String aboutMe) {
      this.aboutMe = aboutMe;
   }
}
