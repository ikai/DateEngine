
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<html>
  <head><title>View Profile</title></head>
  <body>
    <h1>Viewing ${profile.username}'s Profile</h1>
    <%@ include file="../shared/navigation.jsp" %>

    <div class="aboutMe">
        <h2>About me</h2>
        <a href="/messages/new?key=${profile.encodedKey}">Send Message</a>
        <img src="/photo?key=${profile.photo.encodedKey}" />
        ${profile.aboutMe}
    </div>

  </body>
</html>