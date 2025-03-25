
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class LogicalOperations_
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
  public static _Operation operation(LogicalOperations _phrase)
  {
    switch (_phrase)
    {
      case LogicalOperations.Not() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v0 = ve.peek();
        if (v0 instanceof BoolValue bv0) {
          ve.pop();
          Value v = new BoolValue(!bv0.getValue());
          ve.push(v);
        } else {
          throw new IllegalArgumentException("Both values must be BoolValue for logical operations.");
        }
      
          ve0 = ve;
           System.out.println("Not"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case LogicalOperations.And() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v1 = ve.peek();
        Value v2 = ve.peek();
        if (v1 instanceof BoolValue bv1 && v2 instanceof BoolValue bv2) {
          ve.pop();
          ve.pop();
          Value v = new BoolValue(bv2.getValue() && bv1.getValue());
          ve.push(v);
        } else {
          throw new IllegalArgumentException("Both values must be BoolValue for logical operations.");
        }
      
          ve0 = ve;
           System.out.println("And"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case LogicalOperations.IsNeg() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v = ve.peek();
        if (v instanceof IntegerValue ev) {
          ve.pop();
          if(ev.getValue() < 0){
            Value vt = new BoolValue(true);
            ve.push(vt);
          } else {
            Value vf = new BoolValue(false);
            ve.push(vf);
          }
        } else {
          throw new IllegalArgumentException("Both values must be IntegerValue for logical operations.");
        }
      
          ve0 = ve;
           System.out.println("IsNeg"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case LogicalOperations.IsPos() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v = ve.peek();
        if (v instanceof IntegerValue ev) {
          ve.pop();
          if(ev.getValue() > 0){
            Value vt = new BoolValue(true);
            ve.push(vt);
          } else {
            Value vf = new BoolValue(false);
            ve.push(vf);
          }
        } else {
          throw new IllegalArgumentException("Both values must be IntegerValue for logical operations.");
        }
      
          ve0 = ve;
           System.out.println("IsPos"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
    }
  }
}
