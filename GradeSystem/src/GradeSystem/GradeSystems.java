package GradeSystem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

/** *************************************************************************
class GradeSystems�x�s a list of student grades.

field 
------- 
aList : ��Ҧ��H�����Z
weights : ���t�Ϊ��t��

method 
-------
containsID(ID) : ��aGradeSystem���_�t��ID
GradeSystems() : �غc�l
showGrade(ID)  : ��ܸ�ID�����Z
getName(String ID) : �^�Ǹ�ID���ǥͩm�W
showRank(ID)  : ��ܸ�ID���ƦW	
updateWeights()  : ��s���Z�t��
*************************************************************************** */

public class GradeSystems {
	private LinkedList<Grades> aList;
	float[] weights = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
	Scanner scanner;
	
	// �غc�l
	public GradeSystems() throws FileNotFoundException {
		/*  1. �}�� input file 
			2. ��Java LinkedList�غcan empty list of grades�s aList
			3. read line
			4. while not endOfFile
			1.call Grades() �غcaGrade
			2.�� Java Scanner �� scan line ��U���s�JaGrade
			3. aGrade.calculateTotalGrade(weights) �^��aTotalGrade�⥦�s�JaGrade
			4. �� aGrade �s�J aList
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
	 * if(�䤣���ID)
	 * 		throw NoSuchIDExceptions
	 * 
	 * @param ID ���d�ߤ�ID 
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
	 * 		if �o�{��ID
	 * 			print the data of grades
	 * end loop
	 * 
	 * return ��쪺��ID��grades
	 * @param ID ���d�ߤ�ID 
	 * @return the grades of the ID
	 */
	public Grades showGrade(String ID) {
		Grades gradeOfID = null;
		for(int i=0; i<aList.size(); i++) {
			if(aList.get(i).ID.equals(ID)) {
				gradeOfID = aList.get(i);
				System.out.print("\n" + gradeOfID.name + "���Z:lab1:" + gradeOfID.lab1+ "\r\n"
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
	 * �^�Ǹ�ID���ǥͩm�W
	 * @param ID
	 * @return
	 */
	public String getName(String ID) {
		// return name of the student
		return getGradeByID(ID).name;
	}
	
	/**��ܱƦW
	 * @param ID
	 * @return rank of the ID
	 */
	public int showRank(String ID) {
		/*
		 * rank = 1
		 * loop grades in aList
		 * 		if ���H�`����ۤv��
		 * 			rank++
		 * end loop
		 * 
		 * ���: �Y�H�ƦW��rank	
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
		
		System.out.print(myGrade.name + "�ƦW�� " + rank + "\r\n");
		
		return rank;
	}
	
	/**
	 * ��s���Z�t��
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
		System.out.print("�°t��\r\n"
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
		 * ���ϥΪ̽T�{�O�_�n��s�����t��
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
		System.out.print("��J�s�t��\r\n\tlab1\t");
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
		
		System.out.print("�нT�{�s�t��\r\n"
				+ "\tlab1\t" + (int)(newWeights[0]*100) + "%\r\n"
				+ "\tlab2\t" + (int)(newWeights[1]*100) + "%\r\n"
				+ "\tlab3\t" + (int)(newWeights[2]*100) + "%\r\n"
				+ "\tmid-term\t" + (int)(newWeights[3]*100) + "%\r\n"
				+ "\tfinal exam\t" + (int)(newWeights[4]*100) + "%\r\n"
				+ "�H�W���T��? Y (Yes) �� N (No)\r\n");
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
