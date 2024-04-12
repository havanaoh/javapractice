<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>설문조사</title>
</head>
<body>
    <h2>설문조사</h2>
    <form method="post">    
    <p>
        1. 당신의 역할은 무엇입니까?<br/>
            <label><input type="radio" 
                           name="responses[0]" value="서버">
                서버</label>
            
            <label><input type="radio" 
                           name="responses[0]" value="프론트">
                프론트</label>
            
            <label><input type="radio" 
                           name="responses[0]" value="풀스택">
                풀스택</label>
            
            <label><input type="radio" 
                           name="responses[0]" value="백엔드">
                백엔드</label>
            
        
        
    </p>
    
    <p>
        2. 많이 사용하는 개발도구는 무엇입니까?<br/>
        
            
            <label><input type="radio" 
                           name="responses[1]" value="이클립스">
                이클립스</label>
            
            <label><input type="radio" 
                           name="responses[1]" value="인텔리J">
                인텔리J</label>
            
            <label><input type="radio" 
                           name="responses[1]" value="서브라임">
                서브라임</label>
            
        
        
    </p>
    
    <p>
        3. 하고 싶은 말을 적어주세요.<br/>
        
        
        <input type="text" name="responses[2]">
        
    </p>
    

    <p>
        <label>응답자 위치:<br>
        <input type="text" name="res.location">
        </label>
    </p>
    <p>
        <label>응답자 나이:<br>
        <input type="text" name="res.age">
        </label>
    </p>
    <input type="submit" value="전송">
    </form>
</body>
</html>
