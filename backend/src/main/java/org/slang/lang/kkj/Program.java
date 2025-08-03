
      package org.slang.lang.kkj;
      import java.util.*;
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
