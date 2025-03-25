
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class Constant_
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
  public static _Operation operation(Constant _phrase)
  {
    switch (_phrase)
    {
      case Constant.Num(var n) ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v = new IntegerValue(Integer.valueOf(n));
        ve.push(v);
      
          ve0 = ve;
           System.out.println("Num"); System.out.println("VARIABLES : " + ve.printVariables()); System.out.println("STACK : " + ve.printStack()); 
          return ve0;
        };
      }
      case Constant.True() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v = new BoolValue(true);
        ve.push(v);
      
          ve0 = ve;
           System.out.println("True"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case Constant.False() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
        Value v = new BoolValue(false);
        ve.push(v);
      
          ve0 = ve;
           System.out.println("False"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
    }
  }
}
