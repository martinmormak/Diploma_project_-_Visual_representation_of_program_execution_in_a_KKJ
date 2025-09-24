
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
    
public final class ArithmeticOperations_aoperation
{
  public static interface _Operation
  {
    public void apply(List<IToken> _1);
  }
  public static interface _BeforeEffect
  {
    public void apply(List<IToken> _1);
  }
  public static interface _AfterEffect
  {
    public void apply(List<IToken> _1);
  }
  public static _Operation operation(ArithmeticOperations _phrase)
  {
    switch (_phrase)
    {
      case ArithmeticOperations.Add() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case ArithmeticOperations.Sub() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case ArithmeticOperations.Mul() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case ArithmeticOperations.Cmp() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
    }
  }
}
