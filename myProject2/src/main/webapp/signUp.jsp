<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<form method="post" action="minsert">
    <table>
        <tr>
            <th>아이디</th>
            <td><input type="text" name="id"  maxlength="80"
                       value="${id}">
            </td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><input type="text" name="email" maxlength="20"
                       value="${email}">
            </td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name" maxlength="20"
                       value="${name}">
            </td>
        </tr>
    </table><br>
    

    <input type="submit" value="저장" >
    <input type="button" value="취소" onclick="history.back()">
</form>
</body>
</html>