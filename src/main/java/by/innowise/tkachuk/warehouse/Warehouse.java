package by.innowise.tkachuk.warehouse;

import by.innowise.tkachuk.entity.ArrayData;
import by.innowise.tkachuk.entity.CustomArray;
import by.innowise.tkachuk.exception.UnexpectedValueException;
import by.innowise.tkachuk.observer.Observer;
import by.innowise.tkachuk.service.ArrayService;
import by.innowise.tkachuk.service.impl.ArrayServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class Warehouse implements Observer {

    private static Warehouse INSTANCE;
    private Map<Long, ArrayData> storage = new HashMap<>();
    private ArrayService service = new ArrayServiceImpl();

    private Warehouse() {}

    public static Warehouse getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Warehouse();
        }
        return INSTANCE;
    }

    @Override
    public void update(CustomArray array) throws UnexpectedValueException {
        storage.put(array.getId(), calculateArrayData(array));
    }

    public ArrayData getArrayData(long id) {
        return storage.get(id);
    }

    private ArrayData calculateArrayData(CustomArray array) throws UnexpectedValueException {
        try {
            int sum = service.findSumValue(array);
            int max = service.findMaxValue(array);
            int min = service.findMinValue(array);
            double avg = service.findAvgValue(array);
            return new ArrayData(max,min,avg,sum);
        }catch (Exception e) {
            throw new UnexpectedValueException("Throw became calculate data of array");
        }
    }
}
