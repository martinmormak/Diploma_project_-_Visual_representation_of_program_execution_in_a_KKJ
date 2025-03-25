package org.termRewriting.tokens.stack;

import org.termRewriting.tokens.constant.BoolToken;
import org.termRewriting.tokens.constant.IntToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PopToken implements IToken {
    private List<IToken> tokens;

    public PopToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }
        availableTokensFormToken.removeLast();
        return availableTokensFormToken;
    }

    @Override
    public Boolean getValue() {
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
            tokens.removeLast();
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
        return stringBuilder.append("POP").toString();
    }
}

