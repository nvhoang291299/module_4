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
        .w-300 {
            width: 300px;
        }
    </style>
</head>
<body>
<div class="container">
    <form:form action="/setting" method="post" modelAttribute="email">
        <h2>Settings</h2>
        <div class="w-300 border bounded-1 p-2">
            <div class="visually-hidden">${email.id}</div>
            <div class="row">
                <div class="col-3"><form:label path="language">Languages:</form:label></div>
                <div class="col-9"><form:select path="language" >
                    <form:options items="${languages}" />
                </form:select></div>
            </div>
            <div class="row">
                <div class="col-3"><form:label path="pageSize">Page Size:</form:label></div>
                <div class="col-9">Show <form:select path="pageSize" >
                    <form:options items="${pageSizes}" />
                </form:select> emails per page</div>
            </div>
            <div class="row">
                <div class="col-3"><form:label path="spamsFilter">Spams Filter:</form:label></div>
                <div class="col-9"><form:checkbox path="spamsFilter" value="Enable spams filter"/>Enable spams filter</div>
            </div>
            <div class="row">
                <div class="col-3"><form:label path="signature">Signature:</form:label></div>
                <div class="col-9"><form:textarea path="signature" /></div>
            </div>
            <div class="row">
                <div class="col-3"><button class="btn btn-primary">Update</button></div>
                <div class="col-9"><button class="btn btn-secondary">Cancel</button></div>
            </div>
        </div>
    </form:form>
    </div>
<div class="row w-300">
    <div class="col-12">language: ${emailUpdate.language}</div>
    <div class="col-12">page size: ${emailUpdate.pageSize}</div>
    <div class="col-12">spam filter: ${emailUpdate.spamsFilter}</div>
    <div class="col-12">signature: ${emailUpdate.signature}</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
