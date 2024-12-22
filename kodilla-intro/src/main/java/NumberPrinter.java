public class NumberPrinter {

    public static void printNumbers(int x) {
        if (x < 0) {
            System.out.println("Number must be positive.");
            return;
        }

        for (int i = 0; i <= x; i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        int x = 23;
        printNumbers(x);
    }
}
