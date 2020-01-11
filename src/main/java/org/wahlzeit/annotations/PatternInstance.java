package org.wahlzeit.annotations;
import java.lang.annotation.Repeatable;

/*
- allows file-based annotations (multiple occurences per file) of the following scheme:
@PatternInstance(
    patternName = "FOO",
    participants = {"BAR", "BAZ"}
)
*/

@Repeatable(PatternInstance.List.class)
public @interface PatternInstance {
    String patternName();
    String[] participants();

    @interface List {
        PatternInstance[] value();
    }
}