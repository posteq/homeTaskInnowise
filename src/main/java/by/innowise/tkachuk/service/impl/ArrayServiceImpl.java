package by.innowise.tkachuk.service.impl;

import by.innowise.tkachuk.exception.UnexpectedValueException;
import by.innowise.tkachuk.entity.CustomArray;
import by.innowise.tkachuk.service.ArrayService;

import java.util.Arrays;

public class ArrayServiceImpl implements ArrayService{

    @Override
    public int findMinValue(CustomArray customArray) throws UnexpectedValueException {
        return Arrays.stream(customArray.getArray())
                .min()
                .orElseThrow(() -> new UnexpectedValueException("Array is empty"));
    }

    @Override
    public int findMaxValue(CustomArray customArray) throws UnexpectedValueException {
        return Arrays.stream(customArray.getArray())
                .max()
                .orElseThrow(() -> new UnexpectedValueException("Array is empty"));
    }

    @Override
    public int findSumValue(CustomArray customArray) {
        return Arrays.stream(customArray.getArray())
                .sum();
    }

    @Override
    public int[] bubbleSort(CustomArray arr) {
        int[] copy = Arrays.copyOf(arr.getArray(), arr.getArray().length);
        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = 0; j < copy.length - i - 1; j++) {
                if (copy[j] > copy[j + 1]) {
                    int tmp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = tmp;
                }
            }
        }
        return copy;
    }

    @Override
    public int[] sortArraySelection(CustomArray arr) {
        int[] copy = Arrays.copyOf(arr.getArray(), arr.getArray().length);
        for (int i = 0; i < copy.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j]< copy[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = copy[i];
            copy[i] = copy[minIndex];
            copy[minIndex] = tmp;
        }
        return copy;
    }

    @Override
    public double findAvgValue(CustomArray array) throws UnexpectedValueException {
        try {
            return (double) this.findSumValue(array) /array.getLength();
        }catch (Exception e) {
            throw new UnexpectedValueException(e.getMessage());
        }
    }
}
