package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 500);
        Book javaDev = new Book("How to become a java programmer", 123);
        Book computers = new Book("Modern technologies", 234);
        Book recipes = new Book("A great cookbook", 333);

        Book[] books = new Book[]{cleanCode, javaDev, computers, recipes};
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPages());
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPages());
        }

        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getPages());
            }
        }
    }
}
