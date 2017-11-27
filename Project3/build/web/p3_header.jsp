<%-- 
    Document   : p3_login_errors
    Created on : Nov 21, 2017, 7:20:01 PM
    Author     : TuanPhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="p3_style.css" rel="stylesheet" type="text/css"/>
        <script> 
            function validate()
            { 
                var fullname = document.form.fullname.value;
                var username = document.form.username.value; 
                var password = document.form.password.value;
                var conpassword= document.form.conpassword.value;

                if (fullname==null || fullname=="")
                { 
                    alert("Full Name can't be blank"); 
                    return false; 
                }
                else if (username==null || username=="")
                { 
                    alert("Username can't be blank"); 
                    return false; 
                }
                else if(password.length<6)
                { 
                    alert("Password must be at least 6 characters long."); 
                    return false; 
                } 
                else if (password!=conpassword)
                { 
                    alert("Confirm Password should match with the Password"); 
                    return false; 
                } 
             } 
        </script>
    </head>
    
    <body>
        <div class="wrap">
            <h1>Welcome to CSC 4370 Book Store </h1>
            <div class="navbarWrap navbar" id="nav"> 
                <a href="p3_guestView.jsp">Home</a>
                <a href="p3_login.jsp">Login</a>
                <a href="p3_register.jsp">Registration</a>
                
            </div>
        </div>
        <div class="main">
            <div class="wrap">
   