package interpreter.bytecode.Operators;


public class DivisionOperator extends Operator{

    @Override
    public int execute(int operand1, int operand2) {
        return operand1 / operand2 ;
    }

    @Override
    public String toString() {
        return "/";
    }


}
