<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Exercise 1 - FizzBuzz</title>
<style>
li {
	list-style-type: none;
}

.fizz {
	color: blue;
}

.buzz {
	color: red;
}

.fizzbuzz {
	color: purple;
	font-size: 150%;
}
</style>
</head>
<body>
	<h1>Exercise 1 - FizzBuzz</h1>
	<ul>
		<%--
				Add a list item (i.e. <li>) containing each of the numbers from 1 to 100.
				
				if the number is divisible by 3, show "Fizz!" instead and style the item using the "fizz" class
				
				if the number is divisible by 5, show "Buzz!" instead and style the item using the "buzz" class
				
				if the number is divisible by both 3 and 5, show "FizzBuzz!" instead  and style the item using the "fizzbuzz" class
				
				see exercise1-fizzbuzz.png for example output
			 --%>

		<c:set var="count" value="${param.count}" />
		
		<c:if test="${empty count}">
			<c:set var="count" value="100" />
		</c:if>
		
		<c:forEach begin="1" end="${count}" var="index">
			<c:set var="rowClassAttribute" value="" />
			<c:choose>
				<c:when test="${index % 15 == 0}">
					<c:set var="rowClassAttribute" value="fizzbuzz" />
					<li class = "${rowClassAttribute}">FizzBuzz!</li>
				</c:when>
				<c:when test="${index % 5 == 0}">
					<c:set var="rowClassAttribute" value="buzz" />
					<li class = "${rowClassAttribute}">Buzz!</li>
				</c:when>
				<c:when test="${index % 3 == 0}">
					<c:set var="rowClassAttribute" value="fizz" />
					<li class = "${rowClassAttribute}">Fizz!</li>
				</c:when>
				<c:otherwise>
					<li>${index}</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
</body>
</html>