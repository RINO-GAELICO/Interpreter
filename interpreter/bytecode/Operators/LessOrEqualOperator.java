package interpreter.bytecode.Operators;

public class LessOrEqualOperator extends Operator {

    @Override
    public String toString(){
        return "<=";
    }

    @Override
    public int execute(int operand1, int operand2) {
        
       if(operand1 <= operand2){
           return 1;
       }else{
        return 0;
       }
        
    }
}
