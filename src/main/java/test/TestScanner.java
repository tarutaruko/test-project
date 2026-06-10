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
     System.out.println("2: READ");
     System.out.println("3: UPDATE");
     System.out.println("4: DELETE");
     System.out.print("選択してください: ");
 

     int select = scanner.nextInt();
     
     System.out.println(select);
 }
}
