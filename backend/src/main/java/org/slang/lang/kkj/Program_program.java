
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
    
public final class Program_program
{
  public static interface _Operation
  {
    public void apply();
  }
  public static interface _BeforeEffect
  {
    public void apply();
  }
  public static interface _AfterEffect
  {
    public void apply();
  }
  public static _Operation operation(Program _phrase)
  {
    switch (_phrase)
    {
      case Program.Prog(var s) ->
      {
        var _1 = Sequence_sequence.operation(s);
        return (_Operation)() -> 
        {
          List<IToken> te = new LinkedList<>();
          _1.apply(te);
        };
      }
    }
  }
}
