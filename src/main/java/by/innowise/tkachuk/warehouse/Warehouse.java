package by.innowise.tkachuk.warehouse;

import by.innowise.tkachuk.entity.ArrayData;
import by.innowise.tkachuk.entity.CustomArray;
import by.innowise.tkachuk.exception.UnexpectedValueException;
import by.innowise.tkachuk.observer.Observer;
import by.innowise.tkachuk.service.ArrayService;
import by.innowise.tkachuk.service.impl.ArrayServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse implements Observer {

    private final Logger logger = LogManager.getLogger(Warehouse.class);

    private static Warehouse INSTANCE;
    private final Map<Long, ArrayData> storage ;
    private final ArrayService service ;

    private Warehouse() {
        storage = new HashMap<>();
        service = new ArrayServiceImpl();
    }

    public static Warehouse getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Warehouse();
        }
        return INSTANCE;
    }

    @Override
    public void update(CustomArray array) {
        try {
            storage.put(array.getId(), calculateArrayData(array));
        } catch (UnexpectedValueException e) {
            logger.error(e.getMessage());
        }
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
            throw new UnexpectedValueException(e.getMessage());
        }
    }
}
