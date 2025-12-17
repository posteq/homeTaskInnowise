package by.innowise.tkachuk.reader;

import by.innowise.tkachuk.exception.UnexpectedValueException;
import by.innowise.tkachuk.reader.impl.ReaderImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReaderImplTest {

    @Test
    void shouldReadFromTxt() throws UnexpectedValueException {
        //given
        String path = "src/test/inputData/testStudentInfo.txt";

        List<String> expected = List.of(
                "1;10;-5",
                "-5;Sergo;7",
                "0;3",
                "{empty info}",
                "3.0;-0.1;59",
                "99;78;100;-0;-19312",
                "20; q; 20",
                "{empty info}",
                "3;Vera;59",
                "2;Vera;59.1"
        );

        Reader reader = new ReaderImpl();
        //when
        List<String> actual = reader.read(path);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void shouldThrowWhenPathInvalid() {
        //given
        Reader reader = new ReaderImpl();

        //then
        assertThrows(UnexpectedValueException.class, () -> {reader.read("UncknowPath");});
    }
}