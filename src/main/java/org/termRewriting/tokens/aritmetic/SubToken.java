package org.termRewriting.tokens.aritmetic;

import org.termRewriting.tokens.constant.BoolToken;
import org.termRewriting.tokens.constant.IntToken;
import org.termRewriting.tokens.interfaces.IArithmeticToken;
import org.termRewriting.tokens.interfaces.IFunctionToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubToken implements IFunctionToken {
    private List<IToken> tokens;

    public SubToken(List<IToken> tokens) {
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
            throw new RuntimeException("Expected two numerals but dont get it for SubToken");
        }
    }

    @Override
    public Integer getValue() {
        if(tokens.getLast() instanceof IntToken && tokens.get(tokens.size()-2) instanceof IntToken) {
            return ((IntToken)tokens.getLast()).getValue() - ((IntToken)tokens.get(tokens.size()-2)).getValue();
        }
        return null;
    }

    @Override
    public List<IToken> minimalize() {
        List<IToken> newTokens =  new LinkedList<>();
        boolean onlyPrimitiveTypes = true;
        for(IToken token : tokens){
            if(!(token instanceof IntToken)){
                onlyPrimitiveTypes = false;
            }
            newTokens.addAll(token.minimalize());
        }
        tokens = newTokens;
        if(onlyPrimitiveTypes) {
            IToken result = new IntToken(getValue());
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
        return stringBuilder.append("SUB").toString();
    }
}
