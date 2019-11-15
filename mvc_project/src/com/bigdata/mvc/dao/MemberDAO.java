package com.bigdata.mvc.dao;

import java.sql.*;
import java.util.*;

import com.bigdata.mvc.vo.MemberVO;


public class MemberDAO {

	public Connection getConnection() {
		Connection conn = null; // DB에 접속하기 위한 connection 객체
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "bigdata";
		String pwd = "bigdata";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			
		} catch (ClassNotFoundException e) {
			System.out.println("driver load fail");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("db connection fail");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	public List<MemberVO> selectAll() {
		Connection conn = null; //DB 연결
		Statement stmt = null;  //sql 등록, 실행
		ResultSet rs = null; 	//DB 결과값 담아옴
		List<MemberVO> mlist = null;   	//ResultSet에서 나온 값을 리스트에 담아서 리턴
		
		try {
			conn = getConnection(); //DB 연결
			stmt = conn.createStatement(); //sql 담을 준비완료
			String sql = "select * from member"; //sql 생성
			rs = stmt.executeQuery(sql); //sql 실행
			mlist = new ArrayList<MemberVO>(); //rs -> arraylist
			
			while(rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("pwd"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddr(rs.getString("addr"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setJoinDt(rs.getDate("joinDt"));
				mlist.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mlist;
	}
	
	
	public MemberVO selectOne(String id) {
		Connection conn = null; //DB 연결
		Statement stmt = null;  //sql 등록, 실행
		ResultSet rs = null; 	//DB 결과값 담아옴
		MemberVO vo = null;   	//ResultSet에서 나온 값을 리스트에 담아서 리턴
		
		try {
			conn = getConnection(); //DB 연결
			stmt = conn.createStatement(); //sql 담을 준비완료
			String sql = "select * from member where id ='"+id+"'"; //sql 생성
			rs = stmt.executeQuery(sql); //sql 실행
			vo = new MemberVO(); //rs -> arraylist
			
			while(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddr(rs.getString("addr"));
				vo.setGender(rs.getString("gender"));
				vo.setAge(rs.getInt("age"));
				vo.setJoinDt(rs.getDate("joinDt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	
	public int inserMember(MemberVO mvo) {
		Connection conn = null; //DB 연결
		PreparedStatement pstmt = null;  //sql 등록, 실행
		ResultSet rs = null; 	//DB 결과값 담아옴
		int result = 0;   	//ResultSet에서 나온 값을 리스트에 담아서 리턴
		
		try {
			conn = getConnection(); //DB 연결
//			ID, PWD, EMAIL, PHONE, ADDR, GENDER, AGE, JOINDT
			String sql = "insert into member (ID, PWD, EMAIL, PHONE, ADDR, GENDER, AGE, JOINDT)"
					+ " values (?,?,?,?,?,?,?,sysdate)"; //sql 생성
			pstmt = conn.prepareStatement(sql); //sql 담을 준비완료
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getEmail());
			pstmt.setString(4, mvo.getPhone());
			pstmt.setString(5, mvo.getAddr());
			pstmt.setString(6, mvo.getGender());
			pstmt.setInt(7, mvo.getAge());
			
			result = pstmt.executeUpdate(); //sql 실행
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMember(MemberVO mvo) {
		Connection conn = null; //DB 연결
		PreparedStatement pstmt = null;  //sql 등록, 실행
		ResultSet rs = null; 	//DB 결과값 담아옴
		int result = 0;   	//ResultSet에서 나온 값을 리스트에 담아서 리턴
		
		try {
			conn = getConnection(); //DB 연결
//			ID, PWD, EMAIL, PHONE, ADDR, GENDER, AGE, JOINDT
			String sql = "update member "
					+ "set PWD=?, EMAIL=?, PHONE=?, ADDR=?"
					+ "where id=?"; //sql 생성
			pstmt = conn.prepareStatement(sql); //sql 담을 준비완료
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getEmail());
			pstmt.setString(3, mvo.getPhone());
			pstmt.setString(4, mvo.getAddr());
			pstmt.setString(5, mvo.getId());
			
			result = pstmt.executeUpdate(); //sql 실행
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteMember(String id) {
		Connection conn = null; //DB 연결
		PreparedStatement pstmt = null;  //sql 등록, 실행
		ResultSet rs = null; 	//DB 결과값 담아옴
		int result = 0;   	//ResultSet에서 나온 값을 리스트에 담아서 리턴
		
		try {
			conn = getConnection(); //DB 연결
//			ID, PWD, EMAIL, PHONE, ADDR, GENDER, AGE, JOINDT
			String sql = "delete from member where id =?"; //sql 생성
			pstmt = conn.prepareStatement(sql); //sql 담을 준비완료
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate(); //sql 실행
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		MemberDAO jdbc = new MemberDAO();
		
		List<MemberVO> mlist = jdbc.selectAll();
		
		for(int i=0; i < mlist.size() ; i++) {
			System.out.print(mlist.get(i).getId()+" ");
			System.out.print(mlist.get(i).getPwd()+" ");
			System.out.print(mlist.get(i).getEmail()+" ");
			System.out.print(mlist.get(i).getPhone()+" ");
			System.out.print(mlist.get(i).getAddr()+" ");
			System.out.print(mlist.get(i).getGender()+" ");
			System.out.print(mlist.get(i).getAge()+"\n");
		}
		
		
	}
	
	
	
	
	
	
	
}
