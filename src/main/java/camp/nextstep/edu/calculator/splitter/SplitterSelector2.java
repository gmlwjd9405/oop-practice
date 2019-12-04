package camp.nextstep.edu.calculator.splitter;

import java.util.Arrays;
import java.util.List;

public class SplitterSelector2 {

    private List<Splitter> splitters;

    public static SplitterSelector2 of() {
        return new SplitterSelector2();
    }

    private SplitterSelector2() {
        this(new CustomSplitter(), new CommaAndColonSplitter());
    }

    private SplitterSelector2(Splitter ... splitters) {
        this.splitters = Arrays.asList(splitters);
    }

    public Splitter matchedSplitter(String value) {
        return splitters.stream()
                .filter(splitter -> splitter.supports(value))
                .findFirst()
                .orElse(new CommaAndColonSplitter());
    }
}
