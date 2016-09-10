package winder.vo;

public class ProjectVO {

	int pno, tno;
	String name, pdate, content, exdate;
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExdate() {
		return exdate;
	}
	public void setExdate(String exdate) {
		this.exdate = exdate;
	}
	@Override
	public String toString() {
		return "ProjectVO [pno=" + pno + ", tno=" + tno + ", name=" + name + ", pdate=" + pdate + "]";
	}
}
