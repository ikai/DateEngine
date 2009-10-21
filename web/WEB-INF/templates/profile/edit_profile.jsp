<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<html>
<head><title>Edit Profile</title></head>
<body>
<h1>Editing Profile</h1>
<%@ include file="../shared/navigation.jsp" %>

<form action="/profile/edit" method="POST">
    <p>
        <label for="username">Username:</label>
        <input type="text" id="username" name="profile.username" value="${profile.username}"/>
    </p>

    <p>
        <label for="aboutMe">About Me:</label>
        <textarea rows="5" cols="60" id="aboutMe" name="profile.aboutMe">${profile.aboutMe}</textarea>
    </p>

    <input type="submit"/>
</form>

<form action="/photo/upload" method="POST" enctype="multipart/form-data">
    <p>
        <label for="photo">Photo</label>
        <input type="file" name="photo" id="photo"/>
    </p>
    
    <input type="submit" name="Upload"/>
</form>

</body>
</html>