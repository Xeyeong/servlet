package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex_return")
public class Ex_return extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex_return() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	}

}
