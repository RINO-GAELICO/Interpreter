package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.VirtualMachine;

public class WriteCode extends ByteCode {

    private String byteCodeType;

    @Override
    public void execute(VirtualMachine vm) {
        
        System.out.println(vm.peekStack());
        
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
        return "WriteCode";
    }
    
}
