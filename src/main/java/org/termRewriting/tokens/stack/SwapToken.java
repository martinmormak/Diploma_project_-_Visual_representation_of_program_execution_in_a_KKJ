package org.termRewriting.tokens.stack;

import org.termRewriting.tokens.constant.BoolToken;
import org.termRewriting.tokens.constant.IntToken;
import org.termRewriting.tokens.interfaces.IFunctionToken;
import org.termRewriting.tokens.interfaces.IToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

        availableTokensFormToken.add(availableTokensFormToken.getLast());
        return availableTokensFormToken;
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
            IToken top = tokens.removeLast();
            IToken secondTop = tokens.removeLast();
            tokens.add(top);
            tokens.add(secondTop);
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
        return stringBuilder.append("SWAP").toString();
    }
}
