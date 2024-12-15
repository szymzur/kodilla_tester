public class RandomNumbers {
    private int[] numbers = new int[5000];
    private int index = 0;
    private int sum = 0;

    public void generateNumbers() {
        while (sum <= 5000) {
            int number = (int) (Math.random() * 31);
            if (index < numbers.length) {
                numbers[index] = number;
                index++;
                sum += number;
            } else {
                int[] newNumbers = new int[numbers.length * 2];
                System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
                numbers = newNumbers;
                numbers[index] = number;
                index++;
                sum += number;
            }
        }
    }

    public int getMaxNumber() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < index; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public int getMinNumber() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getIndex() {
        return index;
    }
}
// Użyłem getterów by zwrócić tablice numbers i index, doczytałem, że to lepsza praktyka w programowaniu obiektowym.
//