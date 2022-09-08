package interpreter.bytecode;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Stack;
import java.util.Vector;

import interpreter.TargetBranch;
import interpreter.VirtualMachine;

public class CallCode extends ByteCode implements TargetBranch{

    private String label;
    private String byteCodeType;
    private int address, argsNumber;
    private ArrayList<Integer> args;


    @Override
    public void execute(VirtualMachine vm) {
        
        
        vm.pushStackAdresses( vm.getProgramCounter()+1 );
        vm.setProgramCounter(address-1);
        argsNumber = vm.getArgsFunction();
        args = new ArrayList<>();
        Stack<Integer> storeStack = new Stack<>();
        int arg;
        for(int i = 0; i<argsNumber; i++){
            arg = vm.popStack();
            storeStack.push(arg);
        }
        while(!storeStack.isEmpty()){
            args.add(storeStack.peek());
            vm.pushStack(storeStack.pop());
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
        return byteCodeType;
    }

    private void setByteCodeType(String byteCodeType) {
        this.byteCodeType = byteCodeType;
    }

    public String getLabel() {
        String tempFunctionName = new String(label);
        return tempFunctionName;
    }

    public void setLabel(String functionName) {
        this.label = functionName;
    }

    @Override
    public void init(Vector<String> args) {
        
        setByteCodeType(args.get(0));
        setLabel(args.get(1));
    }

    @Override
    public String toString(){
        
        String column1Format = "%-25.25s";
        String column2Format = "%s";
        String formatInfo = column1Format + column2Format;

        String instructionString = getByteCodeType()+" "+getLabel();
        
        StringBuilder listBuilder = new StringBuilder();
        for(int i = 0; i< args.size(); i++){
            
            if(i==args.size()-1){
                listBuilder.append(""+args.get(i));
            }else{
                listBuilder.append(args.get(i)+",");
            }
        }
        String commentString = getLabel().substring(0,1)+"("+ listBuilder.toString() +")";
        
        StringBuilder wholeString = new StringBuilder();
        Formatter fmt = new Formatter(wholeString);
        fmt.format(formatInfo, instructionString, commentString);
        String retString = wholeString.toString();
        fmt.close();
        return retString;
    }

    public String getClassName(){
        return "CallCode";
    }
    
}
