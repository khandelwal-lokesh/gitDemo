<%@page import="java.util.List"%>
<%@page import="com.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>in success</title>
</head>
</head>
<body bgcolor="orange">
Login Succesfull...<br>

<table border="2">
<tr>
<th>Id </th>
<th>Name </th>
<th>Addr </th>
<th> User</th>
<th>Pass </th>
</tr>
 <%List<Employee> emp=(List<Employee>)request.getAttribute("einfo");%>
 <%for(Employee e:emp)
 {%>
 <tr>
<td> <%=e.getEid()%> </td>
<td> <%=e.getName()%></td>
<td> <%=e.getAddress() %></td>
<td> <%=e.getUsername() %></td>
<td> <%=e.getPassword() %></td>
</tr>
<% }%>
</tr>
</table>
</body>
</html>