package camp.nextstep.edu.calculator2.operation;

@FunctionalInterface
public interface OperationStrategy {
    int operate(int operandA, int operandB);
}

