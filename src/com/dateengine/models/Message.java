package com.dateengine.models;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.*;
import java.util.Date;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Message {

   @PrimaryKey
   @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
   private Long id;

   @Persistent
   private Key senderKey;

   @Persistent
   private Key recipientKey;

   @Persistent
   private Text body;

   @Persistent
   private Date sent;

   public Long getId() {
      return id;
   }

   public Key getSenderKey() {
      return senderKey;
   }

   public void setSenderKey(Key senderKey) {
      this.senderKey = senderKey;
   }

   public void setSender(Profile sender) {
      setSenderKey(sender.getKey());
   }

   public Key getRecipientKey() {
      return recipientKey;
   }

   public void setRecipientKey(Key recipientKey) {
      this.recipientKey = recipientKey;
   }

   public void setRecipient(Profile recipient) {
      setRecipientKey(recipient.getKey());
   }

   public Text getBody() {
      return body;
   }

   public void setBody(Text body) {
      this.body = body;
   }

   public void setBody(String body){
      Text text = new Text(body);
      setBody(text);
   }

   public Date getSent() {
      return sent;
   }

   public void setSent(Date sent) {
      this.sent = sent;
   }
}
