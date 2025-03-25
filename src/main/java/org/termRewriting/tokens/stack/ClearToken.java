package org.termRewriting.tokens.stack;

import org.termRewriting.tokens.constant.BoolToken;
import org.termRewriting.tokens.constant.IntToken;
import org.termRewriting.tokens.interfaces.ILogicToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;

public class ClearToken implements IToken {
    private List<IToken> tokens;

    public ClearToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        return List.of();
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public List<IToken> minimalize() {
        List<IToken> newTokens =  new LinkedList<>();
        boolean onlyPrimitiveTypes = true;
        for(IToken token : tokens){
            if(!(token instanceof BoolToken) && !(token instanceof IntToken)){
                onlyPrimitiveTypes = false;
            }
            newTokens.addAll(token.minimalize());
        }
        tokens = newTokens;
        if(onlyPrimitiveTypes) {
            return null;
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
        return stringBuilder.append("CLEAR").toString();
    }
}
