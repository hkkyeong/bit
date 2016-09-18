package winder.service;

import java.util.List;

import winder.vo.MemberVO;
import winder.vo.OutMemberVO;

public interface MemberService {
	public int insertMember(MemberVO member) throws RuntimeException;
	public int deleteMember(String id);
	public int updateMember(MemberVO member);
	public MemberVO selectMember(String id);
	public List<MemberVO> selectAllMember();
	public int chkMember(MemberVO member) throws RuntimeException;
	public int updatePassword(MemberVO member);
	
	//manager
	public int countMember() throws RuntimeException;
	public int todayJoin() throws RuntimeException;
	public int outMember(OutMemberVO outmember) throws RuntimeException;
	public List<OutMemberVO> outMemberList() throws RuntimeException;	
}
