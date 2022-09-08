/**
 * DO NOT provide a method that returns components contained WITHIN the VM (this 
 * is the exact situation that will break encapsulation) - you should request 
 * that the VM performs operations on its components. This implies that the VM 
 * owns the components and is free to change them, as needed, without breaking 
 * clients' code (e.g., suppose I decide to change the name of the variable that 
 * holds my runtime stack - if your code had referenced that variable then your 
 * code would break. This is not an unusual situation - you can consider the 
 * names of methods in the Java libraries that have been deprecated).
 * 
 * Consider that the VM calls the individual ByteCodes' execute method and 
 * passes itself as a parameter. For the ByteCode to execute, it must invoke 
 * one or more methods in the runStack. It can do this by executing 
 * VM.runStack.pop(); however, this does break encapsulation. To avoid this, 
 * you'll need to have a corresponding set of methods within the VM that do 
 * nothing more than pass the call to the runStack. e.g., you would want to 
 * define a VM method:
 *     public int popRunStack() {
 *       return runStack.pop();
 *     }
 * called by, e.g.,
 *     int temp = VM.popRunStack();
 */
package interpreter;

import java.util.Scanner;
import java.util.Stack;
import interpreter.bytecode.ByteCode;

public class VirtualMachine {

  private int pc, argsFunction;
  private RunTimeStack runTimeStack;
  private Stack<Integer> returnAddresses;
  private boolean isRunning;
  private boolean dumpState, dumpONFound,dumpOffFound;
  private Program program;
  private Scanner input = new Scanner(System.in);  

  public VirtualMachine(Program program) {
    this.program = program;
    dumpState = false;
    dumpONFound = false;
    dumpOffFound = false;
  }

  public Scanner getInput() {
    return input;
  }

  public int getArgsFunction() {
    return argsFunction;
  }

  public void setArgsFunction(int argsFunction) {
    this.argsFunction = argsFunction;
  }

  public int popStackAddresses() {
    return returnAddresses.pop().intValue();
  }

  public void pushStackAdresses(Integer newAddress){
    returnAddresses.push(newAddress);
    return;
  }

  public Program getProgram(){
    
    return this.program;
    
  }

  public void executeProgram() {
    pc = 0;
    runTimeStack = new RunTimeStack();
    returnAddresses = new Stack<>();
    isRunning = true;

    while (isRunning) {
      ByteCode code = program.getCode(pc);
      if (code == null) {
        break;
      }

      code.execute(this);

      if(dumpOffFound){
        dumpState = false;
        dumpOffFound = false;
      }

      if(dumpState){

        System.out.println(code.toString());
        runTimeStack.dump(); 
      }

      if(dumpONFound){
        dumpState = true;
        dumpONFound = false;
      }

      
      pc++;
    }
    input.close();
  }

  public void setIsRunning(boolean newState) {

    isRunning = newState;
  }

  public void setDumpON(boolean newState){

    dumpONFound = newState;
  }

  public void setDumpOFF(boolean newState){
    
    dumpOffFound = newState;
  }

  public int popStack() {

    return runTimeStack.pop();
  }

  public void setProgramCounter(int jump) {

    this.pc = jump;
  }

  public int storeStack(int offsetStore) {

    return runTimeStack.store(offsetStore);
  }

  public int loadStack(int offsetLoad) {

    return runTimeStack.load(offsetLoad);
  }

  public int pushStack(int pushedValue) {

    return runTimeStack.push(pushedValue);
  }

  public void newFrameAt(int newFrameOffset){

    runTimeStack.newFrameAt(newFrameOffset);
  }

  public void popFrame(){

    runTimeStack.popFrame();
  }

  public int peekStack(){

    return runTimeStack.peek();
  }

  public int getProgramCounter(){
    int tempPc = this.pc;
    return tempPc;
  }





}