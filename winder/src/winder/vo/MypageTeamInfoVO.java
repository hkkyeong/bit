package winder.vo;

import java.util.List;

public class MypageTeamInfoVO {
	

	String name,leader;
	List<MembersVO> members;
	int tno;
	
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
	
}
