
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class Program_
{
  public static interface _Operation
  {
    public Void apply();
  }
  public static interface _BeforeEffect
  {
    public void apply();
  }
  public static interface _AfterEffect
  {
    public void apply(Void _1);
  }
  public static _Operation operation(Program _phrase)
  {
    switch (_phrase)
    {
      case Program.Prog(var c) ->
      {
        var _1 = Sequence_.operation(c);
        return (_Operation)() -> 
        {
          Void none;
          Env ve0 =  new Env() ;
          Env ve1 = _1.apply(ve0);
          none =  null; System.out.println("Result"); System.out.println("STACK : " + ve0.printStack());  System.out.println("STACK HISTORY : " + ve0.printStackHistory());  System.out.println("Result  = " + ve1.peek()) ;
          return none;
        };
      }
    }
  }
}
