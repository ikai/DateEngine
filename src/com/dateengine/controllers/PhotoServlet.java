package com.dateengine.controllers;

/*
   Need to put this JAR in WEB-INF/lib
   http://commons.apache.org/fileupload/
 */

import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PhotoServlet extends HttpServlet {
   private static final Logger log = Logger.getLogger(PhotoServlet.class.getName());

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
         ServletFileUpload upload = new ServletFileUpload();
         response.setContentType("image/jpeg");

         FileItemIterator iterator = upload.getItemIterator(request);
         while (iterator.hasNext()) {
            FileItemStream item = iterator.next();
            InputStream stream = item.openStream();

            if (item.isFormField()) {
               log.warning("Got a form field: " + item.getFieldName());
            } else {
               log.warning("Got an uploaded file: " + item.getFieldName() +
                       ", name = " + item.getName());

               // You now have the filename (item.getName() and the
               // contents (which you can read from stream).  Here we just
               // print them back out to the servlet output stream, but you
               // will probably want to do something more interesting (for
               // example, wrap them in a Blob and commit them to the
               // datastore).
               int len;
               byte[] buffer = new byte[8192];
               while ((len = stream.read(buffer, 0, buffer.length)) != -1) {
                  response.getOutputStream().write(buffer, 0, len);
               }
            }
         }
      } catch (Exception ex) {
         throw new ServletException(ex);
      }
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }
}
