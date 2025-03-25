
      package org.slang.lang.kkj;
      import java.util.*;
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
