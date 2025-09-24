
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
      case ConditionsOperation.Choose() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new ChooseToken());
      
          ve0 = ve;
           System.out.println("TokensList : " + ve0.toString()); 
          return ve0;
        };
      }
      case ConditionsOperation.While() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new WhileToken());
      
          ve0 = ve;
           System.out.println("TokensList : " + ve0.toString()); 
          return ve0;
        };
      }
    }
  }
}
