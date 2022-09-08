package interpreter;

import java.util.HashMap;

import interpreter.bytecode.*;


public class CodeTable {

  static HashMap<String, String> byteCodeMap = new HashMap<>();

  public static void init () {
    


      byteCodeMap.put( "HALT", (new HaltCode()).getClassName() );
      byteCodeMap.put( "POP", (new PopCode()).getClassName() );
      byteCodeMap.put( "FALSEBRANCH", (new FalseBranchCode()).getClassName() );
      byteCodeMap.put( "GOTO", (new GoToCode()).getClassName() );
      byteCodeMap.put( "STORE", (new StoreCode()).getClassName() );
      byteCodeMap.put( "LOAD", (new LoadCode()).getClassName() );
      byteCodeMap.put( "LIT", (new LitCode()).getClassName() );
      byteCodeMap.put( "ARGS", (new ArgsCode()).getClassName() );
      byteCodeMap.put( "CALL", (new CallCode()).getClassName() );
      byteCodeMap.put( "RETURN", (new ReturnCode()).getClassName() );
      byteCodeMap.put( "BOP", (new BopCode()).getClassName() );
      byteCodeMap.put( "READ", (new ReadCode()).getClassName() );
      byteCodeMap.put( "WRITE", (new WriteCode()).getClassName() );
      byteCodeMap.put( "LABEL", (new LabelCode()).getClassName() );
      byteCodeMap.put( "DUMP", (new DumpCode()).getClassName() );

  }

  public static String get(String code) {
    return byteCodeMap.get(code);
  }
}