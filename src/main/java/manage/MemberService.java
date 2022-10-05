package manage;

import java.util.List;

public class MemberService {
	private MemberDAO memberDAO;
	
	public MemberService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	//등록하기
	public boolean regist(MemberVO vo) {
			int ret = memberDAO.insertMember(vo);
			if(ret == 1) {
				return true;
			}
		return false;
	}
	
	//조회하기
	public MemberVO read(int num) {
		return memberDAO.selectMember(num);
	}
	
	//전체조회
	public List<MemberVO> listAll(){
		return memberDAO.selectMemberAll();
	}
	
	//수정하기
	public boolean edit(MemberVO vo, String memberPwOld) {
		int result = -1;
		MemberVO searchMember = memberDAO.selectMember(vo.getNum());
		if(searchMember.getMemberPw().equals(memberPwOld)) {
			result = memberDAO.updateMember(vo);
		}
		return (result == 1) ? true : false;
	}
	
	//탈퇴
	public boolean remove(int num) {
		int ret = memberDAO.deleteMember(num);
		return (ret == 1) ? true : false;
	}
}
