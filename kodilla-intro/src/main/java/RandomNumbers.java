import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers {
    private List<Integer> numbers = new ArrayList<>();
    private Random random = new Random();
    private int sum = 0;

    // Metoda losująca liczby do momentu przekroczenia sumy 5000
    public void generateNumbers() {
        while (sum <= 5000) {
            int number = random.nextInt(31); // Losuje liczbę z zakresu 0-30 (31 nie jest włączone)
            numbers.add(number);
            sum += number;
        }
    }

    // Metoda zwracająca największą wylosowaną wartość
    public int getMaxNumber() {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    // Metoda zwracająca najmniejszą wylosowaną wartość
    public int getMinNumber() {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.generateNumbers();
        System.out.println("Random numbers: " + randomNumbers.numbers);
        System.out.println("The highest number: " + randomNumbers.getMaxNumber());
        System.out.println("The lowest number: " + randomNumbers.getMinNumber());
    }
}
