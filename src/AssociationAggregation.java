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

    public String getJobInfo() {
        return "Job Title:    " + jobTitle +
                "\nCompany:      " + company +
                "\nLocation:     " + location +
                "\nSalary:       " + salary +
                "\nBenefits:     " + benefit;
    }
}

class Jobseeker {
    private String name;
    private Job job;
    /*  Aggregation Relationship:
        Jobseeker "has a" job object but job object can exist independently,
        because job object is created outside of this class, and passed only into here*/

    public Jobseeker(String name) {
        this.name = name;
    }

    public void viewJobs(Job job1, Job job2) {
        /* Association Relationship:
           In here the seeker object interacts with the job class,
           he does not have a relationship yet with any of the job objects,
           but he can interact with them this shows an Association Relationship*/
        System.out.println("\nAvailable Job:");
        System.out.println("\nJob 1:\n" + job1.getJobInfo());
        System.out.println("\nJob 2:\n" + job2.getJobInfo());
    }

    /*  Aggregation Relationship happens here because we're passing the job object to the Jobseeker class/object,
        So basically Jobseeker class now a "has a" relationship with the Job object we passed it in the parameter. */
    public void applyForJob(Job job) {
        this.job = job; // The seeker object now has a relationship with the job object
        System.out.println("\n" + name + " has applied for the job: " + job.getJobTitle());
    }

    public void showAppliedJob(Scanner sc) {
        if (job != null) {
            /* in here the seeker object can now directly access the job's info,
             because he now has a relationship with that object */
            System.out.println("\n" + name + "'s Applied Job Details:");
            System.out.println(job.getJobInfo());
            sc.nextLine();
        } else {
            System.out.println("\n" + name + " has not applied for any job yet.");
            sc.nextLine();
        }
    }
}

public class AssociationAggregation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* Creating Job Objects here where the job objects can independently exist, but we can also pass them to other classes */
        Job job1 = new Job("software developer", "Microsoft", "United States", 120000, "insurance");
        Job job2 = new Job("Data Analyst", "Google", "San Francisco", 90000, "healthcare");

        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        Jobseeker seeker = new Jobseeker(name);

        while (true) {
            System.out.println("\n--- Job Portal ---");
            System.out.println("1. View all Jobs");
            System.out.println("2. Apply for a Job");
            System.out.println("3. Show Applied Job");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    seeker.viewJobs(job1, job2);
                    break;

                case 2:
                    System.out.print("Enter Job number to apply (1 or 2): ");
                    int jobChoice = sc.nextInt();
                    sc.nextLine();

                    if (jobChoice == 1) {
                        seeker.applyForJob(job1);
                        sc.nextLine();
                    } else if (jobChoice == 2) {
                        seeker.applyForJob(job2);
                        sc.nextLine();
                    } else {
                        System.out.println("Invalid Job selection!");
                    }
                    break;

                case 3:
                    seeker.showAppliedJob(sc);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
