package interpreter.bytecode;

import java.util.Formatter;
import java.util.Vector;

import interpreter.VirtualMachine;

public class DumpCode extends ByteCode {

    private String flagOnOff;
    private String byteCodeType;


    @Override
    public void execute(VirtualMachine vm) {
        
        if(getFlagOnOff().equals("ON")){
            vm.setDumpON(true);
        }else{
            vm.setDumpOFF(true);
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

    public String getFlagOnOff() {
        String tempFlag = new String(flagOnOff);
        return tempFlag;
    }

    private void setFlagOnOff(String flagOnOff) {
        this.flagOnOff = flagOnOff;
    }

    @Override
    public void init(Vector<String> args) {
        
        setByteCodeType(args.get(0));
        setFlagOnOff(args.get(1));
        
    }

    @Override
    public String toString(){

        String column1Format = "%-25.25s";

        String formatInfo = column1Format;

        String instructionString = getByteCodeType()+" "+getFlagOnOff();
        
        StringBuilder wholeString = new StringBuilder();
        Formatter fmt = new Formatter(wholeString);
        fmt.format(formatInfo, instructionString);
        String retString = wholeString.toString();
        fmt.close();
        return retString;
    }

    public String getClassName(){
        return "DumpCode";
    }
    
}
