
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
    
public sealed interface Constant permits
Constant.PosNum, Constant.NegNum, Constant.True, Constant.False
{
  public record PosNum(String _1) implements Constant
  {
    public String toString()
    {
      var n = _1;
      String _result;
       _result = n; 
      return _result;
    }
  }
  public record NegNum(String _1) implements Constant
  {
    public String toString()
    {
      var n = _1;
      String _result;
       _result = n; 
      return _result;
    }
  }
  public record True() implements Constant
  {
    public String toString()
    {
      String _result;
       _result = "TRUE"; 
      return _result;
    }
  }
  public record False() implements Constant
  {
    public String toString()
    {
      String _result;
       _result = "FALSE"; 
      return _result;
    }
  }
}
