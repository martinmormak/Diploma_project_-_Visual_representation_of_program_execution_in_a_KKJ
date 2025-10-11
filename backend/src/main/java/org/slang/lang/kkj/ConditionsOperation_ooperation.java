
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
    
public final class ConditionsOperation_ooperation
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
  public static _Operation operation(ConditionsOperation _phrase)
  {
    switch (_phrase)
    {
      case ConditionsOperation.Choose(var s1, var s2, var s3) ->
      {
        var _1 = Sequence_sequence.operation(s1);
        var _2 = Sequence_sequence.operation(s2);
        var _3 = Sequence_sequence.operation(s3);
        return (_Operation)(var te) -> 
        {
          _1.apply(te);
          _2.apply(te);
          _3.apply(te);
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
