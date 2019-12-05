package camp.nextstep.edu.moviebooking.discountcondition;

import camp.nextstep.edu.moviebooking.Screening;
import camp.nextstep.edu.moviebooking.discountcondition.DiscountCondition;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }
}
