package com.dateengine.controllers;

import com.dateengine.PMF;
import com.dateengine.Profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.jdo.Query;
import javax.jdo.PersistenceManager;
import java.io.IOException;
import java.util.List;

public class BrowseServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PersistenceManager pm   = PMF.get().getPersistenceManager();
      Query query             = pm.newQuery(Profile.class);

      List<Profile> profiles;

      try {
         profiles = (List<Profile>) query.execute();            
      } finally {
         query.closeAll();
      }

      request.setAttribute("profiles", profiles);

      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/templates/browse/list.jsp");
      dispatcher.forward(request, response);

   }
}
