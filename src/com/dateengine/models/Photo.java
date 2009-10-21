package com.dateengine.models;

import com.google.appengine.api.datastore.Blob;

import javax.jdo.annotations.*;
import java.util.Date;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Photo {
   @PrimaryKey
   @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
   private Long id;

   @Persistent
   private Profile owner;

   @Persistent
   private Blob image;

   @Persistent
   private Blob thumbnail;

   @Persistent
   private String caption;

   @Persistent
   private Date createdAt;

}
