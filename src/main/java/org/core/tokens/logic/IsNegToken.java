package org.core.tokens.logic;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IsNegToken implements IFunctionToken {
    private List<IToken> tokens;

    public IsNegToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    /*@Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }

        if(availableTokensFormToken.removeLast() == IArithmeticToken.class) {
            availableTokensFormToken.add(ILogicToken.class);
            return availableTokensFormToken;
        }else {
            throw new RuntimeException("Expected one numeral but don't get it for IsNegToken");
        }
    }*/

    @Override
    public Boolean getValue() {
        if(tokens.getLast() instanceof IntToken) {
            return ((IntToken)tokens.getLast()).getValue() < 0;
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
            if (!tokens.isEmpty()) {
                if (tokens.getLast() instanceof IntToken) {
                    IToken result = new BoolToken(getValue());
                    substitutions.add(this + " -> " + result);
                    tokens.removeLast();
                    tokens.add(result);
                    return tokens;
                } else {
                    throw new RuntimeException("Expected IntToken and get " + tokens.getLast().getClass().getSimpleName());
                }
            } else {
                throw new RuntimeException("Tokens size must be >= 1 items and is " + (tokens.isEmpty() ? "empty" : tokens.size()));
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
        if(!stack.isEmpty()) {
            IToken pop = stack.pop();
            if (pop instanceof IntToken) {
                IToken result = new BoolToken(((IntToken) pop).getValue() < 0);
                stack.push(result);
            } else {
                throw new RuntimeException("Expected IntToken and get " + pop.getClass().getSimpleName());
            }
        } else {
            throw new RuntimeException("In stack must be >= 1 items and is empty");
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(IToken token : tokens){
            stringBuilder.append(token).append(" ");
        }
        return stringBuilder.append("ISNEG").toString();
    }

    @Override
    public IFunctionToken clone() {
        List<IToken> tokensClone = new LinkedList<>();
        for (IToken token : tokens) {
            tokensClone.add(token.clone());
        }
        return new IsNegToken(tokensClone);
    }
}
