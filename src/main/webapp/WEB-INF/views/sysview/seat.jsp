<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset-UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:900&display=swap&subset=korean" rel="stylesheet">
<link rel = "shortcut icon" type = "image/png" href="/resources/image/Hansei.png"/>  <!-- favicon 추가 부분입니다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> <!-- jquery 사용을 위해 추가 -->
<title>100호실 예약 시스템</title>
</head>
<style>
      body{
        background-image : url('/resources/image/HanseiUI.png');
        background-repeat : no-repeat; 
        background-position : 50% 30%;
        background-size: center;
        }
      .here{
        font-family: 'Noto Sans KR', sans-serif;
      }
    </style>
<body>
   <%@ include file="./studentNavBar.jsp" %>
     
      <!-- 4개만 체크되게 하기 -->
    <script>
       function count_ck(obj){
      var chkbox = document.getElementsByName("reservateTime");
      var chkCnt = 0;
      for(var i=0;i<chkbox.length; i++){
        if(chkbox[i].checked){
           chkCnt++;
         }
      }
      if(chkCnt>4){  
       alert("최대 4시간 예약 할 수 있습니다");
       obj.checked = false;
       return false;
       }
     }
    </script>
                    
     <!-- 동떨어져있는 시간을 예약하는 것을 방지 -->               
