<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="layout/base.jsp"%>
</head>
<body>
	<%@include file="layout/navbar.jsp"%>

	<div class="container mt-5">
		<form action="productHandle" method="post">
			<div class="form-group">
				<label for="name">Product Name:</label> <input type="text"
					class="form-control" id="name" placeholder="Enter Product"
					name="name">
			</div>
			<div class="form-group">
				<label for="description">Product Description:</label>
				<textarea class="form-control" id="description" name="description"></textarea>
			</div>
			<div class="form-group">
				<label for="price">Product Price:</label> <input type="number"
					class="form-control" id="price" placeholder="Enter price"
					name="price">
			</div>
			<a href="${pageContext.request.contextPath }/"
				class="btn btn-secondary">Back</a>
			<button type="submit" class="btn btn-primary">+ Add Product</button>
		</form>
	</div>

	<p>${author}</p>
	<p>${programmer}</p>

</body>
</html>