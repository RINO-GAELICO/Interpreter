package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {

    private int storePosition, topStack;
    private String variableName;
    private String byteCodeType;

    @Override
    public void execute(VirtualMachine vm) {

        topStack = vm.storeStack(getStorePosition());
    }

    public String getByteCodeType() {
        String tempType = new String(byteCodeType);
        return tempType;
    }

    private void setByteCodeType(String byteCodeType) {
        this.byteCodeType = byteCodeType;
    }

    public String getVariableName() {
        String tempVarName = new String(variableName);
        return tempVarName;
    }

    private void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public int getStorePosition() {
        int tempStorePosition = storePosition;
        return tempStorePosition;
    }

    private void setStorePosition(int storePosition) {
        this.storePosition = storePosition;
    }

    private int getTopStack() {
        int tempTop = topStack;
        return tempTop;
    }

    @Override
    public void init(Vector<String> args) {

        setByteCodeType(args.get(0));
        setStorePosition(Integer.parseInt(args.get(1)));
        setVariableName(args.get(2));

    }

    @Override
    public String toString() {
        
        String column1Format = "%-25.25s";
        String column2Format = "%s";
        String formatInfo = column1Format + column2Format;

        String instructionString = getByteCodeType()+" "+getStorePosition()+" "+getVariableName();
        String commentString = getVariableName()+ " = " + getTopStack();
        
        StringBuilder wholeString = new StringBuilder();
        Formatter fmt = new Formatter(wholeString);
        fmt.format(formatInfo, instructionString, commentString);
        String retString = wholeString.toString();
        fmt.close();
        return retString;
    }

    public String getClassName(){
        return "StoreCode";
    }
}
