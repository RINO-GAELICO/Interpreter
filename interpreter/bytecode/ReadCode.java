package interpreter.bytecode;

import java.util.Formatter;
import java.util.Scanner;
import java.util.Vector;

import interpreter.VirtualMachine;

public class ReadCode extends ByteCode {


    private String byteCodeType;


    @Override
    public void execute(VirtualMachine vm) {

        Integer inputInteger = null;
        
        System.out.print(">");

        String readInputString = vm.getInput().nextLine();

        while(inputInteger==null){
            try {
                
                inputInteger = Integer.parseInt(readInputString);

            }catch(NumberFormatException e){

                System.out.println("Not a valid input. Enter an integer");
                System.out.print(">");
                readInputString = vm.getInput().nextLine();
            }
        }
        vm.pushStack(inputInteger.intValue());
        inputInteger=null;
        
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
        return "ReadCode";
    }
    
}
