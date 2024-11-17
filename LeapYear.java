public class LeapYear {
    public static void main(String[] args) {
        int yearNumber = 2000;

        System.out.println(yearNumber);

        if (yearNumber % 4 == 0 && yearNumber % 100 !=0 || yearNumber % 400 == 0) {
            System.out.println("This year is a leap year");

        } else {
            System.out.println("This year is not a leap year");
        }
        }
    }