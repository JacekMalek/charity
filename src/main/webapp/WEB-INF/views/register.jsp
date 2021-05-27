<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="header.jsp" %>

<section class="login-page">
    <h2>Załóż konto</h2>

    <form:form method="post" modelAttribute="userDto">
        <div class="form-group">
            <form:input path="username" placeholder="Email" type="email"/>
            <form:errors path="username" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input path="password" placeholder="Hasło" type="password"/>
            <form:errors path="password" cssClass="error"/>
        </div>
        <div class="form-group">
<%--            <form:input path="enabled"/>--%>
<%--            <form:input path="roles"/>--%>
            <form:input path="secondPassword" type="password" name="password2" placeholder="Powtórz hasło"/>
            <form:errors path="secondPassword" cssClass="error"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>

    </form:form>

</section>

<%@include file="footer.jsp" %>
