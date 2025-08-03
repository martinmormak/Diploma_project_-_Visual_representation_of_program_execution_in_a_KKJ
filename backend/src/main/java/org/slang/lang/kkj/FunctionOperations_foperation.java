
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class FunctionOperations_foperation
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
  public static _Operation operation(FunctionOperations _phrase)
  {
    switch (_phrase)
    {
      case FunctionOperations.Compose() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case FunctionOperations.Apply() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case FunctionOperations.Applyover() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case FunctionOperations.Quote(var s) ->
      {
        var _1 = Sequence_sequence.operation(s);
        return (_Operation)(var te) -> 
        {
          _1.apply(te);
        };
      }
    }
  }
}
