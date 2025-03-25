package org.example;

import org.slang.lang.kkj.*;
import org.termRewriting.Tokenizer;
import org.termRewriting.tokens.constant.BoolToken;
import org.termRewriting.tokens.constant.IntToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KKJMain
{
  private static final ConfigReader configReader = new ConfigReader();

  private static final Map<String, String> functions = Map.ofEntries(
          Map.entry("PRED", "1 SUB"),
          Map.entry("SUCC", "1 ADD"),
          Map.entry("NEG", "0 SWAP SUB"),
          Map.entry("ISZERO", "DUP ISNEG NOT SWAP ISPOS NOT AND"),
          Map.entry("LT", "CMP ISNEG"),
          Map.entry("LE", "CMP DUP ISNEG SWAP ISZERO OR"),
          Map.entry("EQ", "CMP ISZERO"),
          Map.entry("NE", "EQ NOT"),
          Map.entry("GE", "LT NOT"),
          Map.entry("GT", "LE NOT"),
          Map.entry("OR", "NOT SWAP NOT AND NOT"),
          Map.entry("SQUARE", "DUP MUL"),
          Map.entry("SWAPOVER", "ROTL SWAP"),
          Map.entry("ROTR", "ROTL ROTL"),
          Map.entry("MIRROR", "ROTL ROTL SWAP"),
          Map.entry("DUP2", "OVER OVER"),
          Map.entry("CONS", "SWAP QUOTE SWAP COMPOSE"),
          Map.entry("QUOTE2", "QUOTE CONS"),
          Map.entry("PICK2", "QUOTE2 OVER APPLYOVER")
  ).entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey().trim(), Map.Entry::getValue));

  public static void main(String[] args)
  {
    // read input
    Scanner input = new Scanner (new BufferedReader(new InputStreamReader(System.in)));
    String text = input.nextLine();

    System.out.println("From input: "+text);

    // replace commands sing map
    text = replace(text);

    System.out.println("After map replacing: "+text);

    // Apply POPn replacements
    text = replacePopOccurrences(text);

    System.out.println("After pop replacing: "+text);

    if (configReader.getToggleState("slangEnabled")) {

      Program program = KKJ_parser.parseProgram(text);

      System.out.println(program);

      Program_program.operation(program).apply();

      Program_.operation(program).apply();
    } else {
      Tokenizer tokenizer = new Tokenizer();
      List<IToken> tokens = tokenizer.getTokenList(text);
      while(!isSolved(tokens)) {
        List<IToken> newTokens =  new LinkedList<>();
        for (IToken token : tokens) {
          System.out.print(token + " ");
          if (token != null) {
            newTokens.addAll(token.minimalize());
            if(!newTokens.isEmpty() && newTokens.getLast()==null){
              newTokens.removeLast();
            }
          }
        }
        System.out.println();
        tokens = newTokens;
      }
      for (IToken token : tokens) {
        System.out.print(token + " ");
      }
      System.out.println();
    }
  }

  private static boolean isSolved(List<IToken> tokens) {
    for(IToken token : tokens) {
      if(!(token instanceof IntToken || token instanceof BoolToken)) {
        return false;
      }
    }
    return true;
  }

  private static String replace(String text) {
    int loop = 100;

    do {
      String prevText = text;

      List<Map.Entry<String, String>> sortedEntries = functions.entrySet().stream()
              .sorted((entry1, entry2) -> Integer.compare(entry2.getKey().length(), entry1.getKey().length())) // Sort by length descending
              .toList();

      for (Map.Entry<String, String> entry : sortedEntries) {
        String key = entry.getKey();
        String value = entry.getValue();

        // Case-insensitive word boundary matching
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(key) + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        text = matcher.replaceAll(value);
      }

      // Remove extra spaces
      text = text.replaceAll(" {2}", " ").trim();

      if (text.equals(prevText)) {
        break;
      }

      loop--;
      if (loop == 0) {
        throw new RuntimeException("The program is trying to loop indefinitely");
      }

    } while (true);

    return text;
  }

  private static String replacePopOccurrences(String input) {
    Pattern pattern = Pattern.compile("\\bPOP(\\d+)\\b", Pattern.CASE_INSENSITIVE); // Match POP followed by a number
    Matcher matcher = pattern.matcher(input);
    StringBuffer result = new StringBuffer();

    while (matcher.find()) {
      int num = Integer.parseInt(matcher.group(1)); // Extract the number
      String replacement = generatePop(num); // Generate replacement string
      matcher.appendReplacement(result, replacement);
    }
    matcher.appendTail(result);

    return result.toString();
  }

  private static String generatePop(int n) {
    return IntStream.range(0, n).mapToObj(i -> "POP").collect(Collectors.joining(" "));
  }
}