import java.util.Scanner;

public class ColorSelector {
    public static void main(String[] args) {
        String color = getColorByFirstLetter();
        System.out.println("Selected color: " + color);
    }

    public static String getColorByFirstLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first letter of the color:");
        String letter = scanner.nextLine().trim().toUpperCase();

        switch (letter) {
            case "R": return "Red";
            case "G": return "Green";
            case "B": return "Blue";
            case "Y": return "Yellow";
            case "O": return "Orange";
            case "P": return "Purple";
            case "W": return "White";
            case "K": return "Black";
            default:
                System.out.println("Unknown color. Try again.");
                return getColorByFirstLetter();
        }
    }
}