<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onClick="test()">클릭</button>
<h1 id="title">헬로우 jsp</h1>
<h1 class="title2">헬로우 jsp2</h1>
<script>
function test(){
	//let으로 변수선언
	let str = document.getElementById(title); // str이 주소값
	let str2 = document.querySelector("#title"); //#은 id
	let str3 = document.querySelector(".title2"); // .은 class
	console.log("안녕 JSP", '이것도 나오나', str, str2, str3);
	str3.innerHTML = "테스트";
}
</script>
</body>
</html>