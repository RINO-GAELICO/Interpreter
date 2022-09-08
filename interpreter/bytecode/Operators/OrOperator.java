package interpreter.bytecode.Operators;

public class OrOperator extends Operator {

    @Override
    public String toString(){
        return "|";
    }

    @Override
    public int execute(int operand1, int operand2) {
        if(operand1 != 0 || operand2 != 0){
            return 1;
        }else{
            return 0;
        }
    }
    
}
