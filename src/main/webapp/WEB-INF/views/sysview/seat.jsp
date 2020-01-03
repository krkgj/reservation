<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset-UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel = "shortcut icon" type = "image/png" href="/resources/image/Hansei.png"/>  <!-- favicon 추가 부분입니다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> <!-- jquery 사용을 위해 추가 -->
<title>100호실 예약 시스템</title>
</head>
<body>
   <%@ include file="./studentNavBar.jsp" %>
    <!-- 2개만 체크되게 하기 -->
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
    
    <!-- 라디오버튼클릭시 발생 이벤트 -->
<<<<<<< HEAD
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
		    	        	    $('span').remove(); // 누를때마다 기존에 있던  <span> tag 들은 사라지고 새로운 좌석의 <span> tag 들이 나타납니다.
		    	        	    
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

     <div>
     <form class="box" action="/reservation/seatreservation" method="post">
=======
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
                            $('span').remove(); // 누를때마다 기존에 있던  <span> tag 들은 사라지고 새로운 좌석의 <span> tag 들이 나타납니다.
                              if(data.substr(2,1) == "0")
                            {                                                             
                                $(".time1").after("<span class='label label-success'>예약가능</span>");   
                                $("#1").prop("disabled",false);
                            }
                              else
                             {
                                $(".time1").after("<span class='label label-danger'> 예약불가</span>");
                                $("#1").prop("disabled",true);
                             }
                              if(data.substr(6,1) == "0")
                             {                                 
                                 $(".time2").after("<span class='label label-success'> 예약가능</span>"); 
                                 $("#2").prop("disabled",false);
                             }
                               else
                              {
                                 $(".time2").after("<span class='label label-danger'> 예약불가</span>");     
                                 $("#2").prop("disabled",true);
                              }
                              if(data.substr(10,1) == "0")
                             {                                 
                                 $(".time3").after("<span class='label label-success'> 예약가능</span>");     
                                 $("#3").prop("disabled",false);
                             }
                               else
                              {
                                 $(".time3").after("<span class='label label-danger'>  예약불가</span>");
                                 $("#3").prop("disabled",true);
                              }
                              if(data.substr(14,1) == "0")
                              {                                 
                                  $(".time4").after("<span class='label label-success'> 예약가능</span>");   
                                  $("#4").prop("disabled",false);
                              }
                                else
                               {
                                  $(".time4").after("<span class='label label-danger'> 예약불가</span>");   
                                  $("#4").prop("disabled",true);
                               }
                              if(data.substr(18,1) == "0")
                              {                                 
                                  $(".time5").after("<span class='label label-success'> 예약가능</span>");
                                  $("#5").prop("disabled",false);
                              }
                                else
                               {
                                  $(".time5").after("<span class='label label-danger'> 예약불가</span>");  
                                  $("#5").prop("disabled",true);
                               }
                              if(data.substr(22,1) == "0")
                              {                                 
                                  $(".time6").after("<span class='label label-success'> 예약가능</span>");   
                                  $("#6").prop("disabled",false);
                              }
                                else
                               {
                                  $(".time6").after("<span class='label label-danger'> 예약불가</span>");
                                  $("#6").prop("disabled",true);
                               }
                              if(data.substr(26,1) == "0")
                              {                                 
                                  $(".time7").after("<span class='label label-success'> 예약가능</span>");   
                                  $("#7").prop("disabled",false);
                              }
                                else
                               {
                                  $(".time7").after("<span class='label label-danger'> 예약불가</span>");
                                  $("#7").prop("disabled",true);
                               }
                              if(data.substr(30,1) == "0")
                              {                                 
                                  $(".time8").after("<span class='label label-success'> 예약가능</span>");
                                  $("#8").prop("disabled",false);
                              }
                                else
                               {
                                  $(".time8").after("<span class='label label-danger'> 예약불가</span>");
                                  $("#8").prop("disabled",true);
                               }
                              if(data.substr(34,1) == "0")
                              {                                 
                                  $(".time9").after("<span class='label label-success'> 예약가능</span>");   
                                  $("#9").prop("disabled",false);
                              }
                                else
                               {
                                  $(".time9").after("<span class='label label-danger'> 예약불가</span>");
                                  $("#9").prop("disabled",true);
                               }
                              if(data.substr(38,1) == "0")
                              {                                 
                                  $(".time10").after("<span class='label label-success'> 예약가능</span>");   
                                  $("#10").prop("disabled",false);
                              }
                                else
                               {
                                  $(".time10").after("<span class='label label-danger'> 예약불가</span>");
                                  $("#10").prop("disabled",true);
                               }
                              if(data.substr(42,1) == "0")
                              {                                 
                                  $(".time11").after("<span class='label label-success'> 예약가능</span>");   
                                  $("#11").prop("disabled",false);
                              }
                                else
                               {
                                  $(".time11").after("<span class='label label-danger'> 예약불가</span>");
                                  $("#11").prop("disabled",true);
                               }
                              if(data.substr(46,1) == "0")
                              {                                 
                                  $(".time12").after("<span class='label label-success'> 예약가능</span>"); 
                                  $("#12").prop("disabled",false);
                              }
                                else
                               {
                                  $(".time12").after("<span class='label label-danger'> 예약불가</span>");
                                  $("#12").prop("disabled",true);
                               }
                              if(data.substr(50,1) == "0")
                              {                                 
                                  $(".time13").after("<span class='label label-success'> 예약가능</span>");  
                                  $("#13").prop("disabled",false);
                              }
                                else
                               {
                                  $(".time13").after("<span class='label label-danger'> 예약불가</span>");
                                  $("#13").prop("disabled",true);
                               }
                     }
                 });
          }
        });
      });   
      </script>
     
     <div>
     <form class="box" action="/reservation/reservation" method="post">
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc
    
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
         <label class="time1"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="09:00:00" id="1">09:00 ~ 10:00</label>        
       </div>
       <div class="checkbox col-md-2">
         <label class="time2"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="10:00:00" id="2">10:00 ~ 11:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time3"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="11:00:00" id="3">11:00 ~ 12:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time4"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="12:00:00" id="4">12:00 ~ 13:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time5"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="13:00:00" id="5">13:00 ~ 14:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time6"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="14:00:00" id="6">14:00 ~ 15:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time7"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="15:00:00" id="7">15:00 ~ 16:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time8"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="16:00:00" id="8">16:00 ~ 17:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time9"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="17:00:00" id="9">17:00 ~ 18:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time10"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="18:00:00" id="10">18:00 ~ 19:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time11"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="19:00:00" id="11">19:00 ~ 20:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time12"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="20:00:00" id="12">20:00 ~ 21:00</label>
       </div>
       <div class="checkbox col-md-2">
         <label class="time13"><input type="checkbox" name="reservateTime" onClick="count_ck(this);" value="21:00:00" id="13">21:00 ~ 22:00</label>
       </div>
      </div>
    </section>
    
<<<<<<< HEAD
    	<div  align="center">
             <input type="submit" name="reservation" value="예약하기">
     	</div>
       
    </form>
    </div>
    		    	
=======
       <div  align="center">
             <input type="submit" name="reservation" value="예약하기">
        </div>
       
    </form>
    </div>
                 
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc
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
  
<<<<<<< HEAD
  	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>	
=======
     <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>   
>>>>>>> c2b6e68700561b4d708416b45daaee4308b311fc
  
</body>
</html>