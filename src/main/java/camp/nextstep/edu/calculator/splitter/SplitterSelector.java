package camp.nextstep.edu.calculator.splitter;

public class SplitterSelector {

    // TODO check Splitter 를 List<Splitter> 로 관리할지
    private Splitter splitter;

    public static SplitterSelector of() {
        return new SplitterSelector();
    }

    private SplitterSelector() {
        this.splitter = new CustomSplitter();
    }

    // TODO check DefaultSplitter 의 supports 검사
    public Splitter matchedSplitter(String value) {
        if (splitter.supports(value)) {
            return this.splitter;
        }
        return new DefaultSplitter();
    }
}
