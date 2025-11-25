package by.innowise.tkachuk.parser;

import java.util.Optional;

public interface Parser {
    Optional<int[]> parseLine(String line);
}
