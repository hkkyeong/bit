package winder.vo;

public class AbcVO {
	private String abc;
	private int abcno;

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}

	public int getAbcno() {
		return abcno;
	}

	public void setAbcno(int abcno) {
		this.abcno = abcno;
	}

	@Override
	public String toString() {
		return "AbcVO [abc=" + abc + ", abcno=" + abcno + "]";
	}
	

}
