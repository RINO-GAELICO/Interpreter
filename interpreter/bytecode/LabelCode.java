package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.TargetLabel;
import interpreter.VirtualMachine;

public class LabelCode extends ByteCode implements TargetLabel{

    private String label;
    private String byteCodeType;



    @Override
    public void execute(VirtualMachine vm) {
        // Target for branches (FALSEBRANCH, GOTO, CALL)
        
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
        label = args.get(1);
        
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

    public String getLabel(){
        String tempLabel = new String(label);
        return tempLabel;
    }

    public String getClassName(){
        return "LabelCode";
    }
    
}
