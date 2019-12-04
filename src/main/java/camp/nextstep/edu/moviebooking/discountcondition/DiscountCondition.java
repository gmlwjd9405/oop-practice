package camp.nextstep.edu.moviebooking.discountcondition;

import camp.nextstep.edu.moviebooking.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
