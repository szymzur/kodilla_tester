public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        User[] users = new User[5];
        users[0] = new User("Steven", 42);
        users[1] = new User("Anna", 30);
        users[2] = new User("Jenny", 29);
        users[3] = new User("David", 28);
        users[4] = new User("Ben", 38);

        double sum = 0;
        for (User user : users) {
            sum += user.getAge();
        }
        double averageAge = sum / users.length;

        System.out.println("Users whose age is below average (" + averageAge + "):");
        for (User user : users) {
            if (user.getAge() < averageAge) {
                System.out.println(user.getName());
            }
        }
    }
}