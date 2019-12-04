package camp.nextstep.edu.moviebooking;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
