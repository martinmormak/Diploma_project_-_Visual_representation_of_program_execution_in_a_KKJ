package org.server.JSON;

import org.core.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class JSONRepresentation {
    List<IToken> tokens;
    Stack<IToken> stack;

    public JSONRepresentation(List<IToken> tokens) {
        this.tokens = new LinkedList<>();
        for (IToken token : tokens) {
            this.tokens.add(token.clone());
        }
        this.stack = new Stack<>();
    }

    public JSONRepresentation(List<IToken> newTokens, List<IToken> tokens, Stack<IToken> stack) {
        this.tokens = new LinkedList<>();
        for (IToken token : newTokens) {
            this.tokens.add(token.clone());
        }
        for (IToken token : tokens) {
            this.tokens.add(token.clone());
        }
        this.stack = new Stack<>();
        for (IToken token : stack) {
            this.stack.add(token.clone());
        }
    }

    public String toJson() {
        String tokensJson = tokens.stream()
                .map(IToken::toJSON)
                .collect(Collectors.joining(" ", "[\"", "\"]"));
        String stackJson = stack.stream()
                .map(IToken::toJSON)
                .collect(Collectors.joining(" ", "[\"", "\"]"));

        return String.format("{\"tokens\": %s, \"stack\": %s}", tokensJson, stackJson);
    }
}
