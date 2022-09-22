package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO{
	
	// ojdbc : Connection, Statement, ResultSet
	// 각각의 객체가 하는 것 :
	// Connection : DB와 연결 ( 데이터베이스 서버에 연결 )
	// Statement : 쿼리 실행 ( ↑ 연결로를 통해 디비에 접속해서 쿼리를 실행하고 결과를 가져옴)
	// Result : 결과 객체( select문을 실행했다면 반드시 결과가 나오게 되어있음 행==0)
	
	// Connection 객체를 초기화하고 연결이 정상적으로 되어있는지 확인.
	public void connTest(String id, String pw) {
		
		// 드라이버 매니저 <- 동적 클래스 로딩 ( class.forname() OracleDriver )
		//String url = "jdbc:oracle:thin@ip(host):port:sid";
		String url = "jdbc:oracle:thin:@121.147.215.32:1521:xe";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 매니저가 커넥션메소드를 사용할때 필요한 클래스를 동적을 로딩.
			Connection conn = DriverManager.getConnection(url, user, password);
			// is <- boolean return 무조건 ( 또는 boolean 변수 )
			if(conn.isClosed()) {
				System.out.println("연결 안됨");
			}else {
				System.out.println("연결됨");
				// TBL_JAVA_USER 테이블에 아이디가 admin이고 비밀번호가 123 인 경우
				// (== TBL_JAVA_SER 테이블에 실제 정보가 있는 경우 )
				// 로그인이 되었습니다 <= 콘솔에 출력
				// 그게 아니라면 <= 아이디 또는 비밀번호 확인이 콘솔에 출력
				//전송로(연결)을 통해서 쿼리가 전송이되고 쿼리실행을하고 그 결과를 받아옴.
				String sql = " SELECT * "
						+ " FROM TBL_JAVA_USER "
						+ " WHERE id = ? and  pw = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pw); // pw는 아직 메소드 파라메터로 받아오지 않음.
				ResultSet rs = ps.executeQuery(); //java에서 보내준 쿼리를 실행하고 그 결과를 오라클로부터 받아옴
				if(rs.next()) {
					System.out.println("ResultSet은 행이 적어도 1개 이상");
					System.out.println(rs.getString(1));
				}else {
					System.out.println("ResultSet은 행 머리글만 가져옴 ( 데이터 없음) ");
				}//안 if
			}//밖 if
			conn.close();
			System.out.println("닫음");
			
			if(conn.isClosed()) {
				System.out.println("연결 안됨");
			}else {
				System.out.println("연결됨");
			}
		} catch (Exception e) {
			//동적 클래스 로딩 오류
			e.printStackTrace();
		}
		
	}//connTest
}//class












