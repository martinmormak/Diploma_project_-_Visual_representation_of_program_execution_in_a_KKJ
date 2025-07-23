package org.core.tokens.logic;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.ILogicToken;
import org.core.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AndToken implements IFunctionToken {
    private List<IToken> tokens;

    public AndToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    /*@Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }

        if(availableTokensFormToken.removeLast() == ILogicToken.class && availableTokensFormToken.removeLast() == ILogicToken.class) {
            availableTokensFormToken.add(ILogicToken.class);
            return availableTokensFormToken;
        }else {
            throw new RuntimeException("Expected two boolean but don't get it for AndToken");
        }
    }*/

    @Override
    public Boolean getValue() {
        if(tokens.getLast() instanceof BoolToken && tokens.get(tokens.size()-2) instanceof BoolToken) {
            return ((BoolToken)tokens.get(tokens.size()-2)).getValue() && ((BoolToken)tokens.getLast()).getValue();
        }
        return null;
    }

    @Override
    public List<IToken> termRewritingSolving(List<String> substitutions) {
        List<IToken> newTokens =  new LinkedList<>();
        boolean onlyPrimitiveTypes = true;
        for(IToken token : tokens){
            if (!(token instanceof IntToken) && !(token instanceof BoolToken)) {
                onlyPrimitiveTypes = false;
            }
            newTokens.addAll(token.termRewritingSolving(substitutions));
        }
        tokens = newTokens;
        if(onlyPrimitiveTypes) {
            if (tokens.size() >= 2) {
                if (tokens.getLast() instanceof BoolToken && tokens.get(tokens.size() - 2) instanceof BoolToken) {
                    IToken result = new BoolToken(getValue());
                    substitutions.add(this + " -> " + result);
                    tokens.removeLast();
                    tokens.removeLast();
                    tokens.add(result);
                    return tokens;
                } else {
                    throw new RuntimeException("Expected BoolToken, BoolToken and get " + tokens.get(tokens.size() - 2).getClass().getSimpleName() + ", " + tokens.getLast().getClass().getSimpleName());
                }
            } else {
                throw new RuntimeException("Tokens size must be >= 2 and is " + (tokens.isEmpty() ? "empty" : tokens.size()));
            }
        }else {
            return List.of(this);
        }
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
        if(stack.size()>=2) {
            IToken pop1 = stack.pop();
            IToken pop2 = stack.pop();
            if (pop1 instanceof BoolToken && pop2 instanceof BoolToken) {
                IToken result = new BoolToken(((BoolToken) pop2).getValue() && ((BoolToken) pop1).getValue());
                stack.push(result);
            } else {
                throw new RuntimeException("Expected BoolToken, BoolToken and get " + pop2.getClass().getSimpleName() + ", " + pop1.getClass().getSimpleName());
            }
        } else {
            throw new RuntimeException("In stack must be >= 2 items and is " + (stack.isEmpty() ? "empty" : stack.size()));
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(IToken token : tokens){
            stringBuilder.append(token).append(" ");
        }
        return stringBuilder.append("AND").toString();
    }

    @Override
    public IFunctionToken clone() {
        List<IToken> tokensClone = new LinkedList<>();
        for (IToken token : tokens) {
            tokensClone.add(token.clone());
        }
        return new AndToken(tokensClone);
    }
}
