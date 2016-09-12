package winder.vo;

public class ScrapVO {

	int sno, pno;
	String url,id;
	String name; //프로젝트의 이믈
	
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	@Override
	public String toString() {
		return "ScrapVO [sno=" + sno + ", pno=" + pno + ", url=" + url + ", id=" + id + ", pname="+name+"]";
	}
	
	
	 
}
