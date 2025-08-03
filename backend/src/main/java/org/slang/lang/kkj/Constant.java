
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public sealed interface Constant permits
Constant.Num, Constant.True, Constant.False
{
  public record Num(String _1) implements Constant
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
