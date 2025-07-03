package org.termRewriting.tokens.logic;

import org.termRewriting.tokens.constant.BoolToken;
import org.termRewriting.tokens.constant.IntToken;
import org.termRewriting.tokens.interfaces.IArithmeticToken;
import org.termRewriting.tokens.interfaces.IFunctionToken;
import org.termRewriting.tokens.interfaces.ILogicToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IsNegToken implements IFunctionToken {
    private List<IToken> tokens;

    public IsNegToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }

        if(availableTokensFormToken.removeLast() == IArithmeticToken.class) {
            availableTokensFormToken.add(ILogicToken.class);
            return availableTokensFormToken;
        }else {
            throw new RuntimeException("Expected one numeral but dont get it for IsNegToken");
        }
    }

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
            if(!(token instanceof IntToken)){
                onlyPrimitiveTypes = false;
            }
            newTokens.addAll(token.termRewritingSolving(substitutions));
        }
        tokens = newTokens;
        if(onlyPrimitiveTypes) {
            IToken result = new BoolToken(getValue());
            substitutions.add(this + " -> " + result.getValue());
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
        if(!stack.isEmpty()) {
            IToken result = new BoolToken(((IntToken) stack.pop()).getValue() < 0);
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
        return stringBuilder.append("ISNEG").toString();
    }
}
