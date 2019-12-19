<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/resources/qrcode/qrcode.js"></script>
<title>바코드 테스트용 페이지입니다.</title>
</head>
<body>
		<h1>바코드 테스트용 페이지입니다.</h1>
		<div id="qrcode"></div>
		
		<script type="text/javascript">
		/* session에 저장되어있는 "qrcode" 를 꺼내 qrcode를 생성해줍니다. */
		var value = '<%=session.getAttribute("qrcode")%>';  
    	var qrcode = new QRCode(document.getElementById("qrcode"), {
        text: value,
        width: 128,
        height: 128,
        colorDark : "#000000",
        colorLight : "#ffffff",
        correctLevel : QRCode.CorrectLevel.H
    	});
    </script>
</body>
</html>
