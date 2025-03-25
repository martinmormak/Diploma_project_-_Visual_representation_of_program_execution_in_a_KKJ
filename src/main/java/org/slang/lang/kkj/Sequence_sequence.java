
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class Sequence_sequence
{
  public static interface _Operation
  {
    public void apply(Env _1);
  }
  public static interface _BeforeEffect
  {
    public void apply(Env _1);
  }
  public static interface _AfterEffect
  {
    public void apply(Env _1);
  }
  public static _Operation operation(Sequence _phrase)
  {
    switch (_phrase)
    {
      case Sequence.Seq(var s1, var s2) ->
      {
        var _1 = Sequence_sequence.operation(s1);
        var _2 = Sequence_sequence.operation(s2);
        return (_Operation)(var te) -> 
        {
          _1.apply(te);
          _2.apply(te);
        };
      }
      case Sequence.Cons(var c) ->
      {
        var _1 = Constant_constatant.operation(c);
        return (_Operation)(var te) -> 
        {
          _1.apply(te);
        };
      }
      case Sequence.ArithmeticOp(var a) ->
      {
        var _1 = ArithmeticOperations_aoperation.operation(a);
        return (_Operation)(var te) -> 
        {
          _1.apply(te);
        };
      }
      case Sequence.LogicalOp(var l) ->
      {
        var _1 = LogicalOperations_loperation.operation(l);
        return (_Operation)(var te) -> 
        {
          _1.apply(te);
        };
      }
      case Sequence.StackOp(var s) ->
      {
        var _1 = StackOperations_soperation.operation(s);
        return (_Operation)(var te) -> 
        {
          _1.apply(te);
        };
      }
      case Sequence.FunctionOp(var f) ->
      {
        var _1 = FunctionOperations_foperation.operation(f);
        return (_Operation)(var te) -> 
        {
          _1.apply(te);
        };
      }
      case Sequence.ConditionsOp(var o) ->
      {
        var _1 = ConditionsOperation_ooperation.operation(o);
        return (_Operation)(var te) -> 
        {
          _1.apply(te);
        };
      }
    }
  }
}
