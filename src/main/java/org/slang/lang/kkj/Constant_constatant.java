
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class Constant_constatant
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
  public static _Operation operation(Constant _phrase)
  {
    switch (_phrase)
    {
      case Constant.Num(var n) ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case Constant.True() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case Constant.False() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
    }
  }
}
