public class RandomNumbersMain {
    public static void main(String[] args) {
        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.generateNumbers();

        System.out.print("Random numbers: ");
        for (int i = 0; i < randomNumbers.getIndex(); i++) {
            System.out.print(randomNumbers.getNumbers()[i] + " ");
        }
        System.out.println();

        System.out.println("The greatest number: " + randomNumbers.getMaxNumber());
        System.out.println("The smallest number: " + randomNumbers.getMinNumber());
    }
}