import java.util.Scanner;

// AssociationDemo.java
// Demonstrates Association relationship
// Association means one class uses another, but neither owns the other.

class Job {
    private String jobTitle;
    private String company;
    private String location;
    private double salary;
    private String benefit;

    public Job(String jobTitle, String company, String location, double salary, String benefit) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.location = location;
        this.salary = salary;
        this.benefit = benefit;
    }

    public String getJobInfo(){
        return "Job Title: "+ jobTitle +
                "\nCompany: "+ company +
                "\nLocation: "+ location +
                "\nSalary: " + salary +
                "\nBenefits: " + benefit;
    }

}

class Jobseeker {

}

public class Association {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name = sc.nextLine();

    }
}
