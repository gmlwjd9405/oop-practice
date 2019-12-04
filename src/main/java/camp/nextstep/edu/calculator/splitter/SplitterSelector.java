package camp.nextstep.edu.calculator.splitter;

public class SplitterSelector {

    private Splitter splitter;

    public static SplitterSelector of() {
        return new SplitterSelector();
    }

    private SplitterSelector() {
        this.splitter = new CustomSplitter();
    }

    public Splitter matchedSplitter(String value) {
        if (splitter.supports(value)) {
            return this.splitter;
        }
        return new CommaAndColonSplitter();
    }
}
