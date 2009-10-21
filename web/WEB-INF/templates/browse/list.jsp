<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<html>
  <head><title>Browse Profiles</title></head>
  <body>
    <h1>Profile Browse</h1>
    <%@ include file="../shared/navigation.jsp" %>
    <div class="profiles">
        <ul>
        <c:forEach var="profile" items="${profiles}">
            <li class="mini-profile">
                <h3>
                    <a href="/profile/view?id=${profile.encodedKey}">${profile.username}</a>
                </h3>
                <p>
                    <p>
                        ${profile.key}
                    </p>
                    ${profile.aboutMe}
                </p>
            </li>
        </c:forEach>
        </ul>
    </div>

  </body>
</html>