
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class ConditionsOperation_ooperation
{
  public static interface _Operation
  {
    public void apply(Env _1);
  }
  public static interface _BeforeEffect
  {
    public void apply(Env _1);
  }
  public static interface _AfterEffect
  {
    public void apply(Env _1);
  }
  public static _Operation operation(ConditionsOperation _phrase)
  {
    switch (_phrase)
    {
      case ConditionsOperation.Choose() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case ConditionsOperation.While() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
    }
  }
}
