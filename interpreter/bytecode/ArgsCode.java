package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {

    private int numberArgs;
    private String byteCodeType;
    

    @Override
    public void execute(VirtualMachine vm) {
       
        vm.newFrameAt(getNumberArgs());
        vm.setArgsFunction(getNumberArgs());
        return;
  
    }

    public int getNumberArgs() {
        int tempNumbArgs = numberArgs;
        return tempNumbArgs;
    }

    private void setNumberArgs(int numberArgs) {
        this.numberArgs = numberArgs;
    }

    public String getByteCodeType() {
        
        String tempType = new String(byteCodeType);
        return tempType;
    }

    @Override
    public void init(Vector<String> args) {

        byteCodeType = args.get(0);
        setNumberArgs(Integer.parseInt(args.get(1)));
        
    }

    @Override
    public String toString(){
        
        String column1Format = "%-25.25s";

        String formatInfo = column1Format;

        String instructionString = getByteCodeType()+" "+getNumberArgs();
        
        StringBuilder wholeString = new StringBuilder();
        Formatter fmt = new Formatter(wholeString);
        fmt.format(formatInfo, instructionString);
        String retString = wholeString.toString();
        fmt.close();
        return retString;
    }

    public String getClassName(){
        return "ArgsCode";
    }

    
}
