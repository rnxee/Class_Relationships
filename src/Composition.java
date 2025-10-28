import java.util.Scanner;

class JobSeeker {
    protected String name;
    private Resume resume;
    /*  JobSeeker object "owns" the resume object,
        Resume object depends on the JobSeeker,
        If the Jobseeker is destroyed its resume is also destroyed */

    public JobSeeker(String name) {
        this.name = name;
    }

    public String getResume() {
        if (this.resume != null) {
            return this.resume.toString();
        } else {
            return "\nNo resume attached.";
        }
    }

    public void createResume() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Resume Details ---");
        System.out.print("Education: ");
        String education = sc.nextLine();
        System.out.print("Skills Keywords (comma-separated, e.g., Java, SQL, AWS): ");
        String skills = sc.nextLine();
        System.out.print("Experience (Years):");
        int experience;
        while (true) {
            String sExp = sc.nextLine();
            try {
                experience = Integer.parseInt(sExp);
                break;
            } catch (NumberFormatException nfe) {
                System.out.print("Invalid number. Enter Experience (Years) as an integer: ");
            }
        }

        /* Composition occurs here:
           The jobseeker creates and owns the resume object
           The jobseeker cannot exist independently without its creator. */
        Resume newResume = new Resume(education, skills, experience);
        this.resume = newResume; // Resume is now part of the JobSeeker
        System.out.println("Resume created and attached to " + this.name + ".");
    }
}

class Resume {
    private String education;
    private String skills;
    private int experience;

    public String getEducation() {
        return education;
    }
    public String getSkills() {
        return skills;
    }
    public int getExperience() {
        return experience;
    }
    public Resume(String education, String skills, int experience) {
        this.education = education;
        this.skills = skills.toLowerCase();
        this.experience = experience;
    }
    @Override
    public String toString() {
        String format = "%-15s %s%n";

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(format, "Education:", this.education));
        sb.append(String.format(format, "Skills:", this.skills));
        sb.append(String.format(format, "Experience:", this.experience + " Years"));

        return sb.toString();
    }
}

public class Composition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        JobSeeker seeker = new JobSeeker(name);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View Resume");
            System.out.println("2. Create Resume");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nMy Resume Details:");
                    System.out.println(seeker.getResume());
                    break;

                case 2:
                    // Seeker object calls the method to create Resume object
                    seeker.createResume();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
