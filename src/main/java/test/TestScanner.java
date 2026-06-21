/**
 * 
 */
package test;

import java.util.Scanner;

/**
 * 
 */
public class TestScanner {
 public static void main (String[]args)  {
	 Scanner scanner = new Scanner(System.in);

     System.out.println("====== CRUDサンプル ======");
     System.out.println("1: CREATE");
     System.out.println("2: UPDATE");
     System.out.println("3: DELETE");
     System.out.print("選択してください: ");
 

     int select = scanner.nextInt();
     
     switch (select) {

     case 1:
         MySQLMix.insertHobby();
         break;

     case 2:
         MySQLMix.updateHobby();
         break;

     case 3:
         MySQLMix.deleteHobby();
         break;

     default:
         System.out.println("1～3を入力してください");
     }

     scanner.close();
 }
}
