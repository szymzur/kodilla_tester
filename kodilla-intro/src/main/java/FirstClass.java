public class FirstClass {
    public static void main(String[] args) {
        class Notebook {
            int weight;
            int price;
            int year;

            public Notebook(int weight, int price, int year) {
                this.weight = weight;
                this.price = price;
                this.year = year;
            }

            public void checkPrice() {
                if (this.price <= 600) {
                    System.out.println("This notebook is very cheap.");
                } else if (this.price >= 1000) {
                    System.out.println("The notebook is expensive.");
                } else {
                    System.out.println("The price is good.");
                }
            }

            public void checkWeight() {
                if (this.weight <= 1000) {
                    System.out.println("This notebook is light.");
                } else if (this.weight >= 2000) {
                    System.out.println("The notebook is heavy.");
                } else {
                    System.out.println("The notebook is not so heavy.");
                }
            }

            public void checkYear() {
                if (this.year <= 2018 && this.price >= 600) {
                    System.out.println("This notebook is too expensive for its year of production.");
                } else if (this.year <= 2022 && this.price < 1000) {
                    System.out.println("The notebook is suspiciously cheap for its year of production.");
                } else if (this.year <= 2022 && this.price >= 1200) {
                    System.out.println("The notebook is expensive but probably has a good processor.");
                } else {
                    System.out.println("The notebook is not so heavy.");
                }
            }

            Notebook notebook = new Notebook(600, 1000, 2024);
System.out.println(" "+notebook.weight +" "+notebook.price);
notebook.checkPrice();
notebook.checkWeight();
notebook.checkYear();

            Notebook heavyNotebook = new Notebook(2000, 1500, 2020);
System.out.println(heavyNotebook.weight +" "+heavyNotebook.price);
heavyNotebook.checkPrice();
heavyNotebook.checkWeight();
heavyNotebook.checkYear();

            Notebook oldNotebook = new Notebook(1600, 500, 2015);
System.out.println(oldNotebook.weight +" "+oldNotebook.price);
oldNotebook.checkPrice();
oldNotebook.checkWeight();
oldNotebook.checkYear();
        }
    }
}
