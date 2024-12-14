public class BookMain {
    public static void main(String[] args) {
        Book book = Book.of("Stanislaw Lem", "Golem XIV");
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Title: " + book.getTitle());
    }
}
