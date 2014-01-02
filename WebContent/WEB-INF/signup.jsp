<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sign Up</title>
	<link type="text/css" rel="stylesheet" href="inc/form.css" />
</head>
<body>
        <form method="post" action="signup">
            <fieldset>
                <legend>Sign Up</legend>
                <p>Please enter the following information to register.</p>

                <label for="email">Email address<span class="required">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${user.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.errors['email']}</span>
                <br />

                <label for="password">Password <span class="required">*</span></label>
                <input type="password" id="password" name="passwd" value="" size="20" maxlength="20" />
                <span class="erreur">${form.errors['password']}</span>
                <br />

                <label for="confirmation">Password confirmation <span class="required">*</span></label>
                <input type="password" id="confirmation" name="passwd_confirm" value="" size="20" maxlength="20" />
                <span class="erreur">${form.errors['passwd_confirm']}</span>
                <br />

                <label for="name">Name</label>
                <input type="text" id="name" name="name" value="<c:out value="${user.name}"/>" size="20" maxlength="20" />
                <span class="erreur">${form.errors['name']}</span>
                <br />

                <input type="submit" value="Register" class="noLabel" />
                <br />
                
                <p class="${empty form.errors ? 'success' : 'error'}">${form.results}</p>
            </fieldset>
        </form>
    </body>
</html>