<!--     <script>  
    $(function(){
       $('input[type="submit"]').click(function() {  /* 예약하기 버튼을 클릭시에 실행됩니다. */
             var chkboxIDarr = new Array();            /* 선택된 체크박스의 ID들을 담을 배열을 선언합니다. */   
             var chkbox = document.getElementsByName("reservateTime"); 
            for(var i=0;i<chkbox.length; i++){  /* 체크박스의 Name 속성을 통해 체크박스를 가져와서 체크박스들의 길이만큼 반복하여 체크된 체크박스들을 검사합니다. */         
                if(chkbox[i].checked){
                   chkboxIDarr[i] = chkbox[i].id; /* 체크된 체크박스에 ID 값을 얻어와 chkboxID 배열에 담습니다. */
                   console.log(chkboxIDarr[i]);   /* 웹브라우저 콘솔에 찍어 ID 값이 제대로 들어갔는지 확인했습니다. */
                 }
                else{
                   chkboxIDarr[i] = "false";   /* 체크되지않은 체크박스들은 false 를 넣어줍니다. */
                }
             $.ajax({
                   type : "POST",
                   url : "/reservation/seatreservation/"+chkboxIDarr, /* 체크된 ID값의 요소와 체크되지않은 요소는 false 가 담겨져있는 배열을 컨트롤러로 넘겨줍니다  */
               });  
              }                                     
       });
    });
    </script> -->
        
    <!-- 라디오버튼클릭시 발생 이벤트 -->
   <script>
   $(function(){
        $('input[type="radio"]').click(function(){  /* 선택자를 이용해서 속성이'input[type="radio"] 인 것들을 클릭하면 함수를 실행한다. */
          if ($(this).is(':checked'))
          {
               var sno = $(this).val();   /* sno 변수를 선언 후 , radio 버튼 별 value를  담아줍니다. */
               $.ajax({  /* ajax를 이용하여 컨트롤러 호출하기 */                  
                     type : "GET",
                     url : "/sysview/status/"+sno,
                    
                     success: function(data){   // data 변수에 JSON 객체에  seat 예약현황을 나타내는 키 값의 문자열이 담겨져 있습니다.
                            $('span').remove(); // 좌석을 누를때마다 기존에 있던  <span> tag 들은 사라지고 새로운 좌석의 <span> tag 들이 나타납니다.      
                            
                            var i = 2;
                              var j = 1;
                                 do{                                    
                                    if(data.substr(i,1) == "0") 
                                       {    
                                           $(".time"+j).after("<span class='label label-success'>예약가능</span>");   
                                           $("#"+j).prop("disabled",false);
                                       }
                                         else
                                        {
                                           $(".time"+j).after("<span class='label label-danger'>예약불가</span>");
                                           $("#"+j).prop("disabled",true);
                                        }
                                             i+=4;
                                             j++;                                   
                                    }while(j<14 && i < 51)  
                               } 
                          });
                   }
                 });
               });   
      </script>
   
   
    <div class="here">
     <form class="box" action="/reservation/seatreservation" method="post">
    
     <!-- 이용 좌석 선택 -->
       <section class="container" align="center" style="margin-top:80px">
         <div class ="row"> 
             <div class = "well"><h2>이용 좌석 선택</h2></div>
          <div class = "col-md-3">
           <label class="radio-inline">
            <input type="radio" name="seat" value="1" id="seat" >1
          </label>
          </div>          
          <div class = "col-md-3">
           <label class="radio-inline">
            <input type="radio" name="seat" value="2" >2
          </label>
          </div> 
          <div class = "col-md-2">
           <label class="radio-inline">
            <input type="radio" name="seat" value="3">3
          </label>
          </div> 
          <div class = "col-md-2">
           <label class="radio-inline">
            <input type="radio" name="seat" value="4">4
          </label>
          </div> 
          <div class = "col-md-2">
           <label class="radio-inline">
            <input type="radio" name="seat" value="5">5
          </label>
          </div> 
          <div class = "col-md-2">
           <label class="radio-inline">
            <input type="radio" name="seat" value="6">6
          </label>
          </div> 
          <div class = "col-md-2">
           <label class="radio-inline">
            <input type="radio" name="seat" value="7">7
          </label>
          </div> 
          <div class = "col-md-2">
           <label class="radio-inline">
            <input type="radio" name="seat" value="8">8
          </label>
          </div> 
          <div class = "col-md-2">
           <label class="radio-inline">
            <input type="radio" name="seat" value="9">9
          </label>
          </div> 
          <div class = "col-md-2">
           <label class="radio-inline">
            <input type="radio" name="seat" value="10">10
          </label>
          </div> 
        </div>     
    </section>
    
    
         <!-- 시간예약 -->
        <section class="container" align="center" style="margin-top:20px">
       <div class="well"><h2>시간 예약<small>(좌석)</small></h2></div>    
     <div class ="row">      
       <div class="checkbox col-md-2">
         <label class="time1"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="09:00:00" id="0">09:00 ~ 10:00</label>        
       </div>
       <div class="checkbox col-md-2">
         <label class="time2"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="10:00:00" id="1">10:00 ~ 11:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time3"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="11:00:00" id="2">11:00 ~ 12:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time4"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="12:00:00" id="3">12:00 ~ 13:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time5"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="13:00:00" id="4">13:00 ~ 14:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time6"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="14:00:00" id="5">14:00 ~ 15:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time7"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="15:00:00" id="6">15:00 ~ 16:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time8"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="16:00:00" id="7">16:00 ~ 17:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time9"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="17:00:00" id="8">17:00 ~ 18:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time10"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="18:00:00" id="9">18:00 ~ 19:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time11"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="19:00:00" id="10">19:00 ~ 20:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time12"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="20:00:00" id="11">20:00 ~ 21:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time13"><input type="checkbox" name="reservateTime" onClick="count_ck(this);"  value="21:00:00" id="12">21:00 ~ 22:00</label>
       </div>
      </div>
    </section>
    
       <div  align="center">
             <input type="submit" name="reservation" value="예약하기">
        </div>
       
    </form>
    </div>
                 
   <!-- The Carousel Plugin -->
   <div class="container">
     <h2>100호실 전경</h2>  
     <div id="myCarousel" class="carousel slide" data-ride="carousel">
       <!-- Indicators -->
       <ol class="carousel-indicators">
         <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
         <li data-target="#myCarousel" data-slide-to="1"></li>
         <li data-target="#myCarousel" data-slide-to="2"></li>
       </ol>
   
       <!-- Wrapper for slides -->
       <div class="carousel-inner">
         <div class="item active">
           <img src="1.jpg" alt="Los Angeles" style="width:100%;">
         </div>
   
         <div class="item">
           <img src="2.jpg" alt="Chicago" style="width:100%;">
         </div>
       
         <div class="item">
           <img src="3.jpg" alt="New york" style="width:100%;">
         </div>
       </div>
   
       <!-- Left and right controls -->
       <a class="left carousel-control" href="#myCarousel" data-slide="prev">
         <span class="glyphicon glyphicon-chevron-left"></span>
         <span class="sr-only">Previous</span>
       </a>
       <a class="right carousel-control" href="#myCarousel" data-slide="next">
         <span class="glyphicon glyphicon-chevron-right"></span>
         <span class="sr-only">Next</span>
       </a>
     </div>
   </div>
  
     <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>   
  
</body>
</html>