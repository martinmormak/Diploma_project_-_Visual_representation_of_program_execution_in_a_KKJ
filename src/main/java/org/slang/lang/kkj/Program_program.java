
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class Program_program
{
  public static interface _Operation
  {
    public void apply();
  }
  public static interface _BeforeEffect
  {
    public void apply();
  }
  public static interface _AfterEffect
  {
    public void apply();
  }
  public static _Operation operation(Program _phrase)
  {
    switch (_phrase)
    {
      case Program.Prog(var s) ->
      {
        var _1 = Sequence_sequence.operation(s);
        return (_Operation)() -> 
        {
          Env te = new Env();
          _1.apply(te);
        };
      }
    }
  }
}
