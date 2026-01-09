
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
    
public final class StackOperations_
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
  public static _Operation operation(StackOperations _phrase)
  {
    switch (_phrase)
    {
      case StackOperations.Clear() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new ClearToken());
      
          ve0 = ve;
           System.out.println("TokensList: " + ve0.toString()); 
          return ve0;
        };
      }
      case StackOperations.Id() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          ve0 = ve;
           System.out.println("TokensList: " + ve0.toString()); 
          return ve0;
        };
      }
      case StackOperations.Pop() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new PopToken());
      
          ve0 = ve;
           System.out.println("TokensList: " + ve0.toString()); 
          return ve0;
        };
      }
      case StackOperations.Dup() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new DupToken());
      
          ve0 = ve;
           System.out.println("TokensList: " + ve0.toString()); 
          return ve0;
        };
      }
      case StackOperations.Over() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new OverToken());
      
          ve0 = ve;
           System.out.println("TokensList: " + ve0.toString()); 
          return ve0;
        };
      }
      case StackOperations.Swap() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new SwapToken());
      
          ve0 = ve;
           System.out.println("TokensList: " + ve0.toString()); 
          return ve0;
        };
      }
      case StackOperations.Rotl() ->
      {
        return (_Operation)(var ve) -> 
        {
          List<IToken> ve0;
          
        ve.add(new RotlToken());
      
          ve0 = ve;
           System.out.println("TokensList: " + ve0.toString()); 
          return ve0;
        };
      }
    }
  }
}
