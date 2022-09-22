package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inter.DataAccessObject;
import com.inter.MySqlDAO;
import com.inter.OracleDAO;

@WebServlet("/java03")
public class Ex06_Java extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 다형성
	// 관계가 있는 객체끼리는 타입이 같다 라고 생각을 해도 무방.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" java03 ");
		
		DataAccessObject obj1 = new MySqlDAO();
		DataAccessObject  obj2 = new MySqlDAO();
		// 인터페이스에 있는 구조를 만들어놨기때문에
		// DataAccessObject dao = new OracleDAO();
		
		//if( 현재 나의 데이터베이스 == Oracle )
		dbWork(new OracleDAO());
		dbWork(new MySqlDAO());
		// 인터페이스를 new로 생성해서 쓰면 안될까?
		// O : ( 익명의 메소드 )
		// 
		DataAccessObject obj3 = new DataAccessObject() {
			// 인터페이스를 new로 만들게 되면
			// 안쪽에 있는 메소드들을 전부 그때 구현을해줘야한다.
			// 복잡한 기능을 가진 인터페이스는 new 생성 x
			@Override
			public int update() {
				System.out.println("익명의 메소드를 이용 update");
				return 0;
			}
			
			@Override
			public void select() {
				System.out.println("익명의 메소드를 이용 select");
				
			}
			
			@Override
			public int insert() {
				System.out.println("익명의 메소드를 이용 insert");
				return 0;
			}
			
			@Override
			public int delete() {
				System.out.println("익명의 메소드를 이용 delete");
				return 0;
			}
		};
		dbWork(obj3);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" java03 ");
	}

	// 인터페이스(클래스의 설계도) : 자식 객체를 담을수있는 그릇
	// OracleDAO, MySqlDAO : 부모가 같다. == 내부 구조가 완전 일치하는 부분이 존재한다.
	// 인터페이스에는 자식 모두를 담을 수 있다.
	// (※다운 캐스팅이기 때문에 + 기능을 사용하는것은 불가능)
	public void dbWork(DataAccessObject dao) {
		// MySql, Oracle
		// 둘중에 하나의 디비를 이용해서 SELECT ~~ CRUD 
		dao.select();
		dao.update();
		dao.delete();
		dao.insert();
	}


}



