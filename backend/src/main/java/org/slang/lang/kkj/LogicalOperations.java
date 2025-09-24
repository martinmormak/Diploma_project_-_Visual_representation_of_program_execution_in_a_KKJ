
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
    
public sealed interface LogicalOperations permits
LogicalOperations.Not, LogicalOperations.And, LogicalOperations.IsNeg, LogicalOperations.IsPos
{
  public record Not() implements LogicalOperations
  {
    public String toString()
    {
      String _result;
       _result = "NOT"; 
      return _result;
    }
  }
  public record And() implements LogicalOperations
  {
    public String toString()
    {
      String _result;
       _result = "AND"; 
      return _result;
    }
  }
  public record IsNeg() implements LogicalOperations
  {
    public String toString()
    {
      String _result;
       _result = "ISNEG"; 
      return _result;
    }
  }
  public record IsPos() implements LogicalOperations
  {
    public String toString()
    {
      String _result;
       _result = "ISPOS"; 
      return _result;
    }
  }
}
