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
        <label for="age">Age:</label>
        <input type="text" id="age" name="profile.age" value="${profile.age}"/>
    </p>

    <p>
        Gender:
        <label for="gender-male">Male</label>
        <input type="radio" id="gender-male" name="profile.gender" value="MALE" ${profile.gender == "MALE" ? "checked" : ""}/>

        <label for="gender-female">Female</label>
        <input type="radio" id="gender-female" name="profile.gender" value="FEMALE" ${profile.gender == "FEMALE" ? "checked" : ""}/>

        <label for="gender-other">Other</label>
        <input type="radio" id="gender-other" name="profile.gender" value="OTHER" ${profile.gender == "OTHER" ? "checked" : ""}/>
    </p>                                           

    <p>
        Marital Status:
        <label for="maritalStatus-single">Single</label>
        <input type="radio" id="maritalStatus-single" name="profile.maritalStatus" value="SINGLE" ${profile.maritalStatus == "SINGLE" ? "checked" : ""}/>

        <label for="maritalStatus-divorced">Divorced</label>
        <input type="radio" id="maritalStatus-divorced" name="profile.maritalStatus" value="DIVORCED" ${profile.maritalStatus == "DIVORCED" ? "checked" : ""}/>

        <label for="maritalStatus-married">Married</label>
        <input type="radio" id="maritalStatus-married" name="profile.maritalStatus" value="MARRIED" ${profile.maritalStatus == "MARRIED" ? "checked" : ""}/>
    </p>

    <p>
        Pets I Have:
        <label for="pet-dog">Dog</label>
        <input type="checkbox" id="pet-dog" name="profile.pet" value="DOG"/> <!-- Need to figure out how to check if an element is in a set or not -->
        <label for="pet-cat">Cat</label>
        <input type="checkbox" id="pet-cat" name="profile.pet" value="CAT"/>
        <label for="pet-monkey">Monkey</label>
        <input type="checkbox" id="pet-monkey" name="profile.pet" value="MONKEY"/>
        <label for="pet-fish">Fish</label>
        <input type="checkbox" id="pet-fish" name="profile.pet" value="FISH"/>
        <label for="pet-bird">Bird</label>
        <input type="checkbox" id="pet-bird" name="profile.pet" value="BIRD"/>
    </p>

    <p>
        <label for="aboutMe">About Me:</label>
        <textarea rows="5" cols="60" id="aboutMe" name="profile.aboutMe">${profile.aboutMe}</textarea>
    </p>

    <input type="submit"/>
</form>

<form action="/photo/upload" method="POST" enctype="multipart/form-data">
    <p>
        <img src="/photo?key=${profile.photo.encodedKey}"/>
        <label for="photo">Photo</label>
        <input type="file" name="photo" id="photo"/>
    </p>

    <input type="submit" name="Upload"/>
</form>

</body>
</html>