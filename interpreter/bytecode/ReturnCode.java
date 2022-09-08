package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {

    private String functionName = "";
    private String byteCodeType;
    private int returnedValue;

    @Override
    public void execute(VirtualMachine vm) {
        
        returnedValue = vm.peekStack();
        vm.popFrame();
        vm.setProgramCounter(vm.popStackAddresses()-1);
        return;


    }

    public String getByteCodeType() {
        String tempType = new String(byteCodeType);
        return tempType;
    }

    public String getFunctionName() {
        String tempFuncName = new String(functionName);
        return tempFuncName;
    }

    private void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    @Override
    public void init(Vector<String> args) {

        byteCodeType = args.get(0);
        if (args.toArray().length > 1) {
            setFunctionName(args.get(1));
        }

    }

    @Override
    public String toString() {
        
        String column1Format = "%-25.25s";
        String column2Format = "%s";
        String formatInfo = column1Format + column2Format;
        String commentString;
        String instructionString = getByteCodeType()+" "+getFunctionName();
        if(getFunctionName().length()>0){
            commentString = "exit " + getFunctionName().substring(0,1)+": " +returnedValue;
        }else{
            commentString = "";
        }
        
        
        StringBuilder wholeString = new StringBuilder();
        Formatter fmt = new Formatter(wholeString);
        fmt.format(formatInfo, instructionString, commentString);
        String retString = wholeString.toString();
        fmt.close();
        return retString;
    }


    public String getClassName(){
        return "ReturnCode";
    }
}
