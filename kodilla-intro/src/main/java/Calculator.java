public class Calculator {
    static final double PI = 3.1415927;
    public static int counter = 0;

    public Calculator() {

    }

    public double add(double a, double b) {
        counter++;
        return a + b;
    }

    public double sub(double a, double b) {
        counter++;
        return a - b;
    }

    public double circleArea(double r) {
        counter++;
        String name = UserDialogs.getUsername();
        System.out.println("Hi, " + name + ". Thank you for using our software.");
        return PI * r * r;
    }

    public double circlePerimeter(double r) {
        counter++;
        return 2 * PI * r;
    }
}
