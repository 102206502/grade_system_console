package GradeSystem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

/** *************************************************************************
class GradeSystems儲存 a list of student grades.

field 
------- 
aList : 放所有人的成績
weights : 此系統的配分

method 
-------
containsID(ID) : 看aGradeSystem有否含此ID
GradeSystems() : 建構子
showGrade(ID)  : 顯示該ID的成績
getName(String ID) : 回傳該ID的學生姓名
showRank(ID)  : 顯示該ID的排名	
updateWeights()  : 更新成績配分
*************************************************************************** */

public class GradeSystems {
	private LinkedList<Grades> aList;
	float[] weights = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
	Scanner scanner;
	
	// 建構子
	public GradeSystems() throws FileNotFoundException {
		/*  1. 開檔 input file 
			2. 用Java LinkedList建構an empty list of grades叫 aList
			3. read line
			4. while not endOfFile
			1.call Grades() 建構aGrade
			2.用 Java Scanner 來 scan line 把各欄位存入aGrade
			3. aGrade.calculateTotalGrade(weights) 回傳aTotalGrade把它存入aGrade
			4. 把 aGrade 存入 aList
			     end while
 		  */
		URL fileUrl = getClass().getResource("gradeInput.txt");
		String path = fileUrl.getPath();
		FileReader file = new FileReader(path);
		Scanner fileInput = new Scanner(file);
		aList = new LinkedList<Grades>();
		
		while(fileInput.hasNextLine()) {
			String line = fileInput.nextLine();
			
			if(line.equals(""))
				break;
			
			Grades aGrade = new Grades();
			String[] gradesData = line.split(" ");
			// format : ID Name lab1 lab2 lab3 mid final
			aGrade.ID = gradesData[0];
			aGrade.name = gradesData[1];
			aGrade.lab1 = Integer.parseInt(gradesData[2]);
			aGrade.lab2 = Integer.parseInt(gradesData[3]);
			aGrade.lab3 = Integer.parseInt(gradesData[4]);
			aGrade.midTerm = Integer.parseInt(gradesData[5]);
			aGrade.finalExam = Integer.parseInt(gradesData[6]);
			aGrade.calculateTotalGrade(weights);
			aList.add(aGrade);
		}
		fileInput.close();
	}
	
	/**check if there is the ID as input in gradeSystem
	 * if(找不到該ID)
	 * 		throw NoSuchIDExceptions
	 * 
	 * @param ID 欲查詢之ID 
	 * @return if the ID is contained or not
	 * @throws NoSuchIDExceptions 
	 */
	public boolean containsID(String ID) throws NoSuchIDExceptions {
		boolean contained = false;
		for(int i=0; i<aList.size(); i++) {
			if(aList.get(i).ID.equals(ID))
				contained = true;
		}
		
		if(!contained)
			throw new NoSuchIDExceptions(ID);
		
		return contained;
	}
	
	/**loop grades in aList
	 * 		if 發現該ID
	 * 			print the data of grades
	 * end loop
	 * 
	 * return 找到的該ID的grades
	 * @param ID 欲查詢之ID 
	 * @return the grades of the ID
	 */
	public Grades showGrade(String ID) {
		Grades gradeOfID = null;
		for(int i=0; i<aList.size(); i++) {
			if(aList.get(i).ID.equals(ID)) {
				gradeOfID = aList.get(i);
				System.out.print("\n" + gradeOfID.name + "成績:lab1:" + gradeOfID.lab1+ "\r\n"
						+ "lab2:" + gradeOfID.lab2+ "\r\n"
						+ "lab3:" + gradeOfID.lab3+ "\r\n"
						+ "mid-term:" + gradeOfID.midTerm+ "\r\n"
						+ "final exam:" + gradeOfID.finalExam+ "\r\n"
						+ "total grade:" + gradeOfID.totalGrade+ "\r\n");
				break;
			}
		}
		
		
		return gradeOfID;
	}
	
	private Grades getGradeByID(String ID) {
		Grades gradeOfID = null;
		for(int i=0; i<aList.size(); i++) {
			if(aList.get(i).ID.equals(ID))
				gradeOfID = aList.get(i);
		}
		return gradeOfID;
	}
	
	/**
	 * 回傳該ID的學生姓名
	 * @param ID
	 * @return
	 */
	public String getName(String ID) {
		// return name of the student
		return getGradeByID(ID).name;
	}
	
