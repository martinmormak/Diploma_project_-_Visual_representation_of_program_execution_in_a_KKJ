
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
    
public final class Program_
{
  public static interface _Operation
  {
    public List<IToken> apply();
  }
  public static interface _BeforeEffect
  {
    public void apply();
  }
  public static interface _AfterEffect
  {
    public void apply(List<IToken> _1);
  }
  public static _Operation operation(Program _phrase)
  {
    switch (_phrase)
    {
      case Program.Prog(var c) ->
      {
        var _1 = Sequence_.operation(c);
        return (_Operation)() -> 
        {
          List<IToken> tokens;
          List<IToken> ve0 =  new LinkedList<>() ;
          tokens = _1.apply(ve0);
           System.out.println("TokensList: " + ve0.toString());
          return tokens;
        };
      }
    }
  }
}
