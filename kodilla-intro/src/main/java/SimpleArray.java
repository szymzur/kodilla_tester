public class SimpleArray {
    public static void main(String[] args) {
        String[] footballClubs = new String[5];
        footballClubs[0] = "Athletic";
        footballClubs[1] = "Real Madrid";
        footballClubs[2] = "Barcelona";
        footballClubs[3] = "Valencia";
        footballClubs[4] = "Sevilla";
        String footballClub = footballClubs[3];
        System.out.println(footballClub);
        int numberOfClubs = footballClubs.length;
        System.out.println("My array contains " + numberOfClubs + " elements.");
    }
}
