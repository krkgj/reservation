<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Room100 Reservation System</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="/resources/plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />
    <link rel = "shortcut icon" type = "image/png" href="/resources/image/Hansei.png"/>
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:900&display=swap&subset=korean" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>
.hero {
  background-color: #489CFF;
  position: relative;
  height: 100vh;
  overflow: hidden;
  font-family: 'Noto Sans KR', sans-serif;
}

.hero__title {
  color: #fff;
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
          transform: translate(-50%, -50%);
  font-size: 50px;
  z-index: 1;
}

.cube {
  position: absolute;
  top: 80vh;
  left: 45vw;
  width: 10px;
  height: 10px;
  border: solid 1px #003298;
  -webkit-transform-origin: top left;
          transform-origin: top left;
  -webkit-transform: scale(0) rotate(0deg) translate(-50%, -50%);
          transform: scale(0) rotate(0deg) translate(-50%, -50%);
  -webkit-animation: cube 12s ease-in forwards infinite;
          animation: cube 12s ease-in forwards infinite;
}
.cube:nth-child(2n) {
  border-color: #0051f4;
}
.cube:nth-child(2) {
  -webkit-animation-delay: 2s;
          animation-delay: 2s;
  left: 25vw;
  top: 40vh;
}
.cube:nth-child(3) {
  -webkit-animation-delay: 4s;
          animation-delay: 4s;
  left: 75vw;
  top: 50vh;
}
.cube:nth-child(4) {
  -webkit-animation-delay: 6s;
          animation-delay: 6s;
  left: 90vw;
  top: 10vh;
}
.cube:nth-child(5) {
  -webkit-animation-delay: 8s;
          animation-delay: 8s;
  left: 10vw;
  top: 85vh;
}
.cube:nth-child(6) {
  -webkit-animation-delay: 10s;
          animation-delay: 10s;
  left: 50vw;
  top: 10vh;
}

@-webkit-keyframes cube {
  from {
    -webkit-transform: scale(0) rotate(0deg) translate(-50%, -50%);
            transform: scale(0) rotate(0deg) translate(-50%, -50%);
    opacity: 1;
  }
  to {
    -webkit-transform: scale(20) rotate(960deg) translate(-50%, -50%);
            transform: scale(20) rotate(960deg) translate(-50%, -50%);
    opacity: 0;
  }
}

@keyframes cube {
  from {
    -webkit-transform: scale(0) rotate(0deg) translate(-50%, -50%);
            transform: scale(0) rotate(0deg) translate(-50%, -50%);
    opacity: 1;
  }
  to {
    -webkit-transform: scale(20) rotate(960deg) translate(-50%, -50%);
            transform: scale(20) rotate(960deg) translate(-50%, -50%);
    opacity: 0;
  }
}
</style>
  </head>
  <body class="login-page">
   <div class="hero">
  <div class="cube"></div>
  <div class="cube"></div>
  <div class="cube"></div>
  <div class="cube"></div>
  <div class="cube"></div>
  <div class="cube"></div>
    <div class="login-box">
      <div class="login-logo">
        <a href="/user/login"><b>100호실</b>예약시스템</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <img src="/resources/image/Hansei.png" style="margin-left: auto; margin-right: auto; display:block;">
        <p class="login-box-msg">학번과 이름을 입력해주세요.
        </p>

<form action="/user/loginError" method="post">
  <div class="form-group has-feedback">
    <input type="text" name="uname" class="form-control" placeholder="이름"/>
    <span class="glyphicon glyphicon-user form-control-feedback"></span>
  </div>
  <div class="form-group has-feedback">
    <input type="password" name="unumber" class="form-control" placeholder="학번"/>
    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
  </div>
  <div class="row">
    <div class="col-xs-8">    
                         
    </div><!-- /.col -->
    <div class="col-xs-4">
      <button type="submit" class="btn btn-primary btn-block btn-flat">로그인</button>
    </div><!-- /.col -->
  </div>
</form>


      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    </div >
    <!-- jQuery 2.1.4 -->
    <script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="/resources/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script> 
   
  </body>
</html>