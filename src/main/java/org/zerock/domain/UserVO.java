package org.zerock.domain;

public class UserVO {

  private String uname;
  private String unumber;
  private int upoint;

 

  public String getUnumber() {
	return unumber;
  }

  public void setUnumber(String unumber) {
	this.unumber = unumber;
  }

  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

  public int getUpoint() {
    return upoint;
  }

  public void setUpoint(int upoint) {
    this.upoint = upoint;
  }

  @Override
  public String toString() {
    return "UserVO [uname=" + uname + ", unumber=" + unumber + ", upoint=" + upoint + "]";
  }
}
