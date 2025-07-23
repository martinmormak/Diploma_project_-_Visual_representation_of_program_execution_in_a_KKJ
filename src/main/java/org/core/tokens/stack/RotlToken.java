package org.core.tokens.stack;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RotlToken implements IFunctionToken {
    private List<IToken> tokens;

    public RotlToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    /*@Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }

        availableTokensFormToken.add(availableTokensFormToken.remove(availableTokensFormToken.size()-3));
        return availableTokensFormToken;
    }*/

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public List<IToken> termRewritingSolving(List<String> substitutions) {
        List<IToken> newTokens =  new LinkedList<>();
        boolean onlyPrimitiveTypes = true;
        for(IToken token : tokens){
            if(!(token instanceof BoolToken) && !(token instanceof IntToken)){
                onlyPrimitiveTypes = false;
            }
            newTokens.addAll(token.termRewritingSolving(substitutions));
        }
        tokens = newTokens;
        if(onlyPrimitiveTypes) {
            if (tokens.size() >= 3) {
                substitutions.add(this + " -> " + tokens.get(tokens.size() - 2) + " " + tokens.getLast() + " " + tokens.get(tokens.size() - 3));
                tokens.add(tokens.remove(tokens.size() - 3));
                return tokens;
            } else {
                throw new RuntimeException("Tokens size must be >= 3 and is " + (tokens.isEmpty() ? "empty" : tokens.size()));
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
        if(stack.size()>=3) {
            IToken pop1 = stack.pop();
            IToken pop2 = stack.pop();
            IToken pop3 = stack.pop();
            stack.push(pop2);
            stack.push(pop1);
            stack.push(pop3);
        } else {
            throw new RuntimeException("In stack must be >= 3 items and is " + (stack.isEmpty() ? "empty" : stack.size()));
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(IToken token : tokens){
            stringBuilder.append(token).append(" ");
        }
        return stringBuilder.append("ROTL").toString();
    }

    @Override
    public IFunctionToken clone() {
        List<IToken> tokensClone = new LinkedList<>();
        for (IToken token : tokens) {
            tokensClone.add(token.clone());
        }
        return new RotlToken(tokensClone);
    }
}
