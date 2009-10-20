
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<html>
  <head><title>Edit Profile</title></head>
  <body>
    <h1>Editing Profile</h1>
    <div class="nav">
        <span class="nav-item">
            <a href="/profile/mine">View My Profile</a> |
            <a href="/profile/edit">Edit Profile</a>
        </span>
    </div>        

    <form action="/profile/edit" method="POST">
        <label for="username">Username:</label>
        <input type="text" id="username" name="profile.username" value="${profile.username}"/>

        <label for="aboutMe">About Me:</label>
        <textarea rows="5" cols="60" id="aboutMe" name="profile.aboutMe">${profile.aboutMe}</textarea>

        <input type="submit" /> 
    </form>
  </body>
</html>