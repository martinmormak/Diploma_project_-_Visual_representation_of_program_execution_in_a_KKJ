package org.core.tokens.quotation;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CompositionToken implements IFunctionToken {
    private final List<IToken> tokens;

    public CompositionToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    public List<IToken> getTokens() {
        return tokens;
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(!tokens.isEmpty()) {
            List<IToken> result = tokens.removeFirst().stackSolving(stack);
            if (result != null && !result.isEmpty()) {
                tokens.addAll(0, result);
            }
            return List.of(this);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("( ");
        for(IToken token : tokens){
            stringBuilder.append(token).append(" ");
        }
        return stringBuilder.append(")").toString();
    }

    @Override
    public IToken clone() {
        List<IToken> tokensClone = new LinkedList<>();
        for (IToken token : tokens) {
            tokensClone.add(token.clone());
        }
        return new CompositionToken(tokensClone);
    }
}
