package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.VirtualMachine;

public class LoadCode extends ByteCode {

    private int loadPosition;
    private String variableName;
    private String byteCodeType;

    @Override
    public void execute(VirtualMachine vm) {

        vm.loadStack(getLoadPosition());

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

    public int getLoadPosition() {

        int tempLoadPostion = loadPosition;
        return tempLoadPostion;
    }

    private void setLoadPosition(int loadPosition) {

        this.loadPosition = loadPosition;
    }

    @Override
    public void init(Vector<String> args) {

        setByteCodeType(args.get(0));
        setLoadPosition(Integer.parseInt(args.get(1)));
        setVariableName(args.get(2));

    }

    @Override
    public String toString() {
        
        String column1Format = "%-25.25s";
        String column2Format = "%s";
        String formatInfo = column1Format + column2Format;

        String instructionString = getByteCodeType()+" "+getLoadPosition()+" "+getVariableName();
        String commentString = "<load "+getVariableName()+">";
        
        StringBuilder wholeString = new StringBuilder();
        Formatter fmt = new Formatter(wholeString);
        fmt.format(formatInfo, instructionString, commentString);
        String retString = wholeString.toString();
        fmt.close();
        return retString;
    }

    public String getClassName(){
        return "LoadCode";
    }

}
