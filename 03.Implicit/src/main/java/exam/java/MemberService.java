package exam.java;

class MemberService {
	public boolean login(String userId,String userPw){
		
		
		if(userId.equals("hong") && userPw.equals("12345")) {
			
			return true; 
		}
		return false;
	}
/*
	public boolean logout(String userId, String userPw) {
		if(userId.equals("hong") != userPw.equals("12345")) {
		}
		return false;
	}*/
}
