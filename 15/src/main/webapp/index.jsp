<%@ page import="com.sun.org.apache.xpath.internal.operations.Bool" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Work</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 auth">
                <p class="calculator">
                    Calculator
                </p>

                <form action="/calculatorServlet" id="jform" method="post">
                    <div class="form-group" id="form-val1">
                        <input type="text" name="number-1" class="form-control" id="val1">
                        <span id="success"></span>
                    </div>
                    <div class="form-group" id="select">
                        <select class="form-control" name="operation" id="select-val">
                            <% String[] array = {"+", "-", "*", "/", "sin", "cos", "ln", "exp"};
                                for (int i = 0; i < array.length; i++) {%>
                            <option value="<%=i+1%>">
                                <%=array[i]%>
                            </option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group" id="form-val2">
                        <input type="text" name="number-2" class="form-control" id="val2">
                        <span id="success1"></span>
                    </div>
                    <div class="message-window">
                        <% if (session.getAttribute("error") != null || session.getAttribute("answer") != null) { %>
                        <p class="col-md-12 bg-<%=((session.getAttribute("error") == null) ?"succses": "danger")%>">
                            <%=((session.getAttribute("error") == null) ? ("Result: " + session.getAttribute("answer")) : "Error: " + session.getAttribute("error"))%>
                            <% if (session.getAttribute("error") == null) {
                                session.removeAttribute("answer");
                            } else {
                                session.removeAttribute("error");
                            }%>
                        </p>
                        <% } %>
                    </div>
                    <button class="btn btn-success button-auth col-xs-12" id="button">Calculate</button>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"
        charset="utf-8"></script>
<script type="text/javascript" src="js/calculate.js" charset="utf-8"></script>
</body>
</html>