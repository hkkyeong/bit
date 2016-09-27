package winder.vo;

public class ScrapVO {
	private int sno, pno;
	private String url, stitle, sdate, id;
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
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ScrapVO [sno=" + sno + ", pno=" + pno + ", url=" + url + ", stitle=" + stitle + ", sdate=" + sdate
				+ ", id=" + id + "]";
	}
	
	
}
