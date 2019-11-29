package camp.nextstep.edu.calculator.splitter;

public interface Splitter {

    String[] EMPTY_ARRAY = new String[0];

    boolean supports(String value);
    String[] split(String value);
}
