
      package org.slang.lang.kkj;
      import java.util.*;
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
