
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class FunctionOperations_
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
  public static _Operation operation(FunctionOperations _phrase)
  {
    switch (_phrase)
    {
      case FunctionOperations.Compose() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
      
          ve0 = ve;
           System.out.println("Compose"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case FunctionOperations.Apply() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
      
          ve0 = ve;
           System.out.println("Apply"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case FunctionOperations.Applyover() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        ve.pop();
      
          ve0 = ve;
           System.out.println("Applyover"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case FunctionOperations.Quote(var s) ->
      {
        var _1 = Sequence_.operation(s);
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          ve0 = _1.apply(ve);
           System.out.println("Quote"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
    }
  }
}
