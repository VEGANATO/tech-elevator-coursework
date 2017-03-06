<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<%

// Grab the variables from the form.
  String firstNum = request.getParameter("firstNum");
  String secNum = request.getParameter("secNum");
  
  Integer firstNumInteger = Integer.parseInt(firstNum);
  Integer secNumInteger = Integer.parseInt(secNum);

  int hamDist = Integer.bitCount(firstNumInteger ^ secNumInteger);
%>

<%-- Print out the variables. --%>
<p>The hamming distance between <%=firstNum%> and <%=secNum%>
is <%=hamDist %>.
</p>

</body>
</html>