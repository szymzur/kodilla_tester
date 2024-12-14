public class Notebook {
    int weight;
    int price;
    int year;

    public Notebook(int weight, int price, int year) {
        this.weight = weight;
        this.price = price;
        this.year = year;
    }

    public void checkPrice() {
        if (this.price < 900) {
            System.out.println("This notebook is cheap.");
        } else {
            System.out.println("This notebook is quite expensive.");
        }
    }

    public void checkYear() {
        if (this.year < 2015) {
            System.out.println("This is an old notebook.");
        } else {
            System.out.println("This is a quite new notebook.");
        }
    }

    public void checkWeight() {
        if (this.weight > 1500) {
            System.out.println("This is a heavy notebook.");
        } else {
            System.out.println("This is a light notebook.");
        }
    }
}
