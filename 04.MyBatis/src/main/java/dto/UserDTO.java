package dto;

public class UserDTO {
	private int user_tbl;
	private String id, name, phone, addr;
	//mybatis 비어있는 생성자가 반드시 필요함
	//생성자를 별도로 안만드는 경우 DTO => VO ( Value Object )
	public int getUser_tbl() {
		return user_tbl;
	}
	public void setUser_tbl(int user_tbl) {
		this.user_tbl = user_tbl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	// G & S
	
	
}
