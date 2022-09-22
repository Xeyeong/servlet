package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.TestMybatisDTO;

public class TestMybatisDAO {
	//SqlSessionFactory <= ※Connection 객체와 하는 기능이 유사함 디비종료를 자동으로 해줌※
	//SqlSession ↑ 통신이 정상적으로 열리면 Statement + Result 기능을 합쳐놓은 실제 작업 객체
	private static SqlSession sql;
	static {
		String resource = "Mybatis/Config.xml"; //설정 파일 경로 Mybatis.txt -> 1-1
		InputStream inputStream;
		try {
			
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =
					new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(true);
			
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void test() {
		int dualInt = sql.selectOne("test.selectTest"); // namespace.id
		System.out.println(dualInt);
		System.out.println(sql.selectOne("test.selectName")+"");
	}
	//void는 절대로 어떤값을 리턴 할수 없음
	// E<- List한건을 구성하는 객체 ( String ~~ DTO ) 
	public List<TestMybatisDTO> testList() {
		return sql.selectList("test.selectList");
	}
}




