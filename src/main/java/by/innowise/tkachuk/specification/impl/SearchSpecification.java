package by.innowise.tkachuk.specification.impl;

import by.innowise.tkachuk.entity.ArrayData;
import by.innowise.tkachuk.entity.CustomArray;
import by.innowise.tkachuk.specification.Specification;
import by.innowise.tkachuk.warehouse.Warehouse;

public class SearchSpecification implements Specification {

    private final SearchType type;
    private final CompareOperation operation;
    private final double value;

    public SearchSpecification(SearchType type, CompareOperation operation, double value) {
        this.type = type;
        this.operation = operation;
        this.value = value;
    }

    @Override
    public boolean isSatisfiedBy(CustomArray array) {
        ArrayData data = Warehouse.getInstance().getArrayData(array.getId());
        double v = getValue(data, array);
        return switch (operation){
            case EQUAL -> v == value;
            case GREATER -> v > value;
            case LESS -> v < value;
        };
    }

    private double getValue(ArrayData data,CustomArray array) {
        return switch (type) {
            case AVG -> data.avg();
            case MAX -> data.max();
            case MIN -> data.min();
            case SUM -> data.sum();
            case COUNT -> array.getLength();
        };
    }
}
