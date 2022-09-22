package Controller;

import java.util.Scanner;

public class SecondPhone extends FirstPhone{
      
   String channelName;
   boolean re_dmb;

      


   public SecondPhone(String color, String model, String state, boolean stateCall, String channelName,
         boolean re_dmb) {
      super(color, model, state, stateCall);
      this.channelName = channelName;
      this.re_dmb = re_dmb;
   }


      //dmb
      public void dmb(String stateph, boolean Call) {
         if(stateph.equals("켜짐") && !stateCall) {
            System.out.println("DMB를 실행합니다.");
            setRe_dmb(true);
         }if(!stateCall){
            System.out.println("통화를 종료후 실행해주세요.");
            setRe_dmb(false);
         }else if(stateph.equals("꺼짐")){
            System.out.println("전원이 켜져 있지 않습니다");
            setRe_dmb(false);
         }
      }//dmb

      
//      //채널변경 & 끄기
//      public void channel(String stateph, String dmb, Scanner scanner) {
//         if(stateph.equals("켜짐") && dmb.equals("시청중")) {   
//            System.out.print("변경할 채널명을 입력하세요 : ");
//            int i = Integer.parseInt(scanner.nextLine());
//            System.out.println(" 입력하신 채널은 "+ i +" 입니다." );
//         }else if(dmb.equals("끄기")){
//            System.out.println("DMB를 종료합니다.");
//         }
//      }
      
      public void channel(String stateph, boolean dmb, Scanner scanner) {
         
         System.out.println(channelName);         
         if(stateph.equals("켜짐") && !dmb) {   
            System.out.print("변경할 채널명을 입력하세요 : ");
            
            int i = Integer.parseInt(scanner.nextLine());
            
            System.out.println(" 입력하신 채널은 "+ i +" 입니다." );
         }else if(!dmb){
            System.out.println("DMB를 종료합니다.");
         }
      }


      public String getChannelName() {
         return channelName;
      }


      public void setChannelName(String channelName) {
         this.channelName = channelName;
      }


      public boolean isRe_dmb() {
         return re_dmb;
      }


      public void setRe_dmb(boolean re_dmb) {
         this.re_dmb = re_dmb;
      }
      
      
}//class
