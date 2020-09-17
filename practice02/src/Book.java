public class Book {
    private String author;
    private String title;
    private int year;
    private String publisher;
    private int countOfPages;

    public String toString() {
        return "Автор   " + author + "\nНазвание    " + title + "\nГод издания  " + year + "\nИздательство  "
                + publisher + "\n Количество страниц    " + countOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }
}
