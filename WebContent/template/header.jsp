<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!-- Latest compiled and minified CSS -->
<script src="${context}/resources/lib/jquery/jquery-1.11.3.min.js"></script> 

<link rel="stylesheet" href="${context}/resources/lib/bootstrap-3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="${context}/resources/lib/bootstrap-3.3.4/css/bootstrap-theme.min.css">

<!-- Style css -->
<link rel="stylesheet" href="${context}/resources/css/style.css">

<!-- Latest compiled and minified JavaScript -->
<script src="${context}/resources/lib/bootstrap-3.3.4/js/bootstrap.min.js"></script> 
<title>Gestion Des Stagiaires</title>
</head>
<body>
 <%
 String admin = (String)session.getAttribute("admin");
        String menu = null;
        if (admin == null) {
        	menu = "menu.jsp";
        } else {
        	menu = "menuAdmin.jsp";
        }
%>

 <jsp:include page="<%=menu%>"></jsp:include>
