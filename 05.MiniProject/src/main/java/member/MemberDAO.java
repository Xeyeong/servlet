package member;

import java.io.Reader;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	public static SqlSession sql;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Mybatis/Config.xml");
			SqlSessionFactory factory 
				= new SqlSessionFactoryBuilder().build(reader);
			sql = factory.openSession(true);			
		}catch(Exception e) {
		}
	}
	//CRUD(Create, Read, Update, Delete)
	//회원가입시 회원정보신규저장
	public int member_join(MemberDTO dto) {
		return sql.insert("member.join", dto);
	}
	
	//로그인시 회원정보 조회
	public MemberDTO member_login(String id, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		return sql.selectOne("member.login", map);
	}
	
	//내정보보기 조회
	public MemberDTO member_myInfo(String id) {
		return null;
	}
	
	//아이디 중복확인(아이디) 조회
	public int member_id_check(String id) {
		return sql.selectOne("member.id_check", id);
	}
	
	//내정보변경
	public int member_update(MemberDTO dto) {
		return sql.update("member.update", dto);
	}
	
	//회원탈퇴
	public int member_delete(String id) {
		return 0;
	}
	
	
}
