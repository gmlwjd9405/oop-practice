package camp.nextstep.edu.caculator2.operation;

@FunctionalInterface
public interface OperationStrategy {
    int operate(int operandA, int operandB);
}

