package org.termRewriting.tokens.logic;

import org.termRewriting.tokens.constant.BoolToken;
import org.termRewriting.tokens.constant.IntToken;
import org.termRewriting.tokens.interfaces.IFunctionToken;
import org.termRewriting.tokens.interfaces.ILogicToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AndToken implements IFunctionToken {
    private List<IToken> tokens;

    public AndToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }

        if(availableTokensFormToken.removeLast() == ILogicToken.class && availableTokensFormToken.removeLast() == ILogicToken.class) {
            availableTokensFormToken.add(ILogicToken.class);
            return availableTokensFormToken;
        }else {
            throw new RuntimeException("Expected two boolean but dont get it for AndToken");
        }
    }

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
            if(!(token instanceof BoolToken)){
                onlyPrimitiveTypes = false;
            }
            newTokens.addAll(token.termRewritingSolving(substitutions));
        }
        tokens = newTokens;
        if(onlyPrimitiveTypes) {
            IToken result = new BoolToken(getValue());
            substitutions.add(this + " -> " + result.getValue());
            tokens.removeLast();
            tokens.removeLast();
            tokens.add(result);
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
            BoolToken pop = (BoolToken) stack.pop();
            IToken result = new BoolToken(((BoolToken) stack.pop()).getValue() && pop.getValue());
            stack.push(result);
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
}
