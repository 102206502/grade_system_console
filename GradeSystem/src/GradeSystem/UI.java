package GradeSystem;

import java.io.FileNotFoundException;
import java.util.Scanner;

/** **************************************************************
class UI (user interface) 

field 
------- 
aGradeSystem : �s��Ҧ����Z������
ID : �ثe�ϥΪ̪��Ǹ�
scanner : input scanner

method 
-------
UI() : �غc�l �غc aGradeSystem
checkID(ID)  : �� ID �O�_�t�b aGradeSystem��
promptCommand() : ���ѨϥΪ̥\����O
promptID() : �����ϥΪ̿�J�ۤv��ID
showFinishMsg() : ��ܵ����T��
showWelcomeMsg(ID) : ����w��T��

****************************************************************** */

public class UI {
	GradeSystems aGradeSystem;
	String ID;
	Scanner scanner;
	
	/** ---------------------------------------------------------
	UI() �غc�l throws NoSuchIDExceptions, NoSuchCommandExceptions
	------------------------------------------------------------- 
	 * @throws NoSuchIDExceptions 
	 * @throws NoSuchCommandExceptions */
	public UI(String msg) throws NoSuchIDExceptions, NoSuchCommandExceptions {
	/*
	 *  try 
			1.call GradeSystems() to�غc aGradeSystem
			
			2.loop1 until Q (Quit)
			1.	promptID() to get user ID  ��JID�� Q (�����ϥ�)�H 
			2.	checkID (ID) �� ID �O�_�b aGradeSystem��
			3.	showWelcomeMsg (ID)      ex. Welcome���§�
				4.	loop2 until E (Exit)
					promptCommand() to prompt for inputCommand 
			    end loop2
			end loop1
			3.showFinishMsg()           �����F
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
	
	/**�� ID �O�_�t�b aGradeSystem��
	 * 
	 * @param ID
	 * @return flag ID�s�b�N�Otrue
	 * @throws NoSuchIDExceptions 
	 */
	public boolean checkID(String ID) throws NoSuchIDExceptions {
		/*
		 *  1.	�naGradeSystem ��containsID(ID) �� ID �O�_�t�b aGradeSystem�� 
			2.	if not, throw an object of NoSuchIDExceptions
			3.	�^�� true

		 */
		boolean flag = false;
		flag = aGradeSystem.containsID(ID);
		return flag;
	}
	
	/**�����ϥΪ̿�J�ۤv��ID
	 * 
	 * @return ID user��ID
	 * @throws NoSuchCommandExceptions 
	 */
	public String promptID() throws NoSuchCommandExceptions {
		/*
		 *  �����ϥΪ̿�J�ۤv��ID�A�άO���}(��JQ)
		 *  �����ϥΪ̿�J
		 *  if(�ϥΪ̿�JQ)
		 *  	return user input
		 *  else if(!��J�r����׬O�Ǹ�����(9))
		 *  	throw NoSuchCommandException
		 *  else
		 *  	return ID
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("��JID�� Q (�����ϥ�)? ");
		String inputStr = scanner.nextLine();
		//scanner.close();
		if(inputStr.equals("Q"))
			return inputStr;
		else if(inputStr.length() != 9)
			throw new NoSuchCommandExceptions(inputStr);
		else
			return inputStr;
		
	}
	
	/**���ѨϥΪ̥\����O
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
		System.out.print("\r\n\t��J���O "
				+ "1) G ��ܦ��Z (Grade) \r\n\t     "
				+ "2) R ��ܱƦW (Rank) \r\n\t     "
				+ "3) W ��s�t�� (Weight) \r\n\t     "
				+ "4) E ���}��� (Exit)\n"
				+ "�ϥΪ̿�J�G ");
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
		System.out.print("�����F\r\n");
	}
	
	/**show welcome message to user
	 * 
	 * @param ID user��ID
	 */
	public void showWelcomeMsg(String ID) {
		//show welcome message to user
		System.out.print("Welcome " + aGradeSystem.getName(ID) + "\n\n");
	}
}
