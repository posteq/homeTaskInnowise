package by.innowise.tkachuk.repository;

import by.innowise.tkachuk.comparator.IdComparator;
import by.innowise.tkachuk.entity.CustomArray;
import by.innowise.tkachuk.repository.impl.ArrayRepositoryImpl;
import by.innowise.tkachuk.specification.impl.CompareOperation;
import by.innowise.tkachuk.specification.impl.SearchSpecification;
import by.innowise.tkachuk.specification.impl.SearchType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRepositoryImplTest {

    @BeforeEach
    void setUp(){
        ArrayRepositoryImpl.getInstance().clear();
    }


    @Test
    void shouldAddAndDeleteArrayInRepository_AndSearchBySpecification(){
        //given
        ArrayRepository repository = ArrayRepositoryImpl.getInstance();
        CustomArray array1 = new CustomArray(0, new int[]{0, 1, 4, 3});
        CustomArray array2 = new CustomArray(1, new int[]{30, 10, 9, 7});
        CustomArray array3 = new CustomArray(2, new int[]{6530, 1, 8000, 3});

        List<CustomArray> expected = List.of(array2,array3);
        List<CustomArray> expectedWithoutArray3 = List.of(array2);

        //when
        repository.add(array1);
        repository.add(array2);
        repository.add(array3);

        //then
        List<CustomArray> actual1 = repository.findBySpecification(new SearchSpecification(
                                                                            SearchType.SUM,
                                                                            CompareOperation.GREATER,
                                                                            10));
        assertEquals(actual1,expected);

        repository.remove(array3);

        List<CustomArray> actual2 = repository.findBySpecification(new SearchSpecification(
                                                                            SearchType.SUM,
                                                                            CompareOperation.GREATER,
                                                                            10));

        assertEquals(actual2,expectedWithoutArray3);
    }

    @Test
    void shouldSortArrayById(){
        //given
        ArrayRepository repository = ArrayRepositoryImpl.getInstance();
        CustomArray array1 = new CustomArray(2, new int[]{0, 1, 4, 3});
        CustomArray array2 = new CustomArray(3, new int[]{30, 10, 9, 7});
        CustomArray array3 = new CustomArray(1, new int[]{6530, 1, 8000, 3});

        List<CustomArray> expected = List.of(array3,array1,array2);

        repository.add(array1);
        repository.add(array2);
        repository.add(array3);

        //when
        List<CustomArray> actual = repository.sort(new IdComparator());

        //then

        System.out.println(actual);
        System.out.print(expected);
        assertEquals(actual,expected);
    }

}