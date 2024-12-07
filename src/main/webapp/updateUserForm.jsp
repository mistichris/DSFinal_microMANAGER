<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Data Structures: MicroManager</title>
<link href="style.css" rel="stylesheet" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="wrapper">
        <header>
            <h1>MicroMANAGER</h1>
            <h2></h2>
        </header>
        <nav class="spaced">
            <li><a class="linkOnDark" href="finalIndex.html">Home</a></li>
            <li><a class="linkOnDark" href="about.html">About MicroManager</a></li>
            <li><a class="linkOnDark" href="">Contact Us</a></li>
            <li><a class="linkOnDark" href="logout.php">Logout</a></li>
        </nav>
        <section class="frame">
            <!-- Insert field into element -->
            <h3>Edit Team Member: {Enter Team Member Name}</h3>
            <!-- populate form with existing Team Member info from database -->
            <form id="form1" name="form1" method="post" action="insertmember.php">
                <p>
                    <label for="firstName">First Name: </label>
                    <input type="text" name="firstName" id="firstName" />
                </p>

                <p>
                    <label for="lastName">Last Name:</label>
                    <input type="text" name="lastName" id="lastName" />
                </p>

                <p>
                    <input type="checkbox" name="isManager" id="isManager" />
                    <label for="isManager">Check box if user should have manager permissions.</label>
                </p>

                <p>
                    <label for="userLogin">Create User Login:</label>
                    <input type="text" name="userLogin" id="userLogin" />
                </p>

                <p>
                    <label for="userPassword">Create User Password</label>
                    <input type="text" name="userPassword" id="userPassword" />
                </p>

                <p>
                    <input type="submit" name="button" id="button" value="Submit" />
                    <input type="reset" name="button2" id="button2" value="Reset" />
                </p>

            </form>

        </section>
        <div class="footer">
            <a href="https://github.com/mistichris/DataStructuresFinal">Git Hub Link</a>
        </div>

        <p>&nbsp;</p>
    </div>
</body>
</html>