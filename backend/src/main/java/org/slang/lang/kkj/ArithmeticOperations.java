
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
    
public sealed interface ArithmeticOperations permits
ArithmeticOperations.Add, ArithmeticOperations.Sub, ArithmeticOperations.Mul, ArithmeticOperations.Cmp
{
  public record Add() implements ArithmeticOperations
  {
    public String toString()
    {
      String _result;
       _result = "ADD"; 
      return _result;
    }
  }
  public record Sub() implements ArithmeticOperations
  {
    public String toString()
    {
      String _result;
       _result = "SUB"; 
      return _result;
    }
  }
  public record Mul() implements ArithmeticOperations
  {
    public String toString()
    {
      String _result;
       _result = "MUL"; 
      return _result;
    }
  }
  public record Cmp() implements ArithmeticOperations
  {
    public String toString()
    {
      String _result;
       _result = "CMP"; 
      return _result;
    }
  }
}
