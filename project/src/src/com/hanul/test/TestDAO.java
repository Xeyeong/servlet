package com.hanul.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hanul.test.TestDTO;

public class TestDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
		//DB접속 메소드
		public Connection getConn() {
			try {
				String user = "hanul";
				String password = "0000";
				String url = "jdbc:oracle:thin:@121.147.215.32:1521:XE";
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();	//예외 상세 출력
				System.out.println("getConn() Exception");
			}
			return conn;
		}//getConn()
		
		//DB접속 종료 메소드
		public void dbClose() {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("dbClose Exception");
			}
		}//dbClose()
		
	//아이디 중복 체크
	public boolean checkId(String id) {
		conn = getConn();
		String sql = "select * from MINI_PROJECT_B where id = ?";
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);	
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
			}else {
				result = false;
			}//if
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("checkId Exception");
		} finally {
			dbClose();
		}
		return result;
	}//checkId()
	
	//num 부여를 위한 메소드
	public boolean checkNum(int i) {
		conn = getConn();
		String sql = "select * from MINI_PROJECT_B where num = ?";
		boolean result = false;
		try {
			ps = conn.prepareStatement(sql);	
			ps.setInt(1, i);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = false;		//db에 num이 있으면 false값 반환하여 그 (db의 num과 같은) 수를 부여하는 코드를 실행하지 않게
			}else {
				result = true;
			}//if
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("checkId Exception");
		} finally {
			dbClose();
		}
		return result;
	}//checkNum()
	
	
	//가입 정보를 받아 DB에 업로드
	public int insertMember(TestDTO dto) {
		conn = getConn();		//DB 접속
		String sql = "insert into MINI_PROJECT_B (num, name, id, pw, email, tel) ";		
		sql += "values(?, ?, ?, ?, ?, ?)";
		int succ = 0;			//최종결과가 저장될 변수
		try {
			ps = conn.prepareStatement(sql);	//SQL 문장 전송
			ps.setInt(1, dto.getNum());			//매개변수 값을 세팅
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getId());
			ps.setString(4, dto.getPw());
			ps.setString(5, dto.getEmail());
			ps.setInt(6, dto.getTel());
			succ = ps.executeUpdate();			//SQL 문장 실행
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertInput() Exception");
		}finally {
			dbClose();
		}
		return succ;
	}//insertMember()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 //로그인 아이디 : select
    public TestDTO checkLogin(String id, String pw) {
       conn = getConn();   //DB접속
       String sql = "select * from MINI_PROJECT_B where id = ? AND pw = ?";   //SQL 문장 작성
       TestDTO dto = null;
       try {
          ps = conn.prepareStatement(sql);   //SQL 문장 전송
          ps.setString(1, id);//매개변수 값을 세팅
          ps.setString(2, pw);//매개변수 값을 세팅
          rs = ps.executeQuery();   //문장을 실행 후 결과객체
          if(rs.next()) {      //검색결과가 있다.
        	  dto = new TestDTO();
             dto.setNum(rs.getInt("num"));
             dto.setName(rs.getString("name"));
             dto.setId(rs.getString("id"));
             dto.setPw(rs.getString("pw"));
             dto.setEmail(rs.getString("email"));
             dto.setTel(rs.getInt("tel"));
             
             
          } 
       } catch (Exception e) {
          e.printStackTrace();
          System.err.println("checkNum() Exception!!!");
       } finally {
          dbClose();
       }
       return dto;
    }//checkLogin()
 
 //비밀번호 확인 : select
    public boolean checkPw(String pw) {
       conn = getConn();   //DB접속
       String sql = "select * from member where pw = ?";   //SQL 문장 작성
       boolean result = false;   //최종결과
       try {
          ps = conn.prepareStatement(sql);   //SQL 문장 전송
          ps.setString(1, pw);
          rs = ps.executeQuery();   //문장을 실행 후 결과객체
          if(rs.next()) {      //검색결과가 있다.
             result = true;
          } else {         //검색결과가 없다.
             result = false;
          }
       } catch (Exception e) {
          e.printStackTrace();
          System.err.println("checkNum() Exception!!!");
       } finally {
          dbClose();
       }
       return result;
    }//checkNum()

 //수정
 public int updateMember(TestDTO dto) {
    conn = getConn();
    String sql = "update member set name = ?, id = ?, pw = ?, email = ?, tel = ? where num = ?";      
    int succ = 0;
    try {
       ps = conn.prepareStatement(sql);
       ps.setString(1, dto.getName());
       ps.setString(2, dto.getId());
       ps.setString(3, dto.getPw());
       ps.setString(4, dto.getEmail());
       ps.setInt(5, dto.getTel());
       ps.setInt(6, dto.getNum());
       succ = ps.executeUpdate();
    } catch (Exception e) {
       e.printStackTrace();
       System.out.println("updateMember() Eception!!!");
    } finally {
       dbClose();
    }
    return succ;
 }//updateMember
 
 //회원정보 삭제
    public int deleteMember(String name) {
       conn = getConn();   //DB연결(접속)
       String sql = "delete from member where num = ?";   //SQL 문장 작성
       int succ = 0;   //최종결과가 저장될 변수를 초기화
       try {
          ps = conn.prepareStatement(sql);   //SQL 문장 전송
          ps.setString(1, name);   //매개변수 값을 세팅
          succ = ps.executeUpdate();   //SQL 문장 동작(실행)
       } catch (Exception e) {
          e.printStackTrace();
          System.out.println("deleteMember() Exception!!");
       } finally {
          dbClose();   //DB접속 해제
       }
       return succ;
    }//deleteMember()
}//class
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//회원 탈퇴
//	public int deleteMember(String id) {
//		conn = getConn();	//DB 접속(연결)
//		String sql = "delete from MINI_PROJECT_B where id = ?";	//SQL 문장 작성
//		int succ = 0;		//최종결과가 저장될 변수를 초기화
//		try {
//			ps = conn.prepareStatement(sql);	//SQL 문장 전송
//			ps.setString(1, id);		//매개변수 값을 세팅
//			succ = ps.executeUpdate();		//SQL 문장 실행
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("deleteMember() Exception");
//		}finally {
//			dbClose();
//		}
//		return succ;
//	}//deleteMember()
//	
//	//수정된 회원정보를 DB에 업데이트
//	public int updateMember(TestDTO dto) {
//		conn = getConn();
//		String sql = "update MINI_PROJECT_B set id = ?, pw = ?, name = ? email = ?, tel = ? where id = ?";
//		int succ = 0;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, dto.getId());
//			ps.setString(2, dto.getPw());
//			ps.setString(3, dto.getName());
//			succ = ps.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("updateMember() Exception");
//		}finally {
//			dbClose();
//		}
//		return succ;
//	}//updateMember()

	
	
	
	
	

	
