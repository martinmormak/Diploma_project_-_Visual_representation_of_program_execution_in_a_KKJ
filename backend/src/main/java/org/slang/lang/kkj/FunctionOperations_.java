
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
    
public final class FunctionOperations_
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
  public static _Operation operation(FunctionOperations _phrase)
  {
    switch (_phrase)
    {
      case FunctionOperations.Compose() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new ComposeToken());
      
          ve0 = ve;
           System.out.println("TokensList : " + ve0.toString()); 
          return ve0;
        };
      }
      case FunctionOperations.Apply() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new ApplyToken());
      
          ve0 = ve;
           System.out.println("TokensList : " + ve0.toString()); 
          return ve0;
        };
      }
      case FunctionOperations.ApplyOver() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new ApplyOverToken());
      
          ve0 = ve;
           System.out.println("TokensList : " + ve0.toString()); 
          return ve0;
        };
      }
      case FunctionOperations.Quote(var s) ->
      {
        var _1 = Sequence_.operation(s);
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          List<IToken> ve1 = new LinkedList<>();
          ve0 = _1.apply(ve1);
          
        ve.add(new QuotationToken(ve0));
      
          ve0 = ve;
           System.out.println("TokensList : " + ve0.toString()); 
          return ve0;
        };
      }
    }
  }
}
