<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://com.dateengine.tld/profile' prefix='profile' %>


<html>
<head><title>Inbox</title></head>
<body>
<h1>Inbox</h1>
<%@ include file="../shared/navigation.jsp" %>

<ul class="messages">
    <c:forEach var="message" items="${messages}">
        <li class="message">            
            <p>${message.body}</p>
        </li>
    </c:forEach>
</ul>

</body>
</html>