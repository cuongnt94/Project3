<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Register</title>

    <style type="text/css">
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* Change the link color to #111 (black) on hover */
        li a:hover {
            background-color: #111;
        }


    </style>
</head>
<body>


<% String s = (String)request.getAttribute("errors");
%>

<% if(s!=null) {%>
<h3 align="center" style="color: red" ><%= s %></h3>

<%	} %>
<div id="wrapper">
    <form  action="/auth/register?redirect=${param.redirect}" method="post">

        <div class="header">
            <h1>Register </h1>
            <span></span>
        </div>
        <div>
            <input name="token" id="token" type="text" class="input token" placeholder="token" />

        </div>
        <div>
            <input name="username" type="text" class="input username" placeholder="Username" />
        </div>
        <div>
            <input name="email" type="text" class="input username" placeholder="Email" />
        </div>

            <input name="password" type="password" class="input password" placeholder="Password" />
        <div class="pass-icon"></div>

<%--        <input name="re-password" type="password" class="input password" placeholder="re-enter Password" /> *--%>
<%--        <div class="pass-icon"></div>--%>

<%--        <input name="firstname" type="text" class="input username" placeholder="First Name" />--%>
<%--        <div class="user-icon"></div>--%>
<%--        <input name="lastname" type="text" class="input username" placeholder="Last Name" />--%>
<%--        <div class="user-icon"></div>--%>
<%--        <input name="dob" type="text" class="input username" placeholder="Date of Birth" />--%>
<%--        <div class="user-icon"></div>--%>
<%--        <input name="phone" type="text" class="input username" placeholder="Phone" />--%>
<%--        <div class="user-icon"></div>--%>
<%--        <div class="user-icon"></div>--%>


</div>

<div class="footer">
    <input type="submit" class="button" name="submit" value="Register" class="register" />
</div>
</form>
<div>${error}</div>
</div>
<div class="gradient"></div>


</body>
</html>
