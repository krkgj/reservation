<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset-UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.2/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>100호실 예약시스템</title>
</head>
<body> 

<%@ include file="./adminNavbar.jsp" %>
	      
	     <div class="container" style="margin-top:80px">
			  <h2>회원목록</h2>           
			  <table class="table table-striped">
			    <thead>
			      <tr>
			        <th>이름</th>
			        <th>학번</th>
			        <th>수정</th>
			        <th>삭제</th>
			      </tr>
			    </thead>
			    <tbody>
			    
			    </tbody>
			  </table>
		  </div>
	     
    
     <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
     <script src="js/bootstrap.js"></script>
    
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset-UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.2/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>100호실 예약시스템</title>
</head>
      
<body> 

<%@ include file="./adminNavbar.jsp" %>
         
        <div class="container" style="margin-top:80px">
           <h2>회원목록</h2>           
           <table class="table table-striped">
             <thead>
               <tr>
                 <th>이름</th>
                 <th>학번</th>
                 <!-- <th>수정</th>  -->
                 <th>삭제</th>
               </tr>
             </thead>
             <tbody>
                <c:forEach items="${list}" var="UserVO">
                <tr>
                   <td>${UserVO.uname}</td>
                   <td>${UserVO.unumber}</td>
                   <td><a href="/admin/memberDelete/${UserVO.unumber}">삭제</a></td>
                </tr>   
                </c:forEach>
             </tbody>
             
           </table>
        </div>
        
    
     <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
     <script src="js/bootstrap.js"></script>
    
</body>
</html>