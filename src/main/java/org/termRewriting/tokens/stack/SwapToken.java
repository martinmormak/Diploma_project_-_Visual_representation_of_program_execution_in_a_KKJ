package org.termRewriting.tokens.stack;

import org.termRewriting.tokens.constant.BoolToken;
import org.termRewriting.tokens.constant.IntToken;
import org.termRewriting.tokens.interfaces.IFunctionToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SwapToken implements IFunctionToken {
    private List<IToken> tokens;

    public SwapToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }

        availableTokensFormToken.add(availableTokensFormToken.remove(availableTokensFormToken.size()-2));
        return availableTokensFormToken;
    }

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
            substitutions.add(this + " -> " + tokens.getLast() + " " + tokens.get(tokens.size()-2));
            tokens.add(tokens.remove(tokens.size()-2));
            return tokens;
        }else {
            return List.of(this);
        }
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(!tokens.isEmpty()) {
            if(tokens.getFirst().stackSolving(stack) == null) {
                tokens.removeFirst();
            }
            return List.of(this);
        }
        if(stack.size()>=2) {
            IToken pop1 = stack.pop();
            IToken pop2 = stack.pop();
            stack.push(pop1);
            stack.push(pop2);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(IToken token : tokens){
            stringBuilder.append(token).append(" ");
        }
        return stringBuilder.append("SWAP").toString();
    }
}
