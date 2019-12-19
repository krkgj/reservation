package org.zerock.dto;

public class ReservationDTO {

   private String[] reservateTime;
   private String seat;
   
   public String[] getReservateTime() {
      return reservateTime;
   }
   public void setReservateTime(String[] reservateTime) {
      this.reservateTime = reservateTime;
   }
   public String getSeat() {
      return seat;
   }
   public void setSeat(String seat) {
      this.seat = seat;
   }
}