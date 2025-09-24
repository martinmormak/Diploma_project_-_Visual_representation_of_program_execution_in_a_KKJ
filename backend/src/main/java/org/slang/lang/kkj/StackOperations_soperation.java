
      package org.slang.lang.kkj;
      import java.util.*;

      import org.core.tokens.arithmetic.*;
      import org.core.tokens.condition.*;
      import org.core.tokens.constant.*;
      import org.core.tokens.functions.*;
      import org.core.tokens.interfaces.*;
      import org.core.tokens.logic.*;
      import org.core.tokens.quotation.*;
      import org.core.tokens.stack.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class StackOperations_soperation
{
  public static interface _Operation
  {
    public void apply(List<IToken> _1);
  }
  public static interface _BeforeEffect
  {
    public void apply(List<IToken> _1);
  }
  public static interface _AfterEffect
  {
    public void apply(List<IToken> _1);
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
