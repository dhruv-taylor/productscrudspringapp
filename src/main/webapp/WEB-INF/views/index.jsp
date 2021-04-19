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

	<div class="container">
		<table class="table table-hover tm-5">
			<thead>
				<tr>
					<th>Series Id</th>
					<th>Product Name</th>
					<th>Description</th>
					<th>Price</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="p">
					<tr>
						<td class="font-weight-bold">${p.id}</td>
						<td>${p.name }</td>
						<td>${p.description }</td>
						<td class="font-weight-bold">&#x20B9; ${p.price }</td>
						<td><a href="update/${p.id}"><i class="fa fa-edit"
								style="font-size: 20px; color: orange;"></i></a></td>
						<td><a href="delete/${p.id}"><i class="fa fa-trash"
								style="font-size: 20px; color: red;"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>