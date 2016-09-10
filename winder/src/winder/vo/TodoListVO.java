package winder.vo;

public class TodoListVO {

	int tlno, tdno;
	String content, state, id, tldate;
	
	public int getTlno() {
		return tlno;
	}
	public void setTlno(int tlno) {
		this.tlno = tlno;
	}
	public int getTdno() {
		return tdno;
	}
	public void setTdno(int tdno) {
		this.tdno = tdno;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTldate() {
		return tldate;
	}
	public void setTldate(String tldate) {
		this.tldate = tldate;
	}
	
	@Override
	public String toString() {
		return "TodoListVO [tlno=" + tlno + ", tdno=" + tdno + ", content=" + content + ", state=" + state + ", id="
				+ id + ", tldate=" + tldate + "]";
	}
}
