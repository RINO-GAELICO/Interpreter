package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {

    private int levelsToPop;
    private String byteCodeType;


    @Override
    public void execute(VirtualMachine vm) {
        // Pop top n levels of the runtime stack
        for (int i=0; i<getLevelsToPop(); i++){
            vm.popStack();
        }
        return;
        
    }

    public String getByteCodeType() {
        String tempType = new String(byteCodeType);
        return tempType;
    }

    private void setByteCodeType(String byteCodeType) {
        this.byteCodeType = byteCodeType;
    }

    @Override
    public void init(Vector<String> args) {

        setByteCodeType(args.get(0));
        levelsToPop = Integer.parseInt(args.get(1));
        
    }

    public int getLevelsToPop(){
        int tempLevels = levelsToPop;
        return tempLevels;
    }

    @Override
    public String toString(){
        String column1Format = "%-25.25s";

        String formatInfo = column1Format;

        String instructionString = getByteCodeType()+" "+getLevelsToPop();
        
        StringBuilder wholeString = new StringBuilder();
        Formatter fmt = new Formatter(wholeString);
        fmt.format(formatInfo, instructionString);
        String retString = wholeString.toString();
        fmt.close();
        return retString;
    }

    public String getClassName(){
        return "PopCode";
    }
    
}
