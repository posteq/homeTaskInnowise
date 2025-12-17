package by.innowise.tkachuk.service;

import by.innowise.tkachuk.exception.UnexpectedValueException;
import by.innowise.tkachuk.entity.CustomArray;

public interface ArrayService {
    int findMinValue(CustomArray arr) throws UnexpectedValueException;
    int findMaxValue(CustomArray arr) throws UnexpectedValueException;
    int findSumValue(CustomArray arr);

    int[] bubbleSort(CustomArray arr);
    int[] sortArraySelection(CustomArray arr);

    double findAvgValue(CustomArray array) throws UnexpectedValueException;
}
