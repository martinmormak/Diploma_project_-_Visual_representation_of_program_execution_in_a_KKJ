
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
    
public final class Constant_
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
  public static _Operation operation(Constant _phrase)
  {
    switch (_phrase)
    {
      case Constant.PosNum(var n) ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new IntToken(Integer.valueOf(n)));
      
          ve0 = ve;
           System.out.println("TokensList: " + ve.toString()); 
          return ve0;
        };
      }
      case Constant.NegNum(var n) ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new IntToken(-1*Integer.valueOf(n)));
      
          ve0 = ve;
           System.out.println("TokensList: " + ve.toString()); 
          return ve0;
        };
      }
      case Constant.True() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new BoolToken(true));
      
          ve0 = ve;
           System.out.println("TokensList: " + ve0.toString()); 
          return ve0;
        };
      }
      case Constant.False() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new BoolToken(false));
      
          ve0 = ve;
           System.out.println("TokensList: " + ve0.toString()); 
          return ve0;
        };
      }
    }
  }
}
