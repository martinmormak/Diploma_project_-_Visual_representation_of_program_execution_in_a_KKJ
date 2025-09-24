package org;

import org.slang.lang.kkj.*;
import org.core.Tokenizer;
import org.core.tokens.interfaces.IToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KKJMain {
    private static final ConfigReader configReader = new ConfigReader();

    public static void main(String[] args) {
        // read input
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String text = input.nextLine();

        System.out.println("From input: " + text);

        // replace commands sing map
        text = StringProcessor.replaceByPatterns(text);

        System.out.println("After map replacing: " + text);

        // Apply POPn replacements
        text = StringProcessor.replacePopOccurrences(text);

        System.out.println("After pop replacing: " + text);

        // Apply toUpperCase replacements
        text = text.toUpperCase();

        System.out.println("After to upper case replacing: " + text);

        List<IToken> tokens = new LinkedList<>();

        if (configReader.getToggleState("slangEnabled")) {
            Program program = KKJ_parser.parseProgram(text);
            System.out.println(program);
            Program_program.operation(program).apply();
            tokens = Program_.operation(program).apply();
            System.out.println("TOKENS: " + tokens);
        } else {
            Tokenizer tokenizer = new Tokenizer();
            tokens = tokenizer.getTokenList(text);
        }
        if (configReader.getToggleState("termRewritingEnabled")) {
                /*for (IToken token : tokens) {
                    while (!termRewritingIsSolved(token)) {
                        List<String> substitutions = new ArrayList<>();
                        List<IToken> newTokens = new LinkedList<>();
                        if (token != null) {
                            System.out.print(token);
                            newTokens.addAll(token.termRewritingSolving(substitutions));
                            if (!newTokens.isEmpty() && newTokens.getLast() == null) {
                                newTokens.removeLast();
                            }
                        }
                        System.out.print("\t\t");
                        for(int index = substitutions.size() - 1; index >= 0; index--) {
                            System.out.print(substitutions.get(index) + ", ");
                        }
                        System.out.println();
                        token = newTokens.getFirst();
                    }
                    System.out.println(token);
                    System.out.println();
                }*/
        } else {
            Stack<IToken> stack = new Stack<>();
            for (IToken iToken : tokens) {
                System.out.print(iToken + " ");
            }
            System.out.println();
            while (!tokens.isEmpty()) {
                IToken token = tokens.removeFirst();
                List<IToken> newTokens = new LinkedList<>();
                while (token != null) {
                    List<IToken> returnTokens = token.stackSolving(stack);
                    if (returnTokens != null && !returnTokens.isEmpty()) {
                        newTokens.addAll(0, returnTokens);
                    }
                    if (!newTokens.isEmpty() && newTokens.getLast() == null) {
                        newTokens.removeLast();
                    }

                    for (IToken iToken : newTokens) {
                        System.out.print(iToken + " ");
                    }
                    for (IToken iToken : tokens) {
                        System.out.print(iToken + " ");
                    }

                    System.out.print("\t|\t");
                    for (IToken iToken : stack) {
                        System.out.print(iToken + " ");
                    }
                    System.out.println();
                    if(!newTokens.isEmpty()) {
                        token = newTokens.removeFirst();
                    } else {
                        token = null;
                    }
                }
            }
        }
        System.out.println();
    }
}