package org.core.tokens.quotation;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CombinationToken implements IFunctionToken {
    private final List<IToken> tokens;

    public CombinationToken(List<IToken> tokens) {
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
            if(!tokens.isEmpty()) {
                return new LinkedList<>(List.of(this));
            }
        }
        return null;
    }

    @Override
    public IToken clone() {
        List<IToken> tokensClone = new LinkedList<>();
        for (IToken token : tokens) {
            tokensClone.add(token.clone());
        }
        return new CombinationToken(tokensClone);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(this.tokens.size() > 1 || !(this.tokens.getFirst() instanceof CombinationToken)) {
            stringBuilder.append("( ");
        }
        for(IToken token : tokens){
            stringBuilder.append(token).append(" ");
        }
        if(!stringBuilder.isEmpty()){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if(this.tokens.size() > 1 || !(this.tokens.getFirst() instanceof CombinationToken)) {
            stringBuilder.append(" )");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toJSON() {
        StringBuilder stringBuilder = new StringBuilder();
        if(this.tokens.size() > 1 || !(this.tokens.getFirst() instanceof CombinationToken)) {
            stringBuilder.append("( ");
        }
        for(IToken token : tokens){
            stringBuilder.append(token.toJSON()).append(" ");
        }
        if(!stringBuilder.isEmpty()){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if(this.tokens.size() > 1 || !(this.tokens.getFirst() instanceof CombinationToken)) {
            stringBuilder.append(" )");
        }
        return stringBuilder.toString();
    }
}
