<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="header.jsp">
	<jsp:param name="title" value="Product Tiles View" />
</jsp:include>

<section id="main-content-tiles">
	<h1>Toy Department</h1>
	<c:forEach var="product" items="${requestScope.productList}">

		<div class="product-tile-div">
			<img class="product-img"
				src="img/<c:out value="${product.imageName}"/>"
				alt="<c:out value="${product.imageName}"/>">
			<h4>
				<c:out value="${product.name}" />
				<c:if test="${product.topSeller}">
					<span class="best-seller">BEST SELLER!</span>
				</c:if>
			</h4>
			<p>
				by
				<c:out value="${product.manufacturer}"></c:out>
			</p>
			<p>
				<c:if test="${product.remainingStock < 3}">
					<span class="low-stock">Only <c:out value="${product.remainingStock}"/> left!</span>
				</c:if>
			</p>
			<span class="price"><fmt:formatNumber value="${product.price}"
					type="currency" /></span>
			<p>
				<strong>Weight </strong>
				<c:out value="${product.weightInLbs}" />
				lbs
			</p>
			<img class="product-table-rating-img"
				src="img/<fmt:formatNumber value="${product.averageRating}" pattern="#"/>-star.png" />
		</div>
	</c:forEach>
</section>

<jsp:include page="footer.jsp" />