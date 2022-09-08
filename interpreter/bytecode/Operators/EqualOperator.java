package interpreter.bytecode.Operators;

public class EqualOperator extends Operator {

    @Override
    public int execute( int operand1, int operand2 ) {
        if(operand1 == operand2){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString(){
        return "==";
    }
}
