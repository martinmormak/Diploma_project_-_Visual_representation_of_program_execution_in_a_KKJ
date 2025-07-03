package org.termRewriting.tokens.aritmetic;

import org.termRewriting.tokens.constant.IntToken;
import org.termRewriting.tokens.interfaces.IArithmeticToken;
import org.termRewriting.tokens.interfaces.IFunctionToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AddToken implements IFunctionToken {
    private List<IToken> tokens;

    public AddToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }

        if(availableTokensFormToken.removeLast() == IArithmeticToken.class && availableTokensFormToken.removeLast() == IArithmeticToken.class) {
            availableTokensFormToken.add(IArithmeticToken.class);
            return availableTokensFormToken;
        }else {
            throw new RuntimeException("Expected two numerals but dont get it for AddToken");
        }
    }

    @Override
    public Integer getValue() {
        if(tokens.getLast() instanceof IntToken && tokens.get(tokens.size()-2) instanceof IntToken) {
            return ((IntToken)tokens.get(tokens.size()-2)).getValue() + ((IntToken)tokens.getLast()).getValue();
        }
        return null;
    }

    @Override
    public List<IToken> termRewritingSolving(List<String> substitutions) {
        List<IToken> newTokens =  new LinkedList<>();
        boolean onlyPrimitiveTypes = true;
        for(IToken token : tokens){
            if(!(token instanceof IntToken)){
                onlyPrimitiveTypes = false;
            }
            newTokens.addAll(token.termRewritingSolving(substitutions));
        }
        tokens = newTokens;
        if(onlyPrimitiveTypes) {
            IToken result = new IntToken(getValue());
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
            IntToken pop = (IntToken) stack.pop();
            IToken result = new IntToken(((IntToken) stack.pop()).getValue() + pop.getValue());
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
        return stringBuilder.append("ADD").toString();
    }
}
