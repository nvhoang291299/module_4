<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/4/2023
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>condiment list for sandwiches</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <form action="/list" class="border bounded-1" style="width: 200px; text-align: center">
        <h2>condiment list for sandwiches</h2>
        <c:forEach var="element" items="${list}">
            <div class="form-check">
                <label class="form-check-label">${element}
                    <input type="checkbox" class="form-check-input" name="condiment" value="${element}">

                </label>
            </div>
        </c:forEach>
        <button type="submit" class="btn btn-primary">submit</button>
    </form>
    <ul>
        <c:forEach var="condiment" items="${condiments}">
            <li>${condiment}</li>
        </c:forEach>
    </ul>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
