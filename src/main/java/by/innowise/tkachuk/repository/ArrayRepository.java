package by.innowise.tkachuk.repository;

import by.innowise.tkachuk.entity.CustomArray;
import by.innowise.tkachuk.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {

    void add(CustomArray array);

    void remove(CustomArray array);

    List<CustomArray> findBySpecification(Specification specification);

    List<CustomArray> sort(Comparator<CustomArray> comparator);

    void clear();
}
