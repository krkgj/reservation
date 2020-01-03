<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset-UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel = "shortcut icon" type = "image/png" href="/resources/image/Hansei.png"/>  <!-- favicon 추가 부분입니다. -->
<title>100호실 예약 시스템</title>
</head>
<body>
	<%@ include file="./studentNavBar.jsp" %>
       
      <style>
      th{text-align:center;}
      </style>
      
      <div class="container" style="margin-top:80px">
        <h1>이용시간 / 휴관일</h1>
          <table class="table table-bordered">
           <thead>
             <tr>
             <th>층</th>
             <th>명칭</th>
             <th>이용시간</th>
             <th>휴관일</th>
             </tr>
           </thead>
           <tbody>
             <tr>
             <td rowspan="4" align="center">1층</td>
             <td rowspan="2" align="center">좌석</td>
             <td rowspan="2" align="center">09:00 ~ 22:00</td>
             <td rowspan="4" align="center">매주 토요일 및 일요일은 휴관(법정공휴일도 휴관)</td>
             </tr> 
             <tr>
             <!-- <td></td> -->
             <!-- <td></td> -->
             <!-- <td></td> -->
             <!-- <td></td> -->
             </tr>
             <tr>
             <!-- <td></td> -->
             <td rowspan="2" align="center">스터디룸</td>
             <td rowspan="2" align="center">09:00 ~ 22:00</td>
             <!-- <td></td> -->
             </tr>  
             <tr>
             <!-- <td></td> -->
             <!-- <td></td> -->
             <!-- <td></td> -->
             <!-- <td></td> -->
             </tr>
           </tbody>
          </table>
      </div>
      
    <div>
       <h1 style="color:red;" align="center">주의 사항</h1>
    </div>
     
    <div class="container">  <!-- 고정폭 레이아웃을 만들 때 사용 -->
      <div class="row">
        <div class="col-12">
          <ul class="list-group" align="center">
            <li class="list-group-item">쓰레기를 버리지 말아주세요.</li>
            <li class="list-group-item">휴대폰은 무음으로 해주세요.</li>
            <li class="list-group-item">사용후 자리 정돈해주세요.</li>
            <li class="list-group-item">예약시간 10분후까지 출입하지 않을 시 자동 취소됩니다.</li>
          </ul>
        </div>
      </div>
    </div>
     
     <footer>
       <h3 align="center">문의연락처:010-0000-0000</h3>
     </footer>
     
    <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>