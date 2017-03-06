<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="header.jsp">
	<jsp:param name="title" value="Product List View" />
</jsp:include>

<section id="main-content-list">
	<h1>Toy Department</h1>

	<c:forEach var="product" items="${requestScope.productList}">

		<div class="product-div">
			<div class="product-img-div">
				<c:url var="productDetail" value="/productDetail">
					<c:param name="productId" value="${product.productId}" />
				</c:url>
				<a href="${productDetail}"><img class="product-img"
					src="img/<c:out value="${product.imageName}"/>"
					alt="<c:out value="${product.imageName}"/>"></a>
			</div>

			<div class="product-info-div">
				<h3>
					<c:out value="${product.name}" />
					<c:if test="${product.topSeller}">
					<span class="best-seller">BEST SELLER!</span>
				</c:if>
				</h3>
				
				<p>
					by
					<c:out value="${product.manufacturer}"></c:out>
				</p>
				<span class="price"><fmt:formatNumber value="${product.price}"
						type="currency" /></span>
				<p>
					<strong>Weight </strong>
					<c:out value="${product.weightInLbs}" />
					lbs
				</p>
				<img class="product-rating-img"
					src="img/<fmt:formatNumber value="${product.averageRating}" pattern="#"/>-star.png" />
				<br class="product-br">
			</div>

		</div>

	</c:forEach>


</section>
<jsp:include page="footer.jsp" />