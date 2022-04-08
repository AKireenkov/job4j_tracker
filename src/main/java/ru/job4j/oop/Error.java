package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printError() {
        System.out.println("error is active? " + active);
        System.out.println("error status: " + status);
        System.out.println("error message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 500, "this computer is broken");
        error.printError();
        Error notError = new Error(false, 200, "there is no error");
        notError.printError();
    }
}
