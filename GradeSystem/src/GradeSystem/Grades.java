package GradeSystem;
/** **********************************************************************
class Grades �x�s ID, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade

field 
------
ID : user ID
name : name of ID
lab1, lab2, lab3, midTerm, finalExam, totalGrade : ���ؤ���

method 
-------
calculateTotalGrade(weights) : �p��[�v��������
Grades () : �غc�l
************************************************************************/


public class Grades {
	String name, ID;
	int lab1, lab2, lab3, midTerm, finalExam, totalGrade;
	// �إߤ@�ӥ]�t ID, name, lab1, lab2, lab3, midTerm, finalExam ��Grades����  
	
	public Grades () { /*just returns an object*/ } //�غc�l
	
	/**�p��[�v��������
	 * 
	 * @param weights //�t��
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
		 * totalGrade���|�ˤ��J
		 */
		totalGrade = Math.round(weights[0] * lab1 
						  + weights[1] * lab2 
						  + weights[2] *lab3 
						  + weights[3] * midTerm 
						  + weights[4] * finalExam) ;
	}
}
