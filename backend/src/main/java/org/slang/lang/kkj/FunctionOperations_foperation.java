
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
    
public final class FunctionOperations_foperation
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
      case FunctionOperations.ApplyOver() ->
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
