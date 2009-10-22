package com.dateengine.models;

import com.google.appengine.api.datastore.Blob;

import javax.jdo.annotations.*;
import java.util.Date;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Photo {
   private final int THUMBNAIL_CONSTRAINT_WIDTH    = 150;
   private final int THUMBNAIL_CONSTRAINT_HEIGHT   = 150;

   @PrimaryKey
   @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
   private Long id;

//   @Persistent
//   private Profile owner;

   @Persistent
   private Blob data;

   @Persistent
   private Blob thumbnail;

   @Persistent
   private String caption;

   @Persistent
   private Date createdAt;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

//   public Profile getOwner() {
//      return owner;
//   }
//
//   public void setOwner(Profile owner) {
//      this.owner = owner;
//   }

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

   public void setThumbnail(Blob thumbnail) {
      this.thumbnail = thumbnail;
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
      this.setThumbnail(new Blob(thumbnailData));
   }


}
