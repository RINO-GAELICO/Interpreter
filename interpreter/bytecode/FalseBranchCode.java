package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.TargetBranch;
import interpreter.VirtualMachine;

public class FalseBranchCode extends ByteCode implements TargetBranch{

    private String label;
    private String byteCodeType;
    private int address;


    @Override
    public void execute(VirtualMachine vm) {
        // Pop the top of the stack; if it’s false (0) then branch to <label>, 
        // else execute the next byte code
        int falseBool = vm.popStack();
        if(falseBool == 0){
            vm.setProgramCounter(address-1);
        }
        return;
        
    }

    public int getAddress() {
        int tempAddress = this.address;
        return tempAddress;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getByteCodeType() {
        String tempType = new String(byteCodeType);
        return tempType;
    }

    private void setByteCodeType(String byteCodeType) {
        this.byteCodeType = byteCodeType;
    }

    public String getLabel() {
        String tempLabel = new String(label);
        return tempLabel;
    }

    public void setLabelToBranch(String label) {
        this.label = label;
    }

    @Override
    public void init(Vector<String> args) {

        setByteCodeType(args.get(0));
        setLabelToBranch(args.get(1));
        
    }

    @Override
    public String toString(){
        String column1Format = "%-25.25s";

        String formatInfo = column1Format;

        String instructionString = getByteCodeType()+" "+getLabel();
        
        StringBuilder wholeString = new StringBuilder();
        Formatter fmt = new Formatter(wholeString);
        fmt.format(formatInfo, instructionString);
        String retString = wholeString.toString();
        fmt.close();
        return retString;
    }

    public String getClassName(){
        return "FalseBranchCode";
    }
    


    
}
