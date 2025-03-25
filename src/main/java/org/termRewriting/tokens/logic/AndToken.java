package org.termRewriting.tokens.logic;

import org.termRewriting.tokens.constant.BoolToken;
import org.termRewriting.tokens.constant.IntToken;
import org.termRewriting.tokens.interfaces.ILogicToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AndToken implements ILogicToken {
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
            throw new RuntimeException("Expected two numerals but dont get it for AndToken");
        }
    }

    @Override
    public Boolean getValue() {
        if(tokens.getLast() instanceof BoolToken && tokens.get(tokens.size()-2) instanceof BoolToken) {
            return ((BoolToken)tokens.getLast()).getValue() && ((BoolToken)tokens.get(tokens.size()-2)).getValue();
        }
        return null;
    }

    @Override
    public List<IToken> minimalize() {
        List<IToken> newTokens =  new LinkedList<>();
        boolean onlyPrimitiveTypes = true;
        for(IToken token : tokens){
            if(!(tokens.getLast() instanceof BoolToken)){
                onlyPrimitiveTypes = false;
            }
            newTokens.addAll(token.minimalize());
        }
        tokens = newTokens;
        if(onlyPrimitiveTypes) {
            IToken result = new BoolToken(getValue());
            tokens.removeLast();
            tokens.removeLast();
            tokens.add(result);
            return tokens;
        }else {
            return List.of(this);
        }
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
