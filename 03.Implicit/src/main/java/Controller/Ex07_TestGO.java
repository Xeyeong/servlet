package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

//WebServlet("") 맵핑부분이 다른 서블릿과 중복이 되면 톰켓에서 어떤 맵핑으로 서블릿 요청을
//받을건지 구분을 못하기때문에 오류가 발생함.

@WebServlet("/GoData")
public class Ex07_TestGO extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("ServiceKey"));
		System.out.println(request.getParameter("DataCount"));
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; utf-8");
		//URL에 어떤 데이터를 넣을지 모름
		if(request.getParameter("ServiceKey") == null ||
				!request.getParameter("ServiceKey").equals("HANUL302SERVICE")
				){
					response.getWriter().println("ServiceKey : 등록 안됨");
					return;
				}
		
		
		GodataDTO dto = new GodataDTO(1, "name", "content");
		int cnt = 0;
		try {
		cnt = Integer.parseInt(request.getParameter("DataCount"));
			if(cnt <= 0) {
				response.getWriter().println("데이터 요청 건수 0보다 큰수를 입력 ");
				return;
			}
		}
		catch(Exception e) {
			System.out.println("숫자값을 입력해주세요 : DataCount");
			return;
		}
		ArrayList<GodataDTO> list = new ArrayList<GodataDTO>();
		// count에 지금 빨간불이 들어옴 (에러, ==> 개발자에러, IDE에서 바로 판단함)
		// 이유 : try{}블럭킹 안에서 만든 변수는 안쪽에서만 사용가능(메모리{올림}내림)
		for (int i = 0; i < cnt; i++) { 
			list.add(new GodataDTO(i, "name" + i, "content" + i));
		}
		response.getWriter().println(new Gson().toJson(list));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}


