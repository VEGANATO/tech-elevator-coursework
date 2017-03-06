<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Exercise 3 - Echo</title>
		<style>
			li {
				list-style-type: none;
			}
		</style>
	</head>
	<body>
		<h1>Exercise 3 - Echo</h1>
		
		<ul>
		<%--
			Given two query string parameters, "word" and "count":
			
			Add a number of list items equal to "count".  Each list item should contain the value passed in "word".
			
			The font size of the first list item should be equal to "count".  The font size of each subsequent list
			item should be decreased by 1.
			 
			See exercise3-echo.png for example output
		 --%>
		 
		 <c:set var="count" value="${param.count}"></c:set>
		 <c:set var="word" value="${param.word}"></c:set>
		 
		 <c:if test="${empty count}">
		 	<c:set var="count" value="30"></c:set>
		 </c:if>
		 
		 <c:if test="${empty word}">
		 	<c:set var="word" value="All code and no play makes Brian a dull boy"></c:set>
		 </c:if>
		 
		 <c:forEach begin="0" end="${count}" var="index">
		 	<li style="font-size: ${count - index}px">${word}</li>
		 </c:forEach>
		 
		</ul>
		
	</body>
</html>