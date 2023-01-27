class Book {

    // class attributes
    String author;
    String title;
    int year;

    // constructor
    Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    // methods
    String getAuthor() {
        return this.author;
    }
    String getTitle() {
        return this.title;
    }
}
