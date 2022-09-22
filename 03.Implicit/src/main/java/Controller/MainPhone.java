package Controller;
import java.util.Scanner;

public class MainPhone {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String state;
      while(true) {
         System.out.println("1세대 폰 : F");
         System.out.println("2세대 폰 : S");
         System.out.println("3세대 폰 : T");
         
         System.out.print("메뉴를 입력하세요 : ");
         String menu = scan.nextLine();
         
         if(menu.equalsIgnoreCase("F")) {
            FirstPhone fp = new FirstPhone("검정", "CIH-1", "종료", false);
            
            while(true) {
               System.out.println("<<<FirstPhone Menu>>>");
               System.out.println("PowerSupply : P");
               System.out.println("Call : C");
               //System.out.println("Voice : V");
               System.out.print("기능을 선택하세요 : ");
               String subMenu = scan.nextLine();
               
               if(subMenu.equalsIgnoreCase("P")) {
                  fp.powerSupply(fp.getState());
                  continue;
               }else if(subMenu.equalsIgnoreCase("C")) {
                  fp.call(fp.getState());
                  fp.voice(fp.isStateCall());
                  break;
               //}else if(subMenu.equalsIgnoreCase("V")){
               
               }else {
                  System.out.println("잘못 입력하셨습니다");
                  continue;
               }//if
            }//while
            
         }else if(menu.equalsIgnoreCase("S")) {
            SecondPhone sp = new SecondPhone("검정", "JSY-2", "종료",false, "정보없음",false);
            System.out.println("1세대 기능을 점검합니다");
            sp.powerSupply("시작");
            sp.call("켜짐");
            sp.voice(true);
            
            System.out.println("SecondPhone Menu : ");
            System.out.println("DMB : D");
            System.out.println("CHANNEL : C");
            System.out.println("기능을 선택하세요 : ");
            String subMenu = scan.nextLine();
            if(subMenu.equalsIgnoreCase("D")) {
               sp.dmb(sp.getState(), sp.isStateCall());
               break;
            }else if(subMenu.equalsIgnoreCase("C")) {
               sp.channel(sp.getState(),sp.isRe_dmb(), scan);
               break;
            }else {
               System.out.println("잘못 입력하셨습니다");
               continue;
            }//if
            
            
         }else if(menu.equalsIgnoreCase("T")) {
            SuperPhone tp = new SuperPhone("검정", "JHN-3", "종료",false, "정보없음", false, false);
            System.out.println("1, 2세대 기능을 점검합니다");
            tp.dmb(tp.getState(), tp.isStateCall()); 
            tp.channel(tp.getState(),tp.isRe_dmb(), scan);
            
            while(true) {
               System.out.println("SuperPhone Menu : ");
               System.out.println("인터넷 : I");
               System.out.println("웹툰 : W");
               System.out.println("기능을 선택하세요 : ");
               String subMenu = scan.nextLine();
               if(subMenu.equalsIgnoreCase("I")) {
                  tp.internet("켜짐");
                  break;
               }else if(subMenu.equalsIgnoreCase("W")) {
                  tp.webToon("켜짐", true);
                  break;
               }else {
                  System.out.println("잘못 입력하셨습니다");
                  continue;
               }//if
            }
         }else {
            System.out.println("잘못 입력하셨습니다");
            continue;
         }//if
      }//while
   }//main
}//class


