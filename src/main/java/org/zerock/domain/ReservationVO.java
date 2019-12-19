package org.zerock.domain;

import java.util.Date;

public class ReservationVO {

   private String uname;
   private String unumber;
   private Date reserveStartTime;
   private Date reserveEndTime;
   private String seat;
   
   
   public Date getReserveStartTime() {
      return reserveStartTime;
   }
   public void setReserveStartTime(Date reserveStartTime) {
      this.reserveStartTime = reserveStartTime;
   }
   public Date getReserveEndTime() {
      return reserveEndTime;
   }
   public void setReserveEndTime(Date reserveEndTime) {
      this.reserveEndTime = reserveEndTime;
   }
   public String getUname() {
      return uname;
   }
   public void setUname(String uname) {
      this.uname = uname;
   }
   public String getUnumber() {
      return unumber;
   }
   public void setUnumber(String unumber) {
      this.unumber = unumber;
   }
   public String getSeat() {
      
      return seat;
   }
   public void setSeat(String seat) {
      this.seat = seat;
   }

}