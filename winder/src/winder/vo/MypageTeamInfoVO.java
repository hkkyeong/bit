package winder.vo;

import java.util.List;

public class MypageTeamInfoVO {
	
	String name,leader, timg;
	List<MembersVO> members;
	int tno;
	
	public String getTimg() {
		return timg;
	}
	
	public void setTimg(String timg) {
		this.timg = timg;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public List<MembersVO> getMembers() {
		return members;
	}
	public void setMembers(List<MembersVO> members) {
		this.members = members;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
