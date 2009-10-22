package com.dateengine.models;

import com.google.appengine.api.datastore.Blob;

import javax.jdo.annotations.*;
import java.util.Date;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Photo {
   private static final int THUMBNAIL_CONSTRAINT_WIDTH    = 150;
   private static final int THUMBNAIL_CONSTRAINT_HEIGHT   = 150;

   @PrimaryKey
   @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
   private Key key;

   @Persistent
   private Blob data;

   @Persistent
   private Blob thumbnail;

   @Persistent
   private String caption;

   @Persistent
   private Date createdAt;

   public String getEncodedKey() {
      return KeyFactory.keyToString(this.key);
   }

   public Key getKey() {
      return key;
   }

   public void setKey(Key key) {
      this.key = key;
   }

   public Blob getImage() {
      return data;
   }

   public void setImage(Blob data) {
      this.data = data;
      createThumbnail();
   }

   public Blob getThumbnail() {
      return thumbnail;
   }

   public String getCaption() {
      return caption;
   }

   public void setCaption(String caption) {
      this.caption = caption;
   }

   public Date getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
   }

   private void createThumbnail() {

      ImagesService imagesService = ImagesServiceFactory.getImagesService();

      Image originalImage = ImagesServiceFactory.makeImage(this.getImage().getBytes());
      Transform resize = ImagesServiceFactory.makeResize(THUMBNAIL_CONSTRAINT_WIDTH, THUMBNAIL_CONSTRAINT_HEIGHT);

      Image thumbnailImage = imagesService.applyTransform(resize, originalImage);
      byte[] thumbnailData = thumbnailImage.getImageData();
      this.thumbnail = new Blob(thumbnailData);
   }


}
