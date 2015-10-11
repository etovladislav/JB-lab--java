<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>table</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        body {
            padding-top: 100px;
        }

        input {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="container col-md-12">
    <div class="col-md-4 col-md-offset-4 ">
        <form action="/table" method="post">

            <label>Имя*</label>
            <input type="text" class="form-control" name="firstName" placeholder="Владисдав" required>

            <label>Фамилия*</label>
            <input type="text" class="form-control" name="lastName" placeholder="Ульянов" required>

            <label>Отчество*</label>
            <input type="text" class="form-control" name="middleName" placeholder="Сергеевич" required>

            <label>Дата рождения</label>
            <input type="date" class="form-control" name="birthday">

            <label>Пол</label>

            <div class="radio">
                <label>
                    <input type="radio" name="sex" value="M">
                    Мужской
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="sex" value="W">
                    Женский
                </label>
            </div>
            <button class="btn btn-default pull-right" id="button">Добавить</button>
        </form>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</body>
</html>
