
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class StackOperations_
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
  public static _Operation operation(StackOperations _phrase)
  {
    switch (_phrase)
    {
      case StackOperations.Clear() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        ve.newStack();
      
          ve0 = ve;
           System.out.println("Clear"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case StackOperations.Id() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          ve0 = ve;
           System.out.println("Id"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case StackOperations.Pop() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        ve.pop();
      
          ve0 = ve;
           System.out.println("Pop"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case StackOperations.Dup() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v = ve.peek();
        ve.push(v);
      
          ve0 = ve;
           System.out.println("Dup"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case StackOperations.Over() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v1 = ve.pop();
        Value v2 = ve.peek();
        ve.push(v1);
        ve.push(v2);
      
          ve0 = ve;
           System.out.println("Over"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case StackOperations.Swap() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v1 = ve.pop();
        Value v2 = ve.pop();
        ve.push(v2);
        ve.push(v1);
      
          ve0 = ve;
           System.out.println("Swap"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case StackOperations.Rotl() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v1 = ve.pop();
        Value v2 = ve.pop();
        Value v3 = ve.pop();
        ve.push(v2);
        ve.push(v1);
        ve.push(v3);
      
          ve0 = ve;
           System.out.println("Rotl"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
    }
  }
}
