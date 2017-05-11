package GradeSystem;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**************************************************************
 * class Main
 * 
 * method
 * --------
 * main : 開始程式
 * 
 ***************************************************************/
public class Main {

	public static void main(String[] args) {
		/**try
		 *  new UI
		 * end try
		 * 
		 * catch
		 *  NoSuchIDExceptions print ID錯了
		 *  NoSuchCommandExceptions print 指令錯了
		 */
		try {
			UI aUI = new UI("start!!!!!!");
		} catch (NoSuchCommandExceptions | NoSuchIDExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class NoSuchIDExceptions extends Exception {
	public NoSuchIDExceptions(String ID) {
		System.out.println("ID錯了!");
	}
}

class NoSuchCommandExceptions extends Exception { 
	public NoSuchCommandExceptions(String errorInput) {
		System.out.println("指令錯了!");
	}
}