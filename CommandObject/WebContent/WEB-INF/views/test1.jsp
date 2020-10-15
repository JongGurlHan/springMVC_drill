<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1</h1>
	<!-- request영역에 저장되는 bean 이름은 소문자로 변경됨 -->
	<h3>data1 : ${requestScope.dataBean.data1 }</h3>
	<h3>data1 : ${dataBean.data2 }</h3>
</body>
</html>