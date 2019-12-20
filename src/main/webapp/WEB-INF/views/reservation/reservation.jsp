<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   <script src="/resources/qrcode/qrcode.js"></script>
   <link rel = "shortcut icon" type = "image/png" href="/resources/image/Hansei.png"/>  <!-- favicon 추가 부분입니다. -->
<title>예약완료</title>
</head>
<body>

      <div id="qrcode" align="center"></div>
      
      <script type="text/javascript">
      /* session에 저장되어있는 "qrcode" 를 꺼내 qrcode를 생성해줍니다. */
      var value = '<%=session.getAttribute("qrcode")%>';  
       var qrcode = new QRCode(document.getElementById("qrcode"), {
        text: value,
        width: 512,
        height: 512,
        colorDark : "#000000",
        colorLight : "#ffffff",
        correctLevel : QRCode.CorrectLevel.H
       });
       </script>
    
</body>
</html>