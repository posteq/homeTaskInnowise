package by.innowise.tkachuk.observer;

import by.innowise.tkachuk.entity.CustomArray;
import by.innowise.tkachuk.exception.UnexpectedValueException;

public interface Observer {
    public void update(CustomArray customArray) throws UnexpectedValueException;
}
