<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width" />
<c:set var="title" value="${param.title}" />
<c:if test="${empty title}">
	<c:set var="title" value="Product Page" />
</c:if>
<title><c:out value="${title}" /></title>
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
	<header>
		<h1>MVC Exercises - Views Part 2: Models</h1>
	</header>
	<nav>
		<ul>
			<c:set var="selected" value=""/>
			
			<c:url var="productList" value="/productList"/>
			<li><a href="${productList}">List Layout</a></li>
			<c:url var="productTiles" value="/productTiles"/>
			<li><a href="${productTiles}">Tile Layout</a></li>
			<c:url var="productTable" value="/productTable"/>
			<li><a href="${productTable}">Table Layout</a></li>
		</ul>
	</nav>