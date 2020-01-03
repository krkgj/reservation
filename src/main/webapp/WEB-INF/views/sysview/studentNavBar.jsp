<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset-UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.2/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->
<title>Insert title here</title>
</head>
<body>
     <!-- 여기가 상단 네비게이션 바 -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
       <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed"
               data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
               aria-expanded="false">
               <span class="icon-bar"></span>  <!--하나의 짝대기로 생각하면 된다.-->
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
           </button>
           <a class="navbar-brand" href="/sysview/caution">100호실 예약 시스템</a>
       </div>
       <div class ="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
           <ul class="nav navbar-nav navbar-left">
              <li class="dropdown">
                 <a href="#" class="dropdown-toggle"
                    data-toggle="dropdown" role="button" aria-haspopup="true"
                    aria-expanded="false">접속하기<span class="caret"></span></a>
                 <ul class="dropdown-menu">
                     <li class="active"><a href="/sysview/seat">좌석</a></li>
                     <li><a href="/sysview/room">스터디룸</a></li>
                     <li><a href="/sysview/usercancel">예약취소
                     </a></li>
                 </ul>
           </ul>
           
           <ul class="nav navbar-nav navbar-center">
              <li><a href="/user/logout"><button>로그아웃</button></a></li>    
           </ul>
           <ul class="nav navbar-nav navbar-right">
              <li><a href="/sysview/userinfo"><span>${uname}</span>님, 환영합니다.</a></li>    
           </ul>
        </div>
    </nav>
</body>
</html>