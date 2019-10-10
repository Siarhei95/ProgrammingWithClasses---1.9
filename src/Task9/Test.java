//Создать класс  Book, спецификация которого приведена ниже. Определить конструкторы,  set-  и  get-  методы и
//метод  toString(). Создать второй класс, агрегирующий массив типа  Book, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
//Найти и вывести:
//a) список книг заданного автора;
//b) список книг, выпущенных заданным издательством;
//c) список книг, выпущенных после заданного года.

package Task9;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Shop bookShop = new Shop("Book");
        bookShop.addBookList(new Book("Maстер и Маргарита", "Булгаков", "Москва", 1937, 165, 54,"Твердый"));
        bookShop.addBookList(new Book("Евгений Онегин","Пушкин","Питер",1831,56,53,"Мягкий"));
        bookShop.addBookList(new Book("Преступление и наказание","Достоевский","Москва",1866,213,65,"Мягкий"));
        bookShop.addBookList(new Book("Война и мир","Толстой", "Тверь",1867,654,121,"Твердый"));
        bookShop.addBookList(new Book("Собачье сердце", "Булгаков","Питер",1825,68,75, "Твердый"));
        bookShop.addBookList(new Book("Борис Годунов", "Пушкин","Москва",1831, 169,89,"Твердый"));
        bookShop.addBookList(new Book("Герой нашего времени","Лермонтов","Воронеж",1840, 532, 176, "Твердый"));
        bookShop.addBookList(new Book("Гарри Поттер", "Роулинг","Англия",1997, 425, 234,"Мягкий"));

        System.out.print("Enter the name of author(фамилия автора с большой буквы на русском языке): ");
        List<Book> listFindAuthor = bookShop.getAuthors();


        System.out.print("\nEnter the name of publishing house(название издательства с большой буквы на русском языке): ");


        System.out.print("\nEnter the date from which to search: ");
        List<Book> listSortByDiapazon = bookShop.getListByDiapason();
        for (Book c : listSortByDiapazon) {
            System.out.println(c);
        }

    }
}

class Shop {
    private String bookName;
    private ArrayList<Book> bookList = new ArrayList<>();

    Shop(String bookName) {
        this.bookName = bookName;
    }

    void addBookList(Book book) {
        bookList.add(book);
    }


    List<Book> getAuthors() {
        Scanner scanner = new Scanner(System.in);
        String finder = scanner.next();
        List<Book> list = new ArrayList<>(bookList);
        for (Book c : bookList) {
            if (c.getAuthor().equals(finder)) {
                list.add(c);
                System.out.println(c.getAuthor() + ": " + c.getName() + " - " + c.yearOfPublishing());
            }
        }
        return list;
    }

    List<Book> getPublishingHouse() {
        Scanner scanner = new Scanner(System.in);
        String finder2 = scanner.next();
        List<Book> list = new ArrayList<>(bookList);
        for (Book c : bookList) {
            if (c.getPublishingHouse().equals(finder2)) {
                list.add(c);
                System.out.println(c.getPublishingHouse() + ": " + c.getName()+ " - " + c.getAuthor());
            }
        }
        return list;
    }

    List<Book> getListByDiapason() {
        List<Book> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int finder3 = scanner.nextInt();
        for (Book c : bookList) {
            if (c.yearOfPublishing() >= finder3) {
                list.add(c);
            }
        }
        System.out.println("\nAll book information from "+finder3+" onwards:");
        return list;
    }
}

class Book {
    {
        idGenerator++;
    }

    private static int idGenerator = 0;
    private int id = idGenerator;
    private String name;
    private String author;
    private String publishingHouse;
    private int yearOfPublishing;
    private int numberOfPages;
    private int prise;
    private String bindingType;

    Book(String name, String author, String publishingHouse, int yearOfPublishing, int numberOfPages, int prise, String bindingType) {
        this.name = name;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.prise = prise;
        this.bindingType = bindingType;
    }
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public int yearOfPublishing() {
        return yearOfPublishing;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getPrise() {
        return prise;
    }

    public String getBindingType() {
        return bindingType;
    }

    public String toString() {
        return String.format("ID: %d\t name: %s\t author: %s\t publishingHouse: %s \t yearOfPublishing: %s\t numberOfPages: %d\t prise: %d\t bindingType: %s\t",
                id, name, author, publishingHouse, yearOfPublishing, numberOfPages, prise, bindingType);
    }
}