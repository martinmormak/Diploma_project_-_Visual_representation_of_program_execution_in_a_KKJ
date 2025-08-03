
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public sealed interface ConditionsOperation permits
ConditionsOperation.Choose, ConditionsOperation.While
{
  public record Choose() implements ConditionsOperation
  {
    public String toString()
    {
      String _result;
       _result = "IF"; 
      return _result;
    }
  }
  public record While() implements ConditionsOperation
  {
    public String toString()
    {
      String _result;
       _result = "WHILE"; 
      return _result;
    }
  }
}
