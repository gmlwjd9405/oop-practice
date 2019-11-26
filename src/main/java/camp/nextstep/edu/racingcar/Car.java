package camp.nextstep.edu.racingcar;

public class Car {

    public static final int DEFAULT_POSITION = 0;
    public static final int LENGTH_OF_NAME = 5;

    private final String name;
    private int position;

    Car(final String name) {
        this(name, DEFAULT_POSITION);
    }

    Car(final String name, final int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position++;
        }
    }

    boolean isInPosition(final int position) {
        return this.position == position;
    }

    private void validate(final String name) {
        if (name == null || name.length() > LENGTH_OF_NAME) {
            throw new IllegalArgumentException();
        }
    }
}
