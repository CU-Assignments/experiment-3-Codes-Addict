import java.util.HashMap;
import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class UniversityEnrollment {
    private static final int MAX_STUDENTS = 2;
    private static HashMap<String, Integer> courseEnrollment = new HashMap<>();
    private static HashMap<String, String> prerequisites = new HashMap<>();
    private static HashMap<String, Boolean> completedCourses = new HashMap<>();

    static {
        courseEnrollment.put("Advanced Java", 1);
        courseEnrollment.put("Core Java", 1);
        prerequisites.put("Advanced Java", "Core Java");

        completedCourses.put("Core Java", false);
        completedCourses.put("Python Basics", true);
    }

    public static void enrollStudent(String course) throws CourseFullException, PrerequisiteNotMetException {
        // Check if course has prerequisites
        if (prerequisites.containsKey(course)) {
            String prerequisite = prerequisites.get(course);
            if (!completedCourses.getOrDefault(prerequisite, false)) {
                throw new PrerequisiteNotMetException("Complete " + prerequisite + " before enrolling in " + course);
            }
        }

        int enrolledStudents = courseEnrollment.getOrDefault(course, 0);
        if (enrolledStudents >= MAX_STUDENTS) {
            throw new CourseFullException("Course " + course + " is full.");
        }

        courseEnrollment.put(course, enrolledStudents + 1);
        System.out.println("Successfully enrolled in " + course);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();

            enrollStudent(course);

        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            System.out.println("Thank you for using the University Enrollment System.");
            scanner.close();
        }
    }
}
