package Controller;


public class SuperPhone extends SecondPhone{

   
   boolean resInter;

   

   public SuperPhone(String color, String model, String state, boolean stateCall, String channelName, boolean re_dmb,
         boolean resInter) {
      super(color, model, state, stateCall, channelName, re_dmb);
      this.resInter = resInter;
   }

   void internet(String state) {
      if(state.equals("켜짐")) {
         System.out.println("인터넷을 실행합니다");
         resInter = true;
      }else {
         System.out.println("전원이 켜져 있지 않습니다");
         resInter = false;
      }
   }//internet()
   
   void webToon(String state, boolean resInter) {
      if(state.equals("켜짐") && resInter == true) {
         System.out.println("웹툰을 실행합니다");
         
      }else {
         System.out.println("인터넷이 켜져 있지 않습니다");
      
      }
   }//webToon()

   public boolean isResInter() {
      return resInter;
   }

   public void setResInter(boolean resInter) {
      this.resInter = resInter;
   }
   
   
   
}//class