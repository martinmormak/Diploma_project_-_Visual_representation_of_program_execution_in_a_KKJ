
      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    
import java.io.*;
import java.nio.charset.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
public final class KKJ_parser
{
  private static class ErrorListener extends BaseErrorListener
  {
    private int errors = 0;
    public void syntaxError(Recognizer<?,?> recognizer,
      Object offendingSymbol, int line, int charPositionInLine,
      String msg, RecognitionException e)
    {
      errors++;
    }
  }
  public static Program parseProgram()
  {
     return parseProgram(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static Program parseProgram(File file) throws FileNotFoundException
  {
     return parseProgram(new FileReader(file));
  }
  public static Program parseProgram(String text)
  {
     return parseProgram(new StringReader(text));
  }
  public static Program parseProgram(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KKJLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KKJParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dProgram()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
  public static Sequence parseSequence()
  {
     return parseSequence(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static Sequence parseSequence(File file) throws FileNotFoundException
  {
     return parseSequence(new FileReader(file));
  }
  public static Sequence parseSequence(String text)
  {
     return parseSequence(new StringReader(text));
  }
  public static Sequence parseSequence(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KKJLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KKJParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dSequence()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
  public static Constant parseConstant()
  {
     return parseConstant(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static Constant parseConstant(File file) throws FileNotFoundException
  {
     return parseConstant(new FileReader(file));
  }
  public static Constant parseConstant(String text)
  {
     return parseConstant(new StringReader(text));
  }
  public static Constant parseConstant(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KKJLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KKJParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dConstant()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
  public static ArithmeticOperations parseArithmeticOperations()
  {
     return parseArithmeticOperations(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static ArithmeticOperations parseArithmeticOperations(File file) throws FileNotFoundException
  {
     return parseArithmeticOperations(new FileReader(file));
  }
  public static ArithmeticOperations parseArithmeticOperations(String text)
  {
     return parseArithmeticOperations(new StringReader(text));
  }
  public static ArithmeticOperations parseArithmeticOperations(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KKJLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KKJParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dArithmeticOperations()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
  public static LogicalOperations parseLogicalOperations()
  {
     return parseLogicalOperations(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static LogicalOperations parseLogicalOperations(File file) throws FileNotFoundException
  {
     return parseLogicalOperations(new FileReader(file));
  }
  public static LogicalOperations parseLogicalOperations(String text)
  {
     return parseLogicalOperations(new StringReader(text));
  }
  public static LogicalOperations parseLogicalOperations(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KKJLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KKJParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dLogicalOperations()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
  public static StackOperations parseStackOperations()
  {
     return parseStackOperations(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static StackOperations parseStackOperations(File file) throws FileNotFoundException
  {
     return parseStackOperations(new FileReader(file));
  }
  public static StackOperations parseStackOperations(String text)
  {
     return parseStackOperations(new StringReader(text));
  }
  public static StackOperations parseStackOperations(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KKJLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KKJParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dStackOperations()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
  public static FunctionOperations parseFunctionOperations()
  {
     return parseFunctionOperations(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static FunctionOperations parseFunctionOperations(File file) throws FileNotFoundException
  {
     return parseFunctionOperations(new FileReader(file));
  }
  public static FunctionOperations parseFunctionOperations(String text)
  {
     return parseFunctionOperations(new StringReader(text));
  }
  public static FunctionOperations parseFunctionOperations(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KKJLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KKJParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dFunctionOperations()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
  public static ConditionsOperation parseConditionsOperation()
  {
     return parseConditionsOperation(new BufferedReader(new InputStreamReader(System.in)));
  }
  public static ConditionsOperation parseConditionsOperation(File file) throws FileNotFoundException
  {
     return parseConditionsOperation(new FileReader(file));
  }
  public static ConditionsOperation parseConditionsOperation(String text)
  {
     return parseConditionsOperation(new StringReader(text));
  }
  public static ConditionsOperation parseConditionsOperation(Reader reader)
  {
    try
    {
      var input = CharStreams.fromReader(reader);
      var lexer = new KKJLexer(input);
      var tokens = new CommonTokenStream(lexer);
      var parser = new KKJParser(tokens);
      var listener = new ErrorListener();
      parser.addErrorListener(listener);
      var result = parser.dConditionsOperation()._result;
    if (listener.errors > 0)
    {
      // System.out.println(listener.errors + " syntax errors.");
      throw new RuntimeException(listener.errors + " syntax errors");
    }
    return result;
    }
    catch(Exception e)
    {
      // var writer = new StringWriter();
      // e.printStackTrace(new PrintWriter(writer));
      // System.out.println("parser error (" + writer.toString() +")");
      throw new RuntimeException("parser error (" + e.getMessage() +")");
    }
  }
}
