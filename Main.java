import java.util.Scanner;
public class Main {
	public static void main (String [] args) {
		int numCourses = 0; //Stores number of courses taken in a semester
		float totalCreditsEarned = 0; //Stores the total credits earned (credit * grade) for a semester
		float totalCreditsTaken = 0; //Stores total credits tken in a semester
		float GPA; //Stores final GPA

		Scanner scnr = new Scanner (System.in); //Scanner obj

		boolean flag; //To signal whether user inputed correct input
		
		System.out.println("How many classes are you taking?");
		do {
			flag = true;
			try {
				numCourses = scnr.nextInt();
			}
			catch (java.util.InputMismatchException except) { //If input is not a number
				System.out.println("Enter only a number please");
				flag = false;
				scnr.next(); //Clear buffer
			}
		} while (flag == false);
		scnr.nextLine(); //Clear buffer (nextInt() does not consum \n)

		for(int i = 0; i < numCourses; i++) {
			String name, grade; //Stores name and grade earned for a course
			float numCredits = 0; //Stores the num of credits hours for one course
			
			System.out.println("Enter class name: ");
			name = scnr.nextLine();
			
			System.out.println("How many credits is " + name + " for?");
			do {
				flag = true;
				try {
					numCredits = scnr.nextFloat();
				}
				catch (java.util.InputMismatchException except) { //If a non-float was entered
					System.out.println("Enter only a number please");
					flag = false;
					scnr.next(); //Clear buffer
				} 
				scnr.nextLine();
			} while (flag == false);	
			
			System.out.println("What grade did you get in " + name + "?");
			grade = scnr.next();
			scnr.nextLine(); //clear buffer
			
			Course course = new Course(); //Create a course for the semester
			course.makeCourse(name, grade, numCredits); //Load the name, grade and number of credits
															// and calculate total credits earned for course
			totalCreditsTaken += course.getTotalCredits(); //Add the number of credits to total credits
			totalCreditsEarned += course.getCreditsEarned(); //Add the credits earned to total
		}	
		System.out.println("Your GPA is " + totalCreditsEarned/totalCreditsTaken);
		scnr.close();
	}
}
