<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset-UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
  <link rel="stylesheet" href="css/bootstrap.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.2/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->
<title>Insert title here</title>
</head>
<body>
     <!-- ���Ⱑ ��� �׺���̼� �� -->
	    <nav class="navbar navbar-inverse navbar-fixed-top">
	       <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed"
	               data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
	               aria-expanded="false">
	               <span class="icon-bar"></span>  <!--�ϳ��� ¦���� �����ϸ� �ȴ�.-->
	               <span class="icon-bar"></span>
	               <span class="icon-bar"></span>
	           </button>
	           <a class="navbar-brand" href="/admin/admin">100ȣ�� ���� �ý���</a>
	       </div>
	       <div class ="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	           <ul class="nav navbar-nav navbar-left">
	              <li class="dropdown">
	                 <a href="#" class="dropdown-toggle"
	                    data-toggle="dropdown" role="button" aria-haspopup="true"
	                    aria-expanded="false">������â<span class="caret"></span></a>
	                 <ul class="dropdown-menu">
	                     <li class="active"><a href="/admin/cancel">�������</a></li>
	                     <li><a href="/admin/membership">ȸ������ ����</a></li>
	                     <li><a href="/admin/seatedit">�̿��¼� ����</a></li> 
	                 </ul>
	           </ul>
	             <ul class="nav navbar-nav navbar-right">
              <li><a href=""><span>${admin}</span>��, ȯ���մϴ�.</a></li>    
              <li><a href="/user/logout"><button>�α׾ƿ�</button></a></li>  
           </ul>
           </div>
	     </nav>
</body>
</html>