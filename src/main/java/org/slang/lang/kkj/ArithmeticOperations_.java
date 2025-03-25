
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class ArithmeticOperations_
{
  public static interface _Operation
  {
    public Env apply(Env _1);
  }
  public static interface _BeforeEffect
  {
    public void apply(Env _1);
  }
  public static interface _AfterEffect
  {
    public void apply(Env _1, Env _2);
  }
  public static _Operation operation(ArithmeticOperations _phrase)
  {
    switch (_phrase)
    {
      case ArithmeticOperations.Add() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v1 = ve.peek();
        Value v2 = ve.peek();
        if (v1 instanceof IntegerValue ev1 && v2 instanceof IntegerValue ev2) {
          ve.pop();
          ve.pop();
          Value v = new IntegerValue(ev2.getValue() + ev1.getValue());
          ve.push(v);
        } else {
          throw new IllegalArgumentException("Both values must be IntegerValue for logical operations.");
        }
      
          ve0 = ve;
           System.out.println("Add"); System.out.println("VARIABLES : " + ve.printVariables()); System.out.println("STACK : " + ve.printStack()); 
          return ve0;
        };
      }
      case ArithmeticOperations.Sub() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v1 = ve.peek();
        Value v2 = ve.peek();
        if (v1 instanceof IntegerValue ev1 && v2 instanceof IntegerValue ev2) {
          ve.pop();
          ve.pop();
          Value v = new IntegerValue(ev2.getValue() - ev1.getValue());
          ve.push(v);
        } else {
          throw new IllegalArgumentException("Both values must be IntegerValue for logical operations.");
        }
      
          ve0 = ve;
           System.out.println("Sub"); System.out.println("VARIABLES : " + ve.printVariables()); System.out.println("STACK : " + ve.printStack()); 
          return ve0;
        };
      }
      case ArithmeticOperations.Mul() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v1 = ve.peek();
        Value v2 = ve.peek();
        if (v1 instanceof IntegerValue ev1 && v2 instanceof IntegerValue ev2) {
          ve.pop();
          ve.pop();
          Value v = new IntegerValue(ev2.getValue() * ev1.getValue());
          ve.push(v);
        } else {
          throw new IllegalArgumentException("Both values must be IntegerValue for logical operations.");
        }
      
          ve0 = ve;
           System.out.println("Mul"); System.out.println("VARIABLES : " + ve.printVariables()); System.out.println("STACK : " + ve.printStack()); 
          return ve0;
        };
      }
      case ArithmeticOperations.Cmp() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v1 = ve.peek();
        Value v2 = ve.peek();
        if (v1 instanceof IntegerValue ev1 && v2 instanceof IntegerValue ev2) {
          ve.pop();
          ve.pop();
          if(ev1.getValue() < ev2.getValue()){
            Value lv = new IntegerValue(1);
            ve.push(lv);
          } else if(ev1.getValue() > ev2.getValue()){
            Value mv = new IntegerValue(-1);
            ve.push(mv);
          } else {
            Value mv = new IntegerValue(0);
            ve.push(mv);
          }
        } else {
          throw new IllegalArgumentException("Both values must be IntegerValue for logical operations.");
        }
      
          ve0 = ve;
           System.out.println("Cmp"); System.out.println("VARIABLES : " + ve.printVariables()); System.out.println("STACK : " + ve.printStack()); 
          return ve0;
        };
      }
    }
  }
}
