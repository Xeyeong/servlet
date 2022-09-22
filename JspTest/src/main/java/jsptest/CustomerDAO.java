package jsptest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerDAO {
	private static SqlSession sql;
	static {
		String resource = "mybatis/Customer.xml";
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
	
	public List<CustomerDTO> aList() {
		return sql.selectList("customer.list");
	}
	
}
