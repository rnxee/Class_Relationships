package Association;// Association.Association relationship
import java.util.Scanner;

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

    public String getJobTitle() {
        return jobTitle;
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
    private String name;
    private Job job;

    public Jobseeker(String name) {
        this.name = name;
    }
    // Association.Jobseeker interacts with Association.Job class
    public void viewJob(Job job) {
        System.out.println(job.getJobInfo());
    }
    // Association.Jobseeker applies for a job
    public void applyForJob(Job job) {
        this.job = job;
        System.out.println("\n" + name + " has applied for the job: " + job.getJobTitle());
    }
    public void displayAppliedJob() {
        if (job != null) {
            System.out.println("\n" + name + "'s Applied Job Details:");
            System.out.println(job.getJobInfo());
        } else {
            System.out.println("\n" + name + " has not applied for any job yet.");
            return;
        }
    }
}

public class Association {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Creating Association.Job Objects
        Job job1 = new Job("software developer", "Microsoft", "United States", 120000, "insurance");
        Job job2 = new Job("Data Analyst", "Google", "San Francisco", 90000, "healthcare");

        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        Jobseeker seeker = new Jobseeker(name);

        Association association = new Association();

        while (true) {
            System.out.println("\n--- Job Portal ---");
            System.out.println("1. View all Jobs");
            System.out.println("2. Apply for a Job");
            System.out.println("3. Display Applied Job");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    association.viewAllJobs(seeker, job1, job2);
                    break;

                case 2:
                    association.applyForJob(seeker, job1, job2, sc);
                    break;

                case 3:
                    seeker.displayAppliedJob();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
            }
        }

    }

    private void viewAllJobs(Jobseeker seeker, Job job1, Job job2) {
        System.out.println("\nAvailable Jobs: ");
        System.out.print("\n1. ");
        seeker.viewJob(job1);
        System.out.print("\n2. ");
        seeker.viewJob(job2);
    }

    private void applyForJob(Jobseeker seeker, Job job1, Job job2, Scanner sc) {
        System.out.print("Enter Job number to apply (1 or 2): ");
        int jobChoice = sc.nextInt();
        sc.nextLine();

        if (jobChoice == 1) {
            seeker.applyForJob(job1);
        } else if (jobChoice == 2) {
            seeker.applyForJob(job2);
        } else {
            System.out.println("Invalid Job selection!");
        }
    }

}
