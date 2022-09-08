/**
 * Each bytecode class should have fields for its specific arguments. The 
 * abstract ByteCode class SHOULD NOT CONTAIN ANY FIELDS (instance variables) 
 * THAT RELATE TO ARGUMENTS. This is a design requirement.
 * 
 * It's easier to think in more general terms (i.e. plan for any number of 
 * args for a bytecode). Note that the Bytecode abstract class should not be 
 * aware of the peculiarities of any particular bytecode. That is, some 
 * bytecodes might have zero args (HALT), or one arg, etc. Consider providing 
 * an "init" method with each bytecode class. After constructing the bytecode 
 * (e.g. LoadCode) then you can call its "init" method and give it a vector of 
 * String args. Each bytecode object will interrogate the vector and extract 
 * relevant args for itself. The Bytecode class SHOULD NOT record the args 
 * for any bytecodes. Each concrete bytecode class will have instance 
 * variable(s) to record its args.
 * 
 * When you read a line from the bytecode file, you should parse each argument 
 * placing them into a vector. Each bytecode takes responsibility for extracting
 * relevant information from the vector and storing it as private data.
 */
package interpreter.bytecode;

import java.util.Vector;

import interpreter.VirtualMachine;

public abstract class ByteCode {
  
  public abstract void execute(VirtualMachine vm);


  public abstract void init(Vector<String> args);
}

