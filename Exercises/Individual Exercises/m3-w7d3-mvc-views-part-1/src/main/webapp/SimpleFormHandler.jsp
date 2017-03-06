<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<%

// Grab the variables from the form.
  String firstName = request.getParameter("firstName");
  String lastName = request.getParameter("lastName");
  String sex = request.getParameter("sex");
  String javaType = request.getParameter("javaType");
%>
<%-- Print out the variables. --%>
<h1>Hello, ${param.firstName} <%=lastName%>!</h1>
I see that you are <%=sex%>. You know, you remind me of a
<%=javaType%> variable I once knew.

</body>
</html>