
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
    
public final class Sequence_
{
  public static interface _Operation
  {
    public List<IToken> apply(List<IToken> _1);
  }
  public static interface _BeforeEffect
  {
    public void apply(List<IToken> _1);
  }
  public static interface _AfterEffect
  {
    public void apply(List<IToken> _1, List<IToken> _2);
  }
  public static _Operation operation(Sequence _phrase)
  {
    switch (_phrase)
    {
      case Sequence.Seq(var s1, var s2) ->
      {
        var _1 = Sequence_.operation(s1);
        var _2 = Sequence_.operation(s2);
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          List<IToken> ve1 = _1.apply(ve);
          ve0 = _2.apply(ve1);
          return ve0;
        };
      }
      case Sequence.Cons(var c) ->
      {
        var _1 = Constant_.operation(c);
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          ve0 = _1.apply(ve);
          return ve0;
        };
      }
      case Sequence.ArithmeticOp(var a) ->
      {
        var _1 = ArithmeticOperations_.operation(a);
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          ve0 = _1.apply(ve);
          return ve0;
        };
      }
      case Sequence.LogicalOp(var l) ->
      {
        var _1 = LogicalOperations_.operation(l);
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          ve0 = _1.apply(ve);
          return ve0;
        };
      }
      case Sequence.StackOp(var s) ->
      {
        var _1 = StackOperations_.operation(s);
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          ve0 = _1.apply(ve);
          return ve0;
        };
      }
      case Sequence.FunctionOp(var f) ->
      {
        var _1 = FunctionOperations_.operation(f);
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          ve0 = _1.apply(ve);
          return ve0;
        };
      }
      case Sequence.ConditionsOp(var o) ->
      {
        var _1 = ConditionsOperation_.operation(o);
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          ve0 = _1.apply(ve);
          return ve0;
        };
      }
    }
  }
}
