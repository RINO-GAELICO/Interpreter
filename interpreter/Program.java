package interpreter;

import java.util.ArrayList;
import java.util.HashMap;

import interpreter.bytecode.ByteCode;

public class Program {

  private ArrayList<ByteCode> arrayByteCode;
  private HashMap<String, Integer> labelMap;
  private ArrayList<Integer> targetBranchList;

  public Program(){
    
    arrayByteCode = new ArrayList<>();
    labelMap = new HashMap<>();
    targetBranchList = new ArrayList<>();
  }

  public ByteCode getCode(int programCounter) {

    if(programCounter<arrayByteCode.size()){

      return arrayByteCode.get(programCounter);

    }else{

      return null;
    }
    
  }

  public void add(ByteCode instanceByteCode){

    arrayByteCode.add(instanceByteCode);

    if(instanceByteCode instanceof TargetBranch){

      targetBranchList.add((arrayByteCode.size()-1));

    }

    if(instanceByteCode instanceof TargetLabel){

      TargetLabel labelInstance = (TargetLabel) instanceByteCode;
      labelMap.put(labelInstance.getLabel(),arrayByteCode.size()-1);
    }

    return;
 
  }

  public void resolveSymbolicAdresses(){

    for(int targetElement : targetBranchList){
      ByteCode tempBytecode = arrayByteCode.get(targetElement);
      if(tempBytecode instanceof TargetBranch){
        TargetBranch instanceTarget = (TargetBranch) tempBytecode;
        instanceTarget.setAddress(labelMap.get(instanceTarget.getLabel()));
      } 
    }
  }
}