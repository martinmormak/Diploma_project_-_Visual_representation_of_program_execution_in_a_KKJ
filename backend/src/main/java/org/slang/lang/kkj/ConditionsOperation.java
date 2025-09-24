
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
