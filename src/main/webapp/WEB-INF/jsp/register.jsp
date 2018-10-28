<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
    <title><s:message code="menu.register"/></title>
</head>
<body>
<%@include file = "/WEB-INF/incl/menu.app" %>

<h2><s:message code="menu.register"/></h2>
<p align="center">
    <c:out value="${message }" />
</p>

<sf:form id="userForm" action="adduser" modelAttribute="user" enctype="multipart/form-data" method="post">
    <table width="500" border="0" cellspacing="1" cellpadding="4" align="center">
        <tr>
            <td width="130" align="right"><s:message code="register.name"/> </td>
            <td width="270" align="left"><sf:input path="name" size="28" id = "name"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><sf:errors path="name" cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td width="130" align="right"><s:message code="register.lastName"/></td>
            <td width="270" align="left"><sf:input path="lastName" size="28" /> </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><sf:errors path="lastName" cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td width="130" align="right"><s:message code="register.email"/></td>
            <td width="270" align="left"><sf:input path="email" size="28"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><sf:errors path="email" cssClass="error"></sf:errors></td>
        </tr>
        <tr>
            <td width="130" align="right"><s:message code="register.password"/></td>
            <td width="270" align="left"><sf:input path="password" size="28"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><sf:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center" bgcolor="#fff">
                <input type="submit" value="<s:message code="button.register"/>" />
                <!-- kasuje dane i przenosi do strony głównej-->
                <input type="button" value="<s:message code="button.cancel"/> " onclick="window.location.href='${pageContext.request.contextPath} /'"/>
            </td>
        </tr>
    </table>
</sf:form>
</body>
</html>