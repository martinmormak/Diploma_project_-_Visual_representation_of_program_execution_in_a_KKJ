
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public sealed interface StackOperations permits
StackOperations.Clear, StackOperations.Id, StackOperations.Pop, StackOperations.Dup, StackOperations.Over, StackOperations.Swap, StackOperations.Rotl
{
  public record Clear() implements StackOperations
  {
    public String toString()
    {
      String _result;
       _result = "\n"; 
      return _result;
    }
  }
  public record Id() implements StackOperations
  {
    public String toString()
    {
      String _result;
       _result = "ID"; 
      return _result;
    }
  }
  public record Pop() implements StackOperations
  {
    public String toString()
    {
      String _result;
       _result = "POP"; 
      return _result;
    }
  }
  public record Dup() implements StackOperations
  {
    public String toString()
    {
      String _result;
       _result = "DUP"; 
      return _result;
    }
  }
  public record Over() implements StackOperations
  {
    public String toString()
    {
      String _result;
       _result = "OVER"; 
      return _result;
    }
  }
  public record Swap() implements StackOperations
  {
    public String toString()
    {
      String _result;
       _result = "SWAP"; 
      return _result;
    }
  }
  public record Rotl() implements StackOperations
  {
    public String toString()
    {
      String _result;
       _result = "ROTL"; 
      return _result;
    }
  }
}
