<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset-UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel = "shortcut icon" type = "image/png" href="/resources/image/Hansei.png"/>  <!-- favicon 추가 부분입니다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> <!-- jquery 사용을 위해 추가 -->
<title>예약 취소</title>
</head>
<body>
	<%@ include file="./studentNavBar.jsp" %>
	    	  
	    <div class="container" style="margin-top:80px">
			  <h2>예약목록</h2>     
			        
			  <table class="table table-striped">
			    <thead>
			      <tr>
			        <th>이름</th>
			        <th>학번</th>
			        <th>시작시간</th>
			        <th>끝시간</th>
			        <th>좌석</th>
			        <th>삭제</th>
			      </tr>
			    </thead>
				<tbody>
					<tr>
					  <td>${Username}</td>
					  <td>${Usernumber}</td>
					  <td>${reserveStartTime}</td>
					  <td>${reserveEndTime}</td>
					  <td>${seat}</td>
					  <td><a  href="/sysview/UserCancelAction/${Username}">삭제</a></td>
					</tr>
				</tbody>			    	
			  </table>
		  </div> 	    
     <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
     <script src="js/bootstrap.js"></script>
</body>
</html>