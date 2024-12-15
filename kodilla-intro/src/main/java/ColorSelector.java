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
        String color;

        switch (letter) {
            case "R":
                color = "Red";
                break;
            case "G":
                color = "Green";
                break;
            case "B":
                color = "Blue";
                break;
            case "Y":
                color = "Yellow";
                break;
            case "O":
                color = "Orange";
                break;
            case "P":
                color = "Purple";
                break;
            case "W":
                color = "White";
                break;
            case "K":
                color = "Black";
                break;
            default:
                color = "Unknown color";
                break;
        }
        return
                color;
    }
}