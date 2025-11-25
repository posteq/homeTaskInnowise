package by.innowise.tkachuk.parser.impl;

import by.innowise.tkachuk.exception.UnexpectedValueException;
import by.innowise.tkachuk.factory.ArrayFactory;
import by.innowise.tkachuk.factory.impl.DefaultArrayFactory;
import by.innowise.tkachuk.parser.Parser;
import by.innowise.tkachuk.validator.ArrayValidator;
import by.innowise.tkachuk.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;

public class ParserImpl implements Parser {

    private static final String REGEX_INTEGER = "-?\\d+";

    private final Logger logger = LogManager.getLogger(ParserImpl.class);
    private final ArrayFactory factory = new DefaultArrayFactory();
    private final ArrayValidator validator = new ArrayValidatorImpl();

    public Optional<int[]> parseLine(String line){
        try {
            if (validator.isValid(line)){
                throw new UnexpectedValueException("Invalid line");
            }
            String[] data = line.split(";");
            int[] arr = Arrays.stream(data)
                    .map(String::trim)
                    .filter(this::isInteger)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            logger.info("Was add - {} elements", arr.length);
            return Optional.of(arr);
        } catch (UnexpectedValueException e) {
            logger.info("Error during adding in array - {}",e.getMessage());
            return Optional.empty();
        }
    }

    private boolean isInteger(String value){
        return value.matches(REGEX_INTEGER);
    }
}
