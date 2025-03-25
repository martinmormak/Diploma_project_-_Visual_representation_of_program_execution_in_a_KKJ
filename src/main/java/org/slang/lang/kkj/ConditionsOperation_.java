
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class ConditionsOperation_
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
  public static _Operation operation(ConditionsOperation _phrase)
  {
    switch (_phrase)
    {
      case ConditionsOperation.Choose() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
      
          ve0 = ve;
           System.out.println("Choose"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
      case ConditionsOperation.While() ->
      {
        return (_Operation)(var ve) -> 
        {
          Env ve0;
          
      
          ve0 = ve;
           System.out.println("While"); System.out.println("STACK : " + ve0.printStack()); 
          return ve0;
        };
      }
    }
  }
}
