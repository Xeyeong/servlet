package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import oracle.jdbc.driver.OracleDriver;


@WebServlet("/jdbclogin") //URL 맵핑(mapping)
public class jdbclogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
	}
	// jdbc , java <-> database 연결용 ( mssql, mysql, mariadb, mongodb .. oracle! )
	// ojdbc : oralce사에서 제공함(==데이터베이스에 오라클사에서 제공해준 방식으로 접속하게끔만드려고)
	// lib(api) : maven 저장소 ( 파일jar ,dependency )
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("요청");
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pw"));
		MemberDAO dao = new MemberDAO();
		dao.connTest(req.getParameter("id"), req.getParameter("pw"));
		
	}//doPost
	
}//class
