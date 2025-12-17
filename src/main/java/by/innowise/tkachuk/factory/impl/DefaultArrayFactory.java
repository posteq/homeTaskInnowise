package by.innowise.tkachuk.factory.impl;

import by.innowise.tkachuk.entity.CustomArray;
import by.innowise.tkachuk.exception.UnexpectedValueException;
import by.innowise.tkachuk.factory.ArrayFactory;

public class DefaultArrayFactory implements ArrayFactory {

    @Override
    public CustomArray create(long id, int[] arr) throws UnexpectedValueException {
        if (arr == null || arr.length == 0) {
            throw new UnexpectedValueException("Invalid value of a new array , length is - " + arr.length);
        }
        return new CustomArray(id,arr);
    }
}
