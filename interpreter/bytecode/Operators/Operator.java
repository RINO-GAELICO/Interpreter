package interpreter.bytecode.Operators;


import java.util.HashMap;
import java.util.Map;


public abstract class Operator {

  static Map<String, Operator> operators = new HashMap<>();

  static {

    operators.put( "+", new AdditionOperator() );
    operators.put( "-", new SubtractionOperator() );
    operators.put( "*", new MultiplicationOperator() );
    operators.put( "/", new DivisionOperator() );
    operators.put( "==", new EqualOperator() );
    operators.put( "!=", new UnequalOperator() );
    operators.put( "<=", new LessOrEqualOperator() );
    operators.put( ">", new GreaterOperator() );
    operators.put( ">=", new GreaterOrEqualOperator() );
    operators.put( "<", new LessOperator() );
    operators.put( "|", new OrOperator() );
    operators.put( "&", new AndOperator() );
    


  }

  public abstract int execute(int operand1, int operand2 );

  public static Operator retrieveOperator ( String token ){

    return operators.get(token);
  }

}
