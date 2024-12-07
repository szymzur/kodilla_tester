import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        int yearNumber;

        System.out.println("Please write a random year:");
        yearNumber = getInt();

        if(yearNumber >= 1582) {
            if (yearNumber % 4 == 0 && yearNumber % 100 != 0 || yearNumber % 400 == 0) {
                System.out.println("This year: " + yearNumber + " is a leap year.");
            } else {
                System.out.println("This year: " + yearNumber + " is not a leap year.");
            }
        } else {
            System.out.println("At that time (year " + yearNumber + "), the leap year had not been established yet.");
        }
        }

    public static int getInt() {
        return new Scanner(System.in).nextInt();
    }
}