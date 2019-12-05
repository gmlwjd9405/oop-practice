package camp.nextstep.edu.moviebooking;

import camp.nextstep.edu.moviebooking.discountcondition.DiscountCondition;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Movie(String title, Duration runningTime, Money fee,
                 DiscountCondition ... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();

    protected Money getFee() {
        return fee;
    }

//    private Money calculateAmountDiscountedFee() {
//        return discountAmount;
//    }
//
//    private Money calculatePercentDiscountedFee() {
//        return fee.times(discountPercent);
//    }
//
//    private Money calculateNoneDiscountedFee() {
//        return Money.ZERO;
//    }
}
