package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.google.gson.Gson;


@WebServlet("/Ex07_GoData")
public class Ex07_GoData extends HttpServlet {
	private static final long serialVersionUID = 1L;
// 공공데이터 포털 <- 광주광역시 맛집 , ... 여러가지 공공의 데이터 (DataType = json, xml)
// json이 많이 사용되는 이유 : HttpServlet(Request) 요청을 할때 모든 정보들은 String 문자열
// 문자열을 키와 값으로 구분했을때 논리적인 구조를 가진 데이터타입이 json, xml
	
// url?serviceKey = 공공데이터포털에서 발급받은키&pageNo=
// Request객체를 이용해서 데이터를 요청하는 방식
// Gson( Google 에서 지원해주는 객체를 json으로 바꾸기 가장 쉬운 API, Lib )

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Request = 요청 , Response = 응답
		//URL에 ?뒤에 나오는 모든것들은 요청객체를 통해 오는 파라메터(form 태그안에있는 태그들)
		System.out.println(" Go Data ");
		//파라메터를 출력해보기 ( 현 : test라는 key로 1이라는 값(value)을 보내고있음)
		System.out.println(request.getParameter("test"));
		System.out.println(request.getParameter("myname"));
		// myname이라는 key로 나의 이니셜을 파라메터로 받고 출력해보기
		// 응답 : response(응답) 객체를 이용해서 바로 어떤값을 써주기(Html body)
		// 			=> Requset객체를 이용한 페이지 전환(다음 페이지로 응답을 넘김) Forward※
		response.setCharacterEncoding("UTF-8"); //한글 사용
		response.setContentType("test/html; utf-8"); //html형태의 웹 응답사용.
		ArrayList<GodataDTO> sList = new ArrayList<GodataDTO>();	// ArrayList를 초기화( 사용준비 )
		
		// ArrayList<Type> <=
		//GodataDTO dto = new GodataDTO(1, "name1", "content1");
		// add(GoDataDTO e) = dto or new GoDataDTO(1 ,"" ,"");
		//sList.add(dto);
		//sList.add(new GodataDTO(1, "name1", "content1"));
		//GodataDTO e = dto;
		GodataDTO e = new GodataDTO(1, "nam1", "conten1");
		System.out.println(e.getNo());	// 실제 데이터가 저장되어있는 필드
		System.out.println(e.getName());
		System.out.println(e.getContent());
		
		
		for(int i = 1; i <= 10; i++ ) {
			sList.add(new GodataDTO(i, "name" + i, "content" + i));
			System.out.println(sList.get(i-1).getNo() + sList.get(i-1).getName());
		}
		//json
		// [ ] <= list , array
		// { } <= Object, DTO 
		// [{no:1, name:2, "content3"}]
		// 손으로 바꾸는것은 어려워서 => lib Gson을 사용
		Gson gson = new Gson();
		gson.toJson(sList);
		System.out.println(gson.toJson(sList));
		
		System.out.println("리스트의 크기 " + sList.size());
		response.getWriter().println(gson.toJson(sList));
	
		
		
		//ArrayList로 GoDataDTO 10건 이상 저장해놓기.
		//ex) 1, name , content 1
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}//class
