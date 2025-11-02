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
            return this.resume.getResume();
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
        this.resume = new Resume(education, skills, experience); // Resume is now part of the JobSeeker
        System.out.println("Resume created and attached to " + this.name + ".");
    }
}

class Resume {
    private String education;
    private String skills;
    private int experience;

    public Resume(String education, String skills, int experience) {
        this.education = education;
        this.skills = skills.toLowerCase();
        this.experience = experience;
    }
    public String getResume() {
        return "Education:   " + education +
                "\nSkills:      " + skills +
                "\nExperience:  " + experience;
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
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nMy Resume Details:");
                    System.out.println(seeker.getResume());
                    sc.nextLine();
                    break;

                case 2:
                    // Seeker object calls the method to create Resume object
                    seeker.createResume();
                    sc.nextLine();
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
