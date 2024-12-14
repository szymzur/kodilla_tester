public class GradesApp {
    public static void main(String[] args) {
        Grades grades = new Grades();
        grades.add(5);
        grades.add(4);
        grades.add(3);

        System.out.println("Last added grade: " + grades.LastGrade());
        System.out.println("Average grade: " + grades.averageGrade());
    }
}
