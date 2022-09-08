package interpreter;

import java.util.Stack;
import java.util.Vector;

public class RunTimeStack {

  private Stack<Integer> framePointers;
  private Vector<Integer> runStack;

  private int pointerTopStack;
  private int valueHolder;
  private int poppedValue;

  public RunTimeStack() {

    runStack = new Vector<>();
    framePointers = new Stack<>();
    framePointers.add(0);
    pointerTopStack = -1;
  }

  /**
   * The purpose of this function is to dump the RunTimeStack for the 
   * purpose of debugging.
   */
  public void dump() {

    Stack<Integer> stackHolder = new Stack<>();
    StringBuilder dumpBuilder = new StringBuilder();


    while(!framePointers.isEmpty()){

      stackHolder.push(framePointers.pop());
      
    }
    
    boolean openFrame = false;

    for(int i = 0; i<runStack.size(); i++){

      if(!stackHolder.isEmpty() && i==stackHolder.peek()){
        if(openFrame){
          dumpBuilder.deleteCharAt(dumpBuilder.toString().length()-1);
          dumpBuilder.append("] ");
          openFrame = false;
        }
        framePointers.push(stackHolder.pop());
        openFrame = true;
        dumpBuilder.append("[");
      }

      dumpBuilder.append(""+runStack.get(i)+",");
      
    }
    if(openFrame){
      
      dumpBuilder.deleteCharAt(dumpBuilder.toString().length()-1);
      dumpBuilder.append("]");
      openFrame = false;
    }

    if(!stackHolder.isEmpty()){
      while(!stackHolder.isEmpty()){
        framePointers.push(stackHolder.pop());
        dumpBuilder.append("[]");
        openFrame = false;
      }
    }

    System.out.println(dumpBuilder.toString());
  }
    

  /**
   * Returns the top item on the runtime stack.
   */
  public int peek() {

    return runStack.get(pointerTopStack);

  }

  /**
   * Pops the top item from the runtime stack, returning the item.
   */
  public int pop() {

    if(pointerTopStack>(-1) && pointerTopStack>=framePointers.peek()){
      poppedValue = runStack.remove(pointerTopStack);
      pointerTopStack--;
      return poppedValue;
    }else{
      System.out.println("No more values to be popped.");
      return poppedValue;
    }
    
    
  }

  /**
   * Push an item on to the runtime stack, returning the item that was just
   * pushed.
   */
  public int push(int item) {

    runStack.add(item);
    pointerTopStack++;
    return item;
  }

  /**
   * This second form with an Integer parameter is used to load literals onto the
   * stack.
   */
  public Integer push(Integer wrappedItem) {

    runStack.add(wrappedItem);
    pointerTopStack++;
    return wrappedItem;
  }

  /**
   * Start a new frame, where the parameter offset is the number of slots
   * down from the top of the RunTimeStack for starting the new frame.
   */
  public void newFrameAt(int offset) {

    framePointers.add(pointerTopStack - offset +1);
  }

  /**
   * We pop the top frame when we return from a function; before popping, the
   * functions’ return value is at the top of the stack so we’ll save the value,
   * pop the top frame, and then push the return value.
   */
  public void popFrame() {

    valueHolder = runStack.get(pointerTopStack);
    Integer topFrame = framePointers.pop();
    for (int i = pointerTopStack; i >= topFrame; i--) {
      runStack.remove(pointerTopStack);
      pointerTopStack--;
    }
    runStack.add(valueHolder);
    pointerTopStack++;

  }

  /**
   * Used to store into variables.
   */
  public int store(int offset) {

    valueHolder = runStack.remove(pointerTopStack);
    pointerTopStack--;
    runStack.remove(offset + framePointers.peek());
    runStack.add(offset + framePointers.peek(), valueHolder);
    return valueHolder;
  }

  /**
   * Used to load variables onto the stack.
   */
  public int load(int offset) {

    valueHolder = runStack.get(offset + framePointers.peek());
    runStack.add(valueHolder);
    pointerTopStack++;
    return valueHolder;
  }


}