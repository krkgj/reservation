<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<<<<<<< HEAD
  <link rel = "shortcut icon" type = "image/png" href="/resources/image/admin.png"/>  <!-- favicon 추가 부분입니다. -->
<title>100호실 예약시스템</title>
=======
<title>100�샇�떎 �삁�빟�떆�뒪�뀥</title>
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc
</head>
      
<body> 

<%@ include file="./adminNavbar.jsp" %>
<<<<<<< HEAD
         
        <div class="container" style="margin-top:80px">
           <h2>회원목록</h2>           
           <table class="table table-striped">
             <thead>
               <tr>
                 <th>이름</th>
                 <th>학번</th>
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
        
=======
	      
	     <div class="container" style="margin-top:80px">
			  <h2>�쉶�썝紐⑸줉</h2>           
			  <table class="table table-striped">
			    <thead>
			      <tr>
			        <th>�씠由�</th>
			        <th>�븰踰�</th>
			        <th>�닔�젙</th>
			        <th>�궘�젣</th>
			      </tr>
			    </thead>
			    <tbody>
			    
			    </tbody>
			  </table>
		  </div>
	     
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc
    
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
<title>100�샇�떎 �삁�빟�떆�뒪�뀥</title>
</head>
      
<body> 

<%@ include file="./adminNavbar.jsp" %>
         
        <div class="container" style="margin-top:80px">
           <h2>�쉶�썝紐⑸줉</h2>           
           <table class="table table-striped">
             <thead>
               <tr>
                 <th>�씠由�</th>
                 <th>�븰踰�</th>
                 <!-- <th>�닔�젙</th>  -->
                 <th>�궘�젣</th>
               </tr>
             </thead>
             <tbody>
                <c:forEach items="${list}" var="UserVO">
                <tr>
                   <td>${UserVO.uname}</td>
                   <td>${UserVO.unumber}</td>
                   <td><a href="/admin/memberDelete/${UserVO.unumber}">�궘�젣</a></td>
                </tr>   
                </c:forEach>
             </tbody>
             
           </table>
        </div>
        
    
     <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
     <script src="js/bootstrap.js"></script>
    
</body>
</html>