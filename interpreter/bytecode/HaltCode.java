package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.VirtualMachine;

public class HaltCode extends ByteCode{

    private boolean stopMachine;
    private String byteCodeType;

    @Override
    public void execute(VirtualMachine vm) {
        vm.setIsRunning(stopMachine);
        
    }

    public String getByteCodeType() {
        String tempType = new String(byteCodeType);
        return tempType;
    }


    @Override
    public void init(Vector<String> args) {

        byteCodeType = args.get(0);
        stopMachine = false;
        
    }

    @Override
    public String toString(){
        String column1Format = "%-25.25s";

        String formatInfo = column1Format;

        String instructionString = getByteCodeType();
        
        StringBuilder wholeString = new StringBuilder();
        Formatter fmt = new Formatter(wholeString);
        fmt.format(formatInfo, instructionString);
        String retString = wholeString.toString();
        fmt.close();
        return retString;
    }

    public String getClassName(){
        return "HaltCode";
    }
    
}
