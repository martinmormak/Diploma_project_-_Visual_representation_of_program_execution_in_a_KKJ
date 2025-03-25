
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public sealed interface Sequence permits
Sequence.Seq, Sequence.Cons, Sequence.ArithmeticOp, Sequence.LogicalOp, Sequence.StackOp, Sequence.FunctionOp, Sequence.ConditionsOp
{
  public record Seq(Sequence _1, Sequence _2) implements Sequence
  {
    public String toString()
    {
      var s1 = _1;
      var s2 = _2;
      String _result;
       _result =  s1 + " " + s2; 
      return _result;
    }
  }
  public record Cons(Constant _1) implements Sequence
  {
    public String toString()
    {
      var c = _1;
      String _result;
       _result = c.toString(); 
      return _result;
    }
  }
  public record ArithmeticOp(ArithmeticOperations _1) implements Sequence
  {
    public String toString()
    {
      var a = _1;
      String _result;
       _result = a.toString(); 
      return _result;
    }
  }
  public record LogicalOp(LogicalOperations _1) implements Sequence
  {
    public String toString()
    {
      var l = _1;
      String _result;
       _result = l.toString(); 
      return _result;
    }
  }
  public record StackOp(StackOperations _1) implements Sequence
  {
    public String toString()
    {
      var s = _1;
      String _result;
       _result = s.toString(); 
      return _result;
    }
  }
  public record FunctionOp(FunctionOperations _1) implements Sequence
  {
    public String toString()
    {
      var f = _1;
      String _result;
       _result = f.toString(); 
      return _result;
    }
  }
  public record ConditionsOp(ConditionsOperation _1) implements Sequence
  {
    public String toString()
    {
      var o = _1;
      String _result;
       _result = o.toString(); 
      return _result;
    }
  }
}
