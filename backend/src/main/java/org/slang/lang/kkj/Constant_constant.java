
      package org.slang.lang.kkj;
      import java.util.*;

      import org.core.tokens.interfaces.*;

public final class Constant_constant
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
  public static _Operation operation(Constant _phrase)
  {
    switch (_phrase)
    {
      case Constant.PosNum(var n) ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case Constant.NegNum(var n) ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case Constant.True() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
      case Constant.False() ->
      {
        return (_Operation)(var te) -> 
        {
        };
      }
    }
  }
}
