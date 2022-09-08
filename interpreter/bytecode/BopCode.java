package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.VirtualMachine;
import interpreter.bytecode.Operators.*;

public class BopCode extends ByteCode {

    private String binaryOperation;
    private String byteCodeType;


    @Override
    public void execute(VirtualMachine vm) {
        // Pop top 2 levels of the stack and perform the indicated operation (+ - / * == != <= > >= < | &)
        // The lower level in the stack is the first operand
        int operand2 = vm.popStack();
        int operand1 = vm.popStack();
        int result = Operator.retrieveOperator(binaryOperation).execute(operand1, operand2);
        vm.pushStack(result);
        return;
        
    }

    public String getBinaryOperation() {
        String tempOperation = new String(binaryOperation);
        return tempOperation;
    }

    private void setBinaryOperation(String binaryOperation) {
        this.binaryOperation = binaryOperation;
    }

    public String getByteCodeType() {
        String tempType = byteCodeType;
        return tempType;
    }

    private void setByteCodeType(String byteCodeType) {
        this.byteCodeType = byteCodeType;
    }

    @Override
    public void init(Vector<String> args) {
        
        setByteCodeType(args.get(0));
        setBinaryOperation(args.get(1));
        
    }

    @Override
    public String toString(){
        
        String column1Format = "%-25.25s";

        String formatInfo = column1Format;

        String instructionString = getByteCodeType()+" "+getBinaryOperation();
        
        StringBuilder wholeString = new StringBuilder();
        Formatter fmt = new Formatter(wholeString);
        fmt.format(formatInfo, instructionString);
        String retString = wholeString.toString();
        fmt.close();
        return retString;
    }

    public String getClassName(){
        return "BopCode";
    }
    
}
