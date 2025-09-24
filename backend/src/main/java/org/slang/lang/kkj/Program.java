
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
    
public sealed interface Program permits
Program.Prog
{
  public record Prog(Sequence _1) implements Program
  {
    public String toString()
    {
      var s = _1;
      String _result;
       _result = s.toString(); 
      return _result;
    }
  }
}
