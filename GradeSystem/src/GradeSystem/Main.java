package GradeSystem;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**************************************************************
 * class Main
 * 
 * method
 * --------
 * main : �}�l�{��
 * 
 ***************************************************************/
public class Main {

	public static void main(String[] args) {
		/**try
		 *  new UI
		 * end try
		 * 
		 * catch
		 *  NoSuchIDExceptions print ID���F
		 *  NoSuchCommandExceptions print ���O���F
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
		System.out.println("ID���F!");
	}
}

class NoSuchCommandExceptions extends Exception { 
	public NoSuchCommandExceptions(String errorInput) {
		System.out.println("���O���F!");
	}
}