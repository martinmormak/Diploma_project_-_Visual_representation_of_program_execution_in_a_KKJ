
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class LogicalOperations_loperation
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
  public static _Operation operation(LogicalOperations _phrase)
  {
    switch (_phrase)
    {
      case LogicalOperations.Not() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case LogicalOperations.And() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case LogicalOperations.IsNeg() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case LogicalOperations.IsPos() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
    }
  }
}
