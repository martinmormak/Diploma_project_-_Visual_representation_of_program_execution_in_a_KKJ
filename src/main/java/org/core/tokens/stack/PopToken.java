package org.core.tokens.stack;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PopToken implements IFunctionToken {
    private List<IToken> tokens;

    public PopToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    /*@Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }
        availableTokensFormToken.removeLast();
        return availableTokensFormToken;
    }*/

    @Override
    public Boolean getValue() {
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
            if (!tokens.isEmpty()) {
                substitutions.add(this + " -> \"\"");
                tokens.removeLast();
                return tokens;
            } else {
                throw new RuntimeException("Tokens size must be >= 1 and is empty");
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
            stack.pop();
        } else {
            throw new RuntimeException("In stack must be >= 1 itemsand is empty");
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(IToken token : tokens){
            stringBuilder.append(token).append(" ");
        }
        return stringBuilder.append("POP").toString();
    }

    @Override
    public IFunctionToken clone() {
        List<IToken> tokensClone = new LinkedList<>();
        for (IToken token : tokens) {
            tokensClone.add(token.clone());
        }
        return new PopToken(tokensClone);
    }
}

