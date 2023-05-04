<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2023
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>setting</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .table {
            width: 200px;
        }
    </style>
</head>
<body>
<div class="container">
    <form:form action="/setting" method="post" modelAttribute="email">
        <h2>Settings</h2>
        <table class="table">
            <tr>
                <td><form:label path="language">Languages:</form:label></td>
                <td><form:select path="language" >
                    <form:options items="${languages}" />
                </form:select></td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page Size:</form:label></td>
                <td>Show <form:select path="pageSize" >
                    <form:options items="${pageSizes}" />
                </form:select> emails per page</td>
            </tr>
            <tr>
                <td><form:label path="spamsFilter">Spams Filter:</form:label></td>
                <td><form:checkbox path="spamsFilter" value="Enable spams filter"/>Enable spams filter</td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature:</form:label></td>
                <td><form:textarea path="signature" /></td>
            </tr>
            <tr>
                <td><button class="btn btn-primary">Update</button><button class="btn btn-secondary">Cancel</button></td>
            </tr>
        </table>
    </form:form>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
