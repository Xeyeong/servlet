package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.UserDTO;

public class UserDAO {
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
	
	// sql.selectList <- return Type List<T>
	public List<UserDTO> getList() {	//mapper파일의 namespace.tagId
		return sql.selectList("user.list");
		
	}
}
