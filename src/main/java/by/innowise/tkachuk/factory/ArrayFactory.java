package by.innowise.tkachuk.factory;

import by.innowise.tkachuk.entity.CustomArray;
import by.innowise.tkachuk.exception.UnexpectedValueException;

public interface ArrayFactory {

    CustomArray create(long id, int[] arr) throws UnexpectedValueException;
}
