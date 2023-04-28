<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/4/2023
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Calculator</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <form action="/calculator">
            <div class="input-group">
                <label for="firstNumber">first number:</label>
                <input type="number"
                       class="form-control" name="firstNumber" id="firstNumber" aria-describedby="helpId" placeholder="">
                    <label for="calculation">calculation</label>
                    <select class="form-select" name="operator" id="calculation">
                        <option value="+">addition</option>
                        <option value="-">subtraction</option>
                        <option value="*">multiplication</option>
                        <option value="/">division</option>
                    </select>
                <label for="secondNumber">second number:</label>
                <input type="number"
                       class="form-control" name="secondNumber" id="secondNumber" aria-describedby="helpId" placeholder="">
                <label for="result">result:</label>
                <input type="number"
                       class="form-control" name="result" id="result" aria-describedby="helpId" value="${result}" readonly>
                <button class="btn btn-primary">Calculate</button>
            </div>
        </form>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
