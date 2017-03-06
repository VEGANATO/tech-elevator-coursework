<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="header.jsp">
	<jsp:param name="title" value="Product Detail View" />
</jsp:include>

<section id="main-content-detail">

	<div class="product-detail-div">
		<div class="product-detail-img-div">
			<img id="product-detail-img"
				src="img/<c:out value="${product.imageName}"/>"
				alt="<c:out value="${product.imageName}"/>">
		</div>

		<div class="product-detail-info-div">
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
			<img class="product-rating-img"
				src="img/<fmt:formatNumber value="${product.averageRating}" pattern="#"/>-star.png" />
			<br class="product-br">
			<p class="price">
				Price:
				<fmt:formatNumber value="${product.price}" type="currency" />
			</p>
			<p>
				<strong>Weight </strong>
				<c:out value="${product.weightInLbs}" />
				lbs
			</p>
			<p class="detail-description">
				<strong>Description: </strong>
				<c:out value="${product.description}" />
			</p>

		</div>

	</div>

</section>

<jsp:include page="footer.jsp" />