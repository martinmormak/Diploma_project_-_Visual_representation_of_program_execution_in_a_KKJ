
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
public final class KKJ
{

    public enum Type { Int }
    public static class Env
    {
      private HashMap<String,Value> variables = new HashMap<>();
      private List<Stack<Value>> stacks = new LinkedList<>();
      public Env()
      { super(); stacks.add(new Stack<>()); }
      public void put(String key, Value value)
      { variables.put(key.toString(), value); }
      public Value get(String key)
      { return variables.get(key.toString()); }
      public String printVariables()
      { return variables.toString(); }
      public void push(Value value)
      { stacks.getLast().push(value); }
      public Value peek()
      { if (!stacks.getLast().isEmpty()) { return stacks.getLast().peek(); } else { throw new IllegalStateException("Cannot peek from an empty stack."); } }
      public Value pop()
      { if (!stacks.getLast().isEmpty()) { return stacks.getLast().pop(); } else { throw new IllegalStateException("Cannot pop from an empty stack."); } }
      public String printStack()
      { return stacks.getLast().toString(); }
      public  String printStackHistory()
      { return stacks.toString(); }
      public void newStack()
      { stacks.add(new Stack<>()); }
    }
    public static class TypeError extends RuntimeException
    { public TypeError(String msg) { super(msg); } }
    public static void check(Boolean b, String msg)
    { if (!b) throw new TypeError(msg); }
    sealed interface Value permits IntegerValue, StringValue, BoolValue { Object getValue(); }
    record IntegerValue(Integer value) implements Value
    { @Override public Integer getValue() { return value; } @Override public String toString() { return String.valueOf(value); } }
    record StringValue(String value) implements Value
    { @Override public String getValue() { return value; } @Override public String toString() { return value; } }
    record BoolValue(Boolean value) implements Value
    { @Override public Boolean getValue() { return value; } @Override public String toString() { return String.valueOf(value); } }
  
    public static class Failure extends RuntimeException { }
    public static void check(Boolean b) { if (!b) throw new Failure(); }
  
}
