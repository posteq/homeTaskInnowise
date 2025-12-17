package by.innowise.tkachuk.warehouse;

import by.innowise.tkachuk.entity.ArrayData;
import by.innowise.tkachuk.entity.CustomArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarehouseTest {

    @Test
    void shouldRecalculateStatistic_whenElementChanged(){
        //given
        CustomArray customArray = new CustomArray(0, new int[]{1, 20, 80, 68});
        Warehouse instance = Warehouse.getInstance();
        customArray.subscribe(instance);
        instance.update(customArray);

        //when
        customArray.setElement(0,100);

        //then
        ArrayData arrayData = instance.getArrayData(0);
        assertEquals(100,arrayData.max());
        assertEquals(20,arrayData.min());
        assertEquals(67,arrayData.avg());
        assertEquals(268,arrayData.sum());
    }

}