<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="School_ManagementDao1.*"%>
<%@page import="School_ManagementDto.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
EntityManagerFactory emf = Persistence.createEntityManagerFactory("Raj");
EntityManager  em =emf.createEntityManager(); 
Query q=em.createQuery("select t from Teacher t");
List<Teacher>l=q.getResultList();
%>
<h2>Teachers Data</h2>
<table border="2px">
<tr>
<th>Id</th>
<th>Name</th>
<th>salary</th>
</tr>
<%
for(Teacher t:l)
{
%>
<tr>
<th><%=t.getId()%></th>
<th><%=t.getName()%></th>
<th><%=t.getSalary()%></th>
</tr>
<%
}
%>
</table>
<a href="Teacher.html">Main bar</a>
</body>
</html>