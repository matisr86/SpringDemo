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
    <title><s:message code="button.zmianaHasla"/></title>
</head>
<body>
<%@include file = "/WEB-INF/incl/menu.app" %>
<h2>
    <s:message code="button.zmianaHasla"/>
</h2>
<sf:form action="updatepass" id="userForm" modelAttribute="user" enctype="multipart/form-data" method="post" >
    <sf:hidden path="email"/>
    <table width="500" border="0" cellspacing="1" cellpadding="4" align="center">
        <tr>
            <td width="130" align="right"><s:message code="passwordChange.newPassword"/> </td>
            <td width="270" align="left"><sf:password path="newPassword" size="28"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><font color="red"><sf:errors path="newPassword"/> </font> </td>
        </tr>
        <tr>
            <td colspan="2" align="center" bgcolor="#fff">
                <input type="submit" value="<s:message code="button.zmianaHasla"/>"/>
                <input type="button" value="<s:message code="button.cancel"/>" onclick="window.location.href='${pageContext.request.contextPath}/profil'"/>
            </td>
        </tr>
    </table>
</sf:form>
</body>
</html>