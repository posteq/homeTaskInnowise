package by.innowise.tkachuk.reader;

import by.innowise.tkachuk.exception.UnexpectedValueException;

import java.util.List;

public interface Reader {
    List<String> read(String path) throws UnexpectedValueException;
}
