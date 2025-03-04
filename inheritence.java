// Interface defining common behavior
interface Verifiable {
    boolean isValidEmailFormat();
}

// Base class (Parent)
class Person implements Verifiable {
    String name = "Mostafa";
    String email = "most@gmail";

    @Override
    public boolean isValidEmailFormat() {
        return email.contains("@"); // Simple email validation
    }
}

// Derived class (Child) - Inheriting from Person & implementing Verifiable
class Student extends Person {
    private double GPA;

    void printGrades() {
        System.out.println(name + " GPA=" + GPA);
    }

    void setGpa(double gpa) {
        this.GPA = gpa;
    }
}

// Another class implementing the interface
class Teacher implements Verifiable {
    String subject = "Math";

    @Override
    public boolean isValidEmailFormat() {
        return true; // Assume always valid for teachers
    }

    void teach() {
        System.out.println("Teaching " + subject);
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        // ✅ Using the interface with a Student
        Student student = new Student();
        student.setGpa(3.8);
        System.out.println("Is valid email? " + student.isValidEmailFormat()); // ✅ Implemented from Verifiable
        student.printGrades();

        // ✅ Using the interface with a Teacher
        Teacher teacher = new Teacher();
        System.out.println("Is valid email? " + teacher.isValidEmailFormat());
        teacher.teach();

        // ✅ Upcasting (Student → Person)
        Person upcastedPerson = new Student(); // Upcasting
        upcastedPerson.isValidEmailFormat(); // ✅ Works because it's in Person

        // ✅ Upcasting (Student → Verifiable)
        Verifiable verifiableStudent = new Student();
        System.out.println("Upcasted Student Email Valid? " + verifiableStudent.isValidEmailFormat());

        // ✅ Upcasting (Teacher → Verifiable)
        Verifiable verifiableTeacher = new Teacher();
        System.out.println("Upcasted Teacher Email Valid? " + verifiableTeacher.isValidEmailFormat());

        // ❌ Incorrect Downcasting Example
        if (verifiableStudent instanceof Student) { // Always check before downcasting!
            Student downcastedStudent = (Student) verifiableStudent;
            downcastedStudent.printGrades();
        }

        // ❌ This would throw an error at runtime
        // Student wrongDowncast = (Student) new Teacher(); // ❌ ClassCastException!
    }
}