	/**顯示排名
	 * @param ID
	 * @return rank of the ID
	 */
	public int showRank(String ID) {
		/*
		 * rank = 1
		 * loop grades in aList
		 * 		if 有人總分比自己高
		 * 			rank++
		 * end loop
		 * 
		 * 顯示: 某人排名第rank	
		 * 
		 * return rank
		 */
		int rank = 1;
		Grades myGrade = getGradeByID(ID);
		for(int i = 0; i < aList.size() ; i++) {
			if(aList.get(i).totalGrade > myGrade.totalGrade && 
					!aList.get(i).ID.equals(myGrade.ID)) {
				rank++;
			}
		}
		
		System.out.print(myGrade.name + "排名第 " + rank + "\r\n");
		
		return rank;
	}
	
	/**
	 * 更新成績配分
	 * @throws NoSuchCommandExceptions 
	 */
	public void updateWeights() throws NoSuchCommandExceptions {
		/*public updateWeights () 
	      1. showOldWeights() 
		  2. getNewWeights() 
		  3. setWeights(weights)
	      4. loop aGrade in aList to calculateTotalGrade(weights) end loop
		*/
		showOldWeights();
		float[] newWeights = getNewWeights();
		setWeights(newWeights);
		for(int i = 0; i < aList.size() ; i++) {
			aList.get(i).calculateTotalGrade(weights);
		}
	}
	
	/**
	 * show the weight array before user change it
	 */
	private void showOldWeights(){
		/*
		 * Print weights[]
		 */
		System.out.print("舊配分\r\n"
				+ "\tlab1\t" + (int)(weights[0]*100) + "%\r\n"
				+ "\tlab2\t" + (int)(weights[1]*100) + "%\r\n"
				+ "\tlab3\t" + (int)(weights[2]*100) + "%\r\n"
				+ "\tmid-term\t" + (int)(weights[3]*100) + "%\r\n"
				+ "\tfinal exam\t" + (int)(weights[4]*100) + "%\r\n");
		
	}
	
	/**get new weights from UI
	 * @throws NoSuchCommandExceptions 
	 */
	private float[] getNewWeights() throws NoSuchCommandExceptions {
		/*
		 * prompt input new weights
		 * input new weights[] 
		 * 讓使用者確認是否要更新為此配分
		 * if(user input 'N')
		 * 		return weights
		 * else if(user input 'Y')
		 * 		return newWeights
		 * else
		 * 		throw NoSuchCommandExceptions
		 */
		float[] newWeights = new float[5];
		scanner = new Scanner(System.in);
		String tempStr = "";
		System.out.print("輸入新配分\r\n\tlab1\t");
		tempStr = scanner.nextLine();
		newWeights[0] = (Float.parseFloat(tempStr))/100.0f;
		System.out.print("\tlab2\t");
		tempStr = scanner.nextLine();
		newWeights[1] = (Float.parseFloat(tempStr))/100.0f;
		System.out.print("\tlab3\t");
		tempStr = scanner.nextLine();
		newWeights[2] = (Float.parseFloat(tempStr))/100.0f;
		System.out.print("\tmid-term\t");
		tempStr = scanner.nextLine();
		newWeights[3] = (Float.parseFloat(tempStr))/100.0f;
		System.out.print("\tfinal exam\t");
		tempStr = scanner.nextLine();
		newWeights[4] = (Float.parseFloat(tempStr))/100.0f;
		
		System.out.print("請確認新配分\r\n"
				+ "\tlab1\t" + (int)(newWeights[0]*100) + "%\r\n"
				+ "\tlab2\t" + (int)(newWeights[1]*100) + "%\r\n"
				+ "\tlab3\t" + (int)(newWeights[2]*100) + "%\r\n"
				+ "\tmid-term\t" + (int)(newWeights[3]*100) + "%\r\n"
				+ "\tfinal exam\t" + (int)(newWeights[4]*100) + "%\r\n"
				+ "以上正確嗎? Y (Yes) 或 N (No)\r\n");
		String updateCheck = scanner.next();
		
		
		if(updateCheck.equals("Y"))
			return newWeights;
		else if(updateCheck.equals("N"))
			return weights;
		else
			throw new NoSuchCommandExceptions(updateCheck);
	}
	
	/**set the weights by input
	 * 
	 * @param weights new weights
	 */
	private void setWeights(float[] newWeights) {
		/*
		 * weights = newWeights
		 */
		weights = newWeights;
	}
	
}
