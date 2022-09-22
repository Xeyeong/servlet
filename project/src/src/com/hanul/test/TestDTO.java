package com.hanul.test;

public class TestDTO {
	
	private int num;
	private String name;
	private String id;
	private String pw;
	private String email;
	private int tel;
	
	
	public TestDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public TestDTO(int num, String name, String id, String pw, String email, int tel) {
		super();
		this.num = num;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}
	
	
}//class
