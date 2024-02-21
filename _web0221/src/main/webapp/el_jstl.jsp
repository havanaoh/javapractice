<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setAttribute("name", "홍길동"); // 포워딩 된 것으로 가정
	request.setAttribute("arr2", new int[] {1,2,3,4,5,});
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${intArray = [100,200,300,400,500]}// 8번 라인 코드와 동일<br> 
<c:forEach var="v" items="${intArray}" varStatus="st">
${v} : ${st.index} : ${st.count }<br> 
</c:forEach>

<c:forEach var="v" items="${arr2}" varStatus="st">
${v} : ${st.index} : ${st.count }<br> 
</c:forEach>

${sum=0;''}
${var=0;''}
<c:forEach var="i" begin="1" end="10">
${sum=sum+i;''}
</c:forEach>
1부터 10까지의 합 : ${sum}<br>
<c:forEach var="i" begin="0" end="10" step="2">
${var=var+i;''}
</c:forEach>
0부터 10까지의 합 : ${var}<br>
<c:forEach var="i" begin="0" end="10" step="2">
${i}
${s = s + i;''}
</c:forEach>
<br>
1~10까지의 짝수의 합 : ${s}<br>
${name}<br>
${aaa = '3.14'; ''}<br>
${aaa + 100; ''}<br>
${aaa = aaa + 10}<br>
${"10"+1}<br>
${null+10}<br>
${null+null}<br>

</body>
</html>