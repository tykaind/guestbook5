<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-------------------- 등록폼 -------------------->
	<form action="${pageContext.request.contextPath}/add" method="get">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비빌번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>

			<tr>
				<td colspan="4"><input type="text" name="content" value=""
					style="width: 440px; height: 100px;"></td>
					
			</tr>

			<tr>
				<td><button type="submit">확인</button></td>
			</tr>

		</table>
	</form>
	
	<!------------------ 리스트 ------------------>
	<c:forEach items="${guestList}" var="gList">
	<br>
	<table border="1">
		<tr>
			<td>${gList.no}</td>
			<td>${gList.name}</td>
			<td>${gList.reg_date}</td>
			<td><a href="${pageContext.request.contextPath}/deleteForm?no=${gList.no}">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4" height="60">${gList.content}</td>
		</tr>
	</table>
	</c:forEach>
</body>
</html>