<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts List</title>
</head>
<body>
  <h2>All Contacts List</h2>

  <table>
     <tr>
      <th>FirstName</th>
      <th>LastName</th>
      <th>Email</th>
      <th>Mobile</th>
      <th>Source</th>
      <th>Billing</th>
      </tr>
    <c:forEach var="contact" items="${contacts}">
      <tr>
        <td>${contact.firstName}</td>
        <td>${contact.lastName}</td>
        <td>${contact.email}</td>
        <td>${contact.mobile}</td>
        <td>${contact.source}</td>
        <td><a href="billing?id=${contact.id}">billing</a></td>
      </tr>
    </c:forEach>
  
  </table>
  
</body>
</html>