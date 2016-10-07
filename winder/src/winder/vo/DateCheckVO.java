package winder.vo;

public class DateCheckVO {
	int tlno;
	String tldate;
	public int getTlno() {
		return tlno;
	}
	public void setTlno(int tlno) {
		this.tlno = tlno;
	}
	public String getTldate() {
		return tldate;
	}
	public void setTldate(String tldate) {
		this.tldate = tldate;
	}
	@Override
	public String toString() {
		return "DateCheckVO [tlno=" + tlno + ", tldate=" + tldate + "]";
	}
	
	

}
