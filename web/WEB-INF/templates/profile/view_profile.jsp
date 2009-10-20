
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<html>
  <head><title>View Profile</title></head>
  <body>
    <h1>Viewing ${profile.username}'s Profile</h1>
    <div class="nav">
        <span class="nav-item">
            <a href="/profile/mine">View My Profile</a> |
            <a href="/profile/edit">Edit Profile</a>
        </span>
    </div>

    <div class="aboutMe">
        <h2>About me</h2>
        ${profile.aboutMe}
    </div>

  </body>
</html>