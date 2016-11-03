package main.java.ru.naumen.weatherStorage;

public class WrongIdException extends Exception {
    WrongIdException(int id) {
        super(String.format("Can't find item with such id: %d", id));
    }
}
