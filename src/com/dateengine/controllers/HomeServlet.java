package com.dateengine.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/templates/home.jsp");

      dispatcher.forward(request, response);

   }
}
