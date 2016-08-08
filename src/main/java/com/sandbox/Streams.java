package com.sandbox;

import static com.google.common.base.Splitter.on;
import static com.google.common.collect.Iterables.getFirst;

import java.util.Objects;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import com.google.common.base.Strings;

public class Streams {

    public static void main(String[] args) {
        // filter null.
        Stream.of("one", null, "three")
              .filter(Objects::nonNull)
              .forEach(System.out::println);

        // filter null or empty.
        Stream.of("one", "two", "three", "", null)
              .filter(StringUtils::isNotBlank)
              .forEach(System.out::println);

        // trim to whole number.
        Stream.of("100.01", "100.1", "100", "", null)
              .map(Strings::nullToEmpty)
              .map(s -> getFirst(on(".").split(s), s))
              .forEach(System.out::println);
    }
}
