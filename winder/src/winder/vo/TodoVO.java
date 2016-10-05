package winder.vo;

public class TodoVO {

	int tdno, pno;
	String content, state, tddate, tdstart;
	
	public int getTdno() {
		return tdno;
	}
	public void setTdno(int tdno) {
		this.tdno = tdno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTddate() {
		return tddate;
	}
	public void setTddate(String tddate) {
		this.tddate = tddate;
	}
	public String getTdstart() {
		return tdstart;
	}
	public void setTdstart(String tdstart) {
		this.tdstart = tdstart;
	}
	@Override
	public String toString() {
		return "TodoVO [tdno=" + tdno + ", pno=" + pno + ", content=" + content + ", state=" + state + ", tddate="
				+ tddate + ", tdstart=" + tdstart + "]";
	}	
	
}
