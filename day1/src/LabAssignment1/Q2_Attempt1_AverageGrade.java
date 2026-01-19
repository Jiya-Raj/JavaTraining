package LabAssignment1;
import java.util.Scanner;

/*Prompt user for number of students.
 * Collect grades into an int[].
 * Each grade must be between 0 and 100.
 * If invalid, print:
 * Invalid grade. Try again.
*/

public class Q2_Attempt1_AverageGrade {

	public static void main(String[] args) {
		averageGrade();
	}
	
	public static void averageGrade() {
		//COmputing Number of Students
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of Students: ");
		int NumberOfStudents =sc.nextInt();
		if(NumberOfStudents<=0) {
			System.out.println("Students can't be zero or less than zero");
			sc.close();
			return;
		}
		
		//Taking the grades and filling them in the array 
		int[] grades=new int[NumberOfStudents];
		int index=1;
		int sumOfGrades=0;
		while(index<=NumberOfStudents) {
			System.out.print("Enter grade for Student "+index+": ");
			int grade=sc.nextInt();
			if(grade<0 || grade>100) {
				System.out.println("Invalid grade. Try again.");
				continue;
			}
			sumOfGrades+=grade;
			grades[index-1]=grade;
			index++;
		}
		sc.close();
		
		//Computing the average
		double average=(double)sumOfGrades/NumberOfStudents;
		System.out.println("Average: "+average);
	}
}
