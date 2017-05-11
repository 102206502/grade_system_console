package GradeSystem;

import java.io.FileNotFoundException;
import java.util.Scanner;

/** **************************************************************
class UI (user interface) 

field 
------- 
aGradeSystem : 存放所有成績的物件
ID : 目前使用者的學號
scanner : input scanner

method 
-------
UI() : 建構子 建構 aGradeSystem
checkID(ID)  : 看 ID 是否含在 aGradeSystem內
promptCommand() : 提供使用者功能指令
promptID() : 提醒使用者輸入自己的ID
showFinishMsg() : 顯示結束訊息
showWelcomeMsg(ID) : 顯示歡迎訊息

****************************************************************** */

public class UI {
	GradeSystems aGradeSystem;
	String ID;
	Scanner scanner;
	
	/** ---------------------------------------------------------
	UI() 建構子 throws NoSuchIDExceptions, NoSuchCommandExceptions
	------------------------------------------------------------- 
	 * @throws NoSuchIDExceptions 
	 * @throws NoSuchCommandExceptions */
	public UI(String msg) throws NoSuchIDExceptions, NoSuchCommandExceptions {
	/*
	 *  try 
			1.call GradeSystems() to建構 aGradeSystem
			
			2.loop1 until Q (Quit)
			1.	promptID() to get user ID  輸入ID或 Q (結束使用)？ 
			2.	checkID (ID) 看 ID 是否在 aGradeSystem內
			3.	showWelcomeMsg (ID)      ex. Welcome李威廷
				4.	loop2 until E (Exit)
					promptCommand() to prompt for inputCommand 
			    end loop2
			end loop1
			3.showFinishMsg()           結束了
		end try
		finally {}
	
	 */
		try {
			scanner = new Scanner(System.in);
			String getCommend = "";
			if(msg.equals("Test Mode")) {
				aGradeSystem = new GradeSystems();
			}
			else {
				aGradeSystem = new GradeSystems();
				while(true) {
					getCommend = promptID();
					if(getCommend.equals("Q"))
						break;
					checkID(getCommend);
					ID = getCommend;
					showWelcomeMsg(ID);
					do {
						getCommend = promptCommand();
						if(!getCommend.equals("G") && 
								!getCommend.equals("R") && 
								!getCommend.equals("W") && 
								!getCommend.equals("E"))
							throw new NoSuchCommandExceptions(getCommend);
					}while(!getCommend.equals("E"));
					System.out.print("");
					
				}
				showFinishMsg();
				
				scanner.close();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {}
		
	}
	
	/**看 ID 是否含在 aGradeSystem內
	 * 
	 * @param ID
	 * @return flag ID存在就是true
	 * @throws NoSuchIDExceptions 
	 */
	public boolean checkID(String ID) throws NoSuchIDExceptions {
		/*
		 *  1.	要aGradeSystem 做containsID(ID) 看 ID 是否含在 aGradeSystem內 
			2.	if not, throw an object of NoSuchIDExceptions
			3.	回傳 true

		 */
		boolean flag = false;
		flag = aGradeSystem.containsID(ID);
		return flag;
	}
	
	/**提醒使用者輸入自己的ID
	 * 
	 * @return ID user的ID
	 * @throws NoSuchCommandExceptions 
	 */
	public String promptID() throws NoSuchCommandExceptions {
		/*
		 *  提醒使用者輸入自己的ID，或是離開(輸入Q)
		 *  接收使用者輸入
		 *  if(使用者輸入Q)
		 *  	return user input
		 *  else if(!輸入字串長度是學號長度(9))
		 *  	throw NoSuchCommandException
		 *  else
		 *  	return ID
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("輸入ID或 Q (結束使用)? ");
		String inputStr = scanner.nextLine();
		//scanner.close();
		if(inputStr.equals("Q"))
			return inputStr;
		else if(inputStr.length() != 9)
			throw new NoSuchCommandExceptions(inputStr);
		else
			return inputStr;
		
	}
	
	/**提供使用者功能指令
	 * @throws NoSuchCommandExceptions 
	 * 
	 */
	public String promptCommand() throws NoSuchCommandExceptions {
		/*
		 *  1. prompt user for inputCommand
			2. if inputCommand is not G (Grade),R (Rank), W (Weights), or E (Exit),
			 throws an object of NoSuchCommandException  end if
			3. if inputCommand is E (Exit) then break
			else: G aGradeSystem.showGrade(ID), R showRank(ID), W updateWeights() end if
			return inputCommand
		 */
		System.out.print("\r\n\t輸入指令 "
				+ "1) G 顯示成績 (Grade) \r\n\t     "
				+ "2) R 顯示排名 (Rank) \r\n\t     "
				+ "3) W 更新配分 (Weight) \r\n\t     "
				+ "4) E 離開選單 (Exit)\n"
				+ "使用者輸入： ");
		String input = scanner.next();
		
		switch(input) {
		case "G":
			aGradeSystem.showGrade(ID);
			break;
		case "R":
			aGradeSystem.showRank(ID);
			break;
		case "W":
			aGradeSystem.updateWeights();
			break;
		case "E":
			return "E";
		default:
			throw new NoSuchCommandExceptions(input);
		}
		return input;
	}
	
	/**show finish message
	 * 
	 */
	public void showFinishMsg() {
		// show finish message
		System.out.print("結束了\r\n");
	}
	
	/**show welcome message to user
	 * 
	 * @param ID user的ID
	 */
	public void showWelcomeMsg(String ID) {
		//show welcome message to user
		System.out.print("Welcome " + aGradeSystem.getName(ID) + "\n\n");
	}
}
