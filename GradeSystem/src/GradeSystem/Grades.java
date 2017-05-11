package GradeSystem;
/** **********************************************************************
class Grades 儲存 ID, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade

field 
------
ID : user ID
name : name of ID
lab1, lab2, lab3, midTerm, finalExam, totalGrade : 五種分數

method 
-------
calculateTotalGrade(weights) : 計算加權平均分數
Grades () : 建構子
************************************************************************/


public class Grades {
	String name, ID;
	int lab1, lab2, lab3, midTerm, finalExam, totalGrade;
	// 建立一個包含 ID, name, lab1, lab2, lab3, midTerm, finalExam 的Grades物件  
	
	public Grades () { /*just returns an object*/ } //建構子
	
	/**計算加權平均分數
	 * 
	 * @param weights //配分
	 */
	public void calculateTotalGrade(float[] weights) {
		/*
		 * totalGrade = 
		 * weights[0] * lab1 
		 * + weights[1] * lab2 
		 * + weights[2] *lab3 
		 * + weights[3] * midTerm 
		 * + weights[4] * finalExam
		 * 
		 *
		 * totalGrade須四捨五入
		 */
		totalGrade = Math.round(weights[0] * lab1 
						  + weights[1] * lab2 
						  + weights[2] *lab3 
						  + weights[3] * midTerm 
						  + weights[4] * finalExam) ;
	}
}
