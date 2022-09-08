package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import interpreter.bytecode.*;

public class ByteCodeLoader {

  private String nextLine;
  private BufferedReader source;
  private Vector<String> vectorArgs;
  private ByteCode bytecodeInstance;
  private Program bytecodeHolder;

  public ByteCodeLoader(String byteCodeFile) throws IOException{

    bytecodeHolder = new Program();
    vectorArgs = new Vector<>();

    source = new BufferedReader(new FileReader(byteCodeFile));
    
    nextLine = source.readLine();

    if (nextLine == null) {
      throw new IOException();
    }

    while (nextLine!= null) {

      String[] arrayLine = nextLine.split("\\s+");
      String code = arrayLine[0];
      String codeClass = CodeTable.get(code);
      
      
      try {
        bytecodeInstance =
          (ByteCode)(
            Class.forName("interpreter.bytecode." + codeClass).getDeclaredConstructor().newInstance()
          );
      } catch (Exception e) {
        e.printStackTrace();
      } 
  
      for(String element : arrayLine){
        vectorArgs.add(element);
      }
      
      bytecodeInstance.init(vectorArgs);

      bytecodeHolder.add(bytecodeInstance);

      vectorArgs.clear();
      
      nextLine = source.readLine();
    }

  }

  public Program loadCodes() {

    bytecodeHolder.resolveSymbolicAdresses();
    return bytecodeHolder;
  }
}