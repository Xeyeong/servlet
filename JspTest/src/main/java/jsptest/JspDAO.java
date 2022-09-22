package jsptest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class JspDAO {
	private static SqlSession sql;
	static {
		String resource = "mybatis/emp-list.xml"; //설정 파일 경로 Mybatis.txt -> 1-1
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
	
	public List<JspDTO> aList() {
		return sql.selectList("emp.list");
	}
}
