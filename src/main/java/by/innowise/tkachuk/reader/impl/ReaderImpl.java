package by.innowise.tkachuk.reader.impl;

import by.innowise.tkachuk.exception.UnexpectedValueException;
import by.innowise.tkachuk.reader.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReaderImpl implements Reader {
    private final Logger logger = LogManager.getLogger(ReaderImpl.class);

    public List<String> read(String path) throws UnexpectedValueException {
        try (Stream<String> lines = Files.lines(Paths.get(path))){
            return lines.filter(line -> !line.isBlank())
                    .map(String::strip)
                    .toList();
        } catch (IOException e) {
            logger.error("{} - file not found", e.getMessage());
            throw new UnexpectedValueException(e.getMessage() + " - file not found");
        }
    }
}
