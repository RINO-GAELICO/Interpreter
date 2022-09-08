package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.VirtualMachine;

public class LitCode extends ByteCode {

    private int literalValue;
    private String variableName = "";
    private String byteCodeType;

    @Override
    public void execute(VirtualMachine vm) {

        vm.pushStack(getLiteralValue());

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

    public int getLiteralValue() {
        int tempLit = literalValue;
        return tempLit;
    }

    private void setLiteralValue(int literalValue) {
        this.literalValue = literalValue;
    }

    @Override
    public void init(Vector<String> args) {

        setByteCodeType(args.get(0));
        setLiteralValue(Integer.parseInt(args.get(1)));
        if (args.toArray().length > 2) {
            setVariableName(args.get(2));
        }

    }

    @Override
    public String toString(){
        String column1Format = "%-25.25s";
        String column2Format = "%s";
        String formatInfo = column1Format + column2Format;

        String instructionString = getByteCodeType()+" "+getLiteralValue()+" "+variableName;
        String commentString = variableName;
        if(variableName.length()>0){
            commentString = "int "+variableName;
        }
        
        StringBuilder wholeString = new StringBuilder();
        Formatter fmt = new Formatter(wholeString);
        fmt.format(formatInfo, instructionString, commentString);
        String retString = wholeString.toString();
        fmt.close();
        return retString;
    }

    public String getClassName(){
        return "LitCode";
    }
}
