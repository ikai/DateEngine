<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://com.dateengine.tld/profile' prefix='profile' %>


<html>
<head><title>New Message</title></head>
<body>
<h1>New Message</h1>
<%@ include file="../shared/navigation.jsp" %>

<form action="/messages/send" method="POST">
    To: ${recipient.username}
    <input type="hidden" name="message.recipientKey" value="${recipient.encodedKey}" />
    <textarea rows="3" cols="40" name="message.body">Enter your message here</textarea>
    <input type="submit"/>
</form>

</body>
</html>