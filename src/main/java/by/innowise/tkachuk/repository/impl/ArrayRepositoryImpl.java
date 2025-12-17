package by.innowise.tkachuk.repository.impl;

import by.innowise.tkachuk.entity.CustomArray;
import by.innowise.tkachuk.repository.ArrayRepository;
import by.innowise.tkachuk.specification.Specification;
import by.innowise.tkachuk.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {

    private final Logger logger = LogManager.getLogger(ArrayRepositoryImpl.class);

    private static ArrayRepository instance;
    private final List<CustomArray> arrays = new ArrayList<>();

    private ArrayRepositoryImpl() {}

    public static ArrayRepository getInstance() {
        if(instance == null) {
            instance = new ArrayRepositoryImpl();
        }
        return instance;
    }

    public void add(CustomArray array) {
        array.subscribe(Warehouse.getInstance());
        arrays.add(array);
        Warehouse.getInstance().update(array);
        logger.info("Was added new customArray with id : {}", array.getId());
    }

    public void remove(CustomArray array) {
        array.unsubscribe(Warehouse.getInstance());
        arrays.remove(array);
        logger.info("Was deleted customArray with id : {}", array.getId());
    }

    public List<CustomArray> findBySpecification(Specification specification) {
        List<CustomArray> result = new ArrayList<>();
        for(CustomArray array : arrays) {
            if(specification.isSatisfiedBy(array)){
                result.add(array);
            }
        }
        return result;
    }

    @Override
    public List<CustomArray> sort(Comparator<CustomArray> comparator) {
        List<CustomArray> result = new ArrayList<>(arrays);
        result.sort(comparator);
        return result;
    }

    @Override
    public void clear(){
        arrays.clear();
    }
}
