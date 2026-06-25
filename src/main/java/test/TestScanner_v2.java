/**
 * 
 */
package test;

import java.util.Scanner;

/**
 * 
 */
public class TestScanner_v2 {
 public static  void main (String[]args)  {
	 Scanner scanner = new Scanner(System.in);
	 
	 MySQLMix_v2 mySQLMix = new MySQLMix_v2();
	 
     System.out.println("====== CRUDサンプル ======");
     System.out.println("1: CREATE");
     System.out.println("2: UPDATE");
     System.out.println("3: DELETE");
     System.out.print("選択してください: ");
 

     int select = scanner.nextInt();
     
     switch (select) {

     case 1:
         mySQLMix.insertHobby();
         break;

     case 2:
    	 mySQLMix.updateHobby();
         break;

     case 3:
    	 mySQLMix.deleteHobby();
         break;

     default:
         System.out.println("1～3を入力してください");
     }

     scanner.close();
 }
}
