package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestMybatisDAO;
import dto.TestMybatisDTO;

//3. 지금 맵핑 방식 새로운 방식, 어떤 문자열.tab으로 끝나면 모든 요청은
// 해당하는 컨트롤러가 처리하게 된다. (맵핑방식)
// ※ 모든 맵핑은 특정 문자열로 끝나는 맵핑으로 받는 형식으로 바꾸면 슬러시(/)는 반드시 빼줘야함.
// /*.tab(x),*.tab(o) ※

@WebServlet("*.tab")
public class TableController extends HttpServlet {

	static {// 항상 클래스의 어떤 코드가 실행되기전에 제일 처음 실행되는 블럭을 만듬
			//싱글톤	https://mybatis.org/mybatis-3/getting-started.html#
		System.out.println("먼저 실행 됨");
	}
	
	
	
	private Connection conn;		//데이터베이스에 연결
	private PreparedStatement ps;  //전송객체
	private ResultSet rs;		   //결과객체
	
	public Connection getConn() {
	
	try {
		String user = "hanul";
		String password = "0000";
		String url = "jdbc:oracle:thin:@121.147.215.32:XE";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, password);
	} catch (Exception e) {
		e.printStackTrace();
	}//try
	return conn;
}
	
//	public void dbclose() {
//		try {
//			if(rs != null) rs.close();
//			if(ps != null) ps.close();
//			if(conn != null) conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("dbClose Exception!!!");
//		}//try
//	}//dbclose
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		memberInput input = new MemberInput(scanner);
//		System.out.print("메뉴를 입력하세요 : ");
//		String menu = scanner.nextLine();
//		if(menu.equalsIgnoreCase("S")) {
//		}
//	}
	
		
	// 기존 ( doGet, doPost를 나눠두고 요청방식에 따라서 각각의 메소드가 처리하게 함)
	// 지금 ( service 두개의 방식을 모두 사용가능한 메소드를 오버라이드하고 사용해보기)
	// 1. Servlet추가후 내용 다 지움(Class안에 멤버 0)
	// 2. service라는 메소드를 부모 클래스로 부터 상속받아 사용.
	
	// Web에서 데이터를 유지할 규칙을 가진 객체
	// Session : 서버가 리스타트 되기 전까지는 계속해서 유지 (메모리) <- 로그인 정보
	// Request : 요청을 처리할 곳 까지 ( 1번 ) 메모리 <- 뉴스 기사 (게시판 글 클릭)
	// Forward라는 기능을 통해서 요청을 했을때 (setAttribute, getAttribute)
	// 그게 아니고 -> get, post(getParameter)
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println(req.getMethod()); //분기처리가 가능
		System.out.println("여기는 Service");
		System.out.println(req.getParameter("name")); //Forward가 아니라 url을 통한 GET
		// 조회, 수정, 삭제, 추가 등으로 기능을 분리
		System.out.println(req.getServletPath());
		// ex /join.tab ==> 회원가입 페이지로 이동.
		// ex /update.tab ==> 회원정보 수정 페이지 이동 또는 수정 로직 처리. 등등
		
		// TabController를 통해서만 작업이 되어야함.
		// 과제 : JDBC를 이용해서
		// 테이블 아무거나 하나를 전체 조회 해오기 (hanul 스키마 사용)※
		// 출력(콘솔)
		// 데이터 한건을 수정하기
		
		TestMybatisDAO dao = new TestMybatisDAO();
		
		dao.test();
		dao.testList();	 //Controller에 List를 가져와보기.
		List<TestMybatisDTO> list = dao.testList(); //Controller에 List를 가져와보기
		//Service메소드 안에서 List를 가져와서 size출력 해보기
		//페이지 전환 방식(요청을 받았을때 바로 처리가 아니라 View쪽으로 처리를 남김)
		//Forward
		RequestDispatcher rd = req.getRequestDispatcher("test/list.jsp"); // JSP경로
		req.setAttribute("list", list); //JSP에 보내줄 데이터를 넣어둠.
		req.setAttribute("data", "JSY");
		rd.forward(req, res); //페이지 요청 실행 ※
		
		System.out.println("리스트의 사이즈 : " + list.size());
	}
}