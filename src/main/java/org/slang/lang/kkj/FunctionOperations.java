
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public sealed interface FunctionOperations permits
FunctionOperations.Compose, FunctionOperations.Apply, FunctionOperations.Applyover, FunctionOperations.Quote
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
  public record Applyover() implements FunctionOperations
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
