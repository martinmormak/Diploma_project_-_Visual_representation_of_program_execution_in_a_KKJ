
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
    
public sealed interface FunctionOperations permits
FunctionOperations.Compose, FunctionOperations.Apply, FunctionOperations.ApplyOver, FunctionOperations.Quote
{
  public record Compose() implements FunctionOperations
  {
    public String toString()
    {
      String _result;
       _result = "COMPOSE"; 
      return _result;
    }
  }
  public record Apply() implements FunctionOperations
  {
    public String toString()
    {
      String _result;
       _result = "APPLY"; 
      return _result;
    }
  }
  public record ApplyOver() implements FunctionOperations
  {
    public String toString()
    {
      String _result;
       _result = "APPLYOVER"; 
      return _result;
    }
  }
  public record Quote(Sequence _1) implements FunctionOperations
  {
    public String toString()
    {
      var s = _1;
      String _result;
       _result = "{" + s + "}"; 
      return _result;
    }
  }
}
