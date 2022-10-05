package manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	//db
	private JdbcConnectionUtil util;
	
	public MemberDAO() {
		util = JdbcConnectionUtil.getInstance();
	}
	
	//C
	public int insertMember(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = util.getConnection();
			System.out.println("접속 성공!");
			
			StringBuffer query = new StringBuffer();
			query.append("insert into member(num, memberId, memberPw, nickName, regDate) values (member_seq.nextval, ?, ?, ?, sysdate)");
			
			System.out.println(query.toString());
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPw());
			pstmt.setString(3, vo.getNickName());
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 삽입되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) { 
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	//R
	public MemberVO selectMember(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO result = null;
		try {
			conn = util.getConnection();
			System.out.println("접속 성공!");
			pstmt = conn.prepareStatement("select * from member where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = new MemberVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
			);
				result.setRegdate(rs.getDate("REGDATE"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public List<MemberVO> selectMemberAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> result = new ArrayList<>();
		try {
			conn = util.getConnection();
			System.out.println("접속 성공!");
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
			);
				vo.setRegdate(rs.getDate("REGDATE"));
				result.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	//U
	public int updateMember(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = util.getConnection();
			System.out.println("접속 성공!");
			
			StringBuffer query = new StringBuffer();
			query.append("update member set memberPw = ?, nickName = ? where num = ?");
			
			System.out.println(query.toString());
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, vo.getMemberPw());
			pstmt.setString(2, vo.getNickName());
			pstmt.setInt(3, vo.getNum());
			
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	//D
	public int deleteMember(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = util.getConnection();
			System.out.println("접속 성공!");
			
			StringBuffer query = new StringBuffer();
			query.append("delete from member where NUM = ?");
			
			System.out.println(query.toString());
			
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 삭제되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
}
