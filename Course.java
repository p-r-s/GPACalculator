
public class Course {
private String name;
private String Grade;
private float creditsEarned;
private float totalCredits;

public Course () {
	name = "";
	Grade = "";
	creditsEarned = 0;
	totalCredits = 0 ;
	
}
public void makeCourse (String name, String Grade, float totalCredits) {
this.name = name;
this.Grade = Grade;
this.totalCredits = totalCredits;
switch(Grade) {
case "A": creditsEarned = 4.0f*totalCredits; break;
case "AB": creditsEarned = 3.5f*totalCredits; break;
case "B" : creditsEarned = 3*totalCredits; break;
case "BC" : creditsEarned = 2.5f*totalCredits; break;
case "C": creditsEarned = 2*totalCredits; break;
case "D": creditsEarned = totalCredits; break;
case "F": creditsEarned = 0;
}
}

public float getCreditsEarned () {
	return creditsEarned;
}

public float getTotalCredits() {
	return totalCredits;
}


}