public class Grades {

    private int[] grades;
    private int size;

    public Grades() {
        this.grades = new int[10];
        this.size = 0;
    }

    public void add(int value) {
        if (this.size == 10) {
            return;
        }
        this.grades[this.size] = value;
        this.size++;
    }

    public int LastGrade() {
        if (size > 0) {
            return grades[size - 1];
        } else {
            System.out.println("No grades in the table.");
            return -1;
        }
    }

    public double AverageGrade() {
        if (size == 0) {
            System.out.println("No grades in the table.");
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += grades[i];
        }
        return (double) sum / size;
    }
    public static void main(String[] args) {
        Grades grades = new Grades();
        grades.add(5);
        grades.add(4);
        grades.add(3);

        System.out.println("Last added grade: " + grades.LastGrade());
        System.out.println("Average grade: " + grades.AverageGrade());
    }
}
