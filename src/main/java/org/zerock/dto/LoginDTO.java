package org.zerock.dto;

public class LoginDTO {
	
	private String uname;
	private String unumber;
	private String[] reservateTime;
	private String seat;
	private boolean useCookie;
	
	
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String[] getreservateTime() {
		return reservateTime;
	}
	public void setreservateTime(String[] reservationtTime) {
		this.reservateTime = reservationtTime;
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
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [uname=" + uname + ", unumber=" + unumber + ", useCookie="
				+ useCookie + "]";
	}
	
}
