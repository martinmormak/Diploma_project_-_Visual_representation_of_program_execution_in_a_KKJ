
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
    
public final class ConditionsOperation_
{
  public static interface _Operation
  {
    public List<IToken> apply(List<IToken> _1);
  }
  public static interface _BeforeEffect
  {
    public void apply(List<IToken> _1);
  }
  public static interface _AfterEffect
  {
    public void apply(List<IToken> _1, List<IToken> _2);
  }
  public static _Operation operation(ConditionsOperation _phrase)
  {
    switch (_phrase)
    {
      case ConditionsOperation.Choose(var s1, var s2, var s3) ->
      {
        var _1 = Sequence_.operation(s1);
        var _2 = Sequence_.operation(s2);
        var _3 = Sequence_.operation(s3);
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        List<IToken> ve3 = new LinkedList<>();
        List<IToken> ve4 = new LinkedList<>();
        List<IToken> ve5 = new LinkedList<>();
      
          List<IToken> ve2 = _1.apply(ve3);
          List<IToken> ve1 = _2.apply(ve4);
          ve0 = _3.apply(ve5);
          
        ve.add(new ConditionToken(ve2,ve1,ve0));
      
          ve0 = ve;
           System.out.println("TokensList: " + ve0.toString());
          return ve0;
        };
      }
      case ConditionsOperation.While() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
      
          ve0 = ve;
           System.out.println("TokensList: " + ve0.toString());
          return ve0;
        };
      }
    }
  }
}
