package Controller;

public class FirstPhone {
   
   String color, model, state;
   boolean stateCall;
      
   
   public FirstPhone(String color, String model, String state, boolean stateCall) {
      super();
      this.color = color;
      this.model = model;
      this.state = state;
      this.stateCall = stateCall;
      System.out.println("1세대 폰 (색상 : "+ color+", 모델명 : " + model + " , 상태 : "+state+")");
   }

   public void powerSupply(String state) {

      if(state.equals("종료")) {
         System.out.println(model + "전원이 켜졌습니다.");
         
         setState("켜짐");
      }else if(state.equals("켜짐")) {
         System.out.println(model + "전원이 꺼졌습니다.");
         setState("종료");
      }
   }//powerSupply
   
   public void call(String state) {
      if(state.equals("켜짐")) {
         System.out.println("전화가 와서 전화를 받았습니다.");
         setStateCall(true);
      }else{
         System.out.println("전원이 꺼져있어 전화 받기가 불가 합니다.");
         setStateCall(false);
      }
   }
   
   public void voice(boolean callInfo) {
      if(callInfo) {
         System.out.println("나: 여보세요?");
         System.out.println("상대방:여보세요?");
         System.out.println("전화를 끊습니다.");
      }else if(!callInfo) {
         System.out.println("통화중이 상태가 아닙니다. 음성 전송 & 수신이 불가 합니다.");
      }
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public boolean isStateCall() {
      return stateCall;
   }

   public void setStateCall(boolean stateCall) {
      this.stateCall = stateCall;
   }
   
   
}