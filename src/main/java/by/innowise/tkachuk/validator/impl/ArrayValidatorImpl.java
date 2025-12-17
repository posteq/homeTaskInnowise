package by.innowise.tkachuk.validator.impl;

import by.innowise.tkachuk.validator.ArrayValidator;

public class ArrayValidatorImpl implements ArrayValidator {
    @Override
    public boolean isValid(String line) {
        return !(line.strip()).isBlank();
    }
}
