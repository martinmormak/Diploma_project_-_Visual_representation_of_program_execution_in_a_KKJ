
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class StackOperations_soperation
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
  public static _Operation operation(StackOperations _phrase)
  {
    switch (_phrase)
    {
      case StackOperations.Clear() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case StackOperations.Id() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case StackOperations.Pop() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case StackOperations.Dup() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case StackOperations.Over() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case StackOperations.Swap() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case StackOperations.Rotl() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
    }
  }
}
