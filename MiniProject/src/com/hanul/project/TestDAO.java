package com.hanul.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestDAO {
	
	private Connection conn;		//데이터베이스에 연결
	private PreparedStatement ps;  //전송객체
	private ResultSet rs;		   //결과객체
	
	//DB접속 메소드
	public Connection getConn() {
		try {
			String user = "hanul";
			String password = "0000";
			String url = "jdbc:oracle:thin:@121.147.215.32:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		return conn;
	}//getConn
	
	//DB종료 메소드
	public void dbclose() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dbClose Exception!!!");
		}//try
	}//dbclose
}//class
