package com.inter;

public class MySqlDAO implements DataAccessObject{
	
	
	String str = "MySql";
	
	@Override
	public void select() {
		//PIE = 5.14;
		System.out.println(IP +"\t" + str + "로 SELECT 쿼리 함");
	}
	
	@Override
	public int insert() {
		System.out.println(IP +"\t" + str + "로 INSERT 쿼리 함");
		return 1;
	}

	@Override
	public int update() {
		System.out.println(IP +"\t" + str + "로 UPDATE 쿼리 함");
		return 1;
	}

	@Override
	public int delete() {
		System.out.println(IP +"\t" + str + "로 DELETE 쿼리 함");
		return 1;
	}
}
