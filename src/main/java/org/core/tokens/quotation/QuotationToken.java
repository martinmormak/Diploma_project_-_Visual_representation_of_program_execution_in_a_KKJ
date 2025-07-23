package org.core.tokens.quotation;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.logic.AndToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class QuotationToken implements IToken {
    private List<IToken> tokens;

    public QuotationToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    /*@Override
    public List<Class<? extends IToken>> getAvailableTokenList() {
        List<Class<? extends IToken>> availableTokensFormToken = new ArrayList<>();
        for (IToken token : tokens) {
            availableTokensFormToken.addAll(new ArrayList<>(token.getAvailableTokenList()));
        }

        return availableTokensFormToken;
    }*/

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public List<IToken> termRewritingSolving(List<String> substitutions) {
        List<IToken> newTokens =  new LinkedList<>();
        boolean onlyPrimitiveTypes = true;
        for(IToken token : tokens){
            if(!(token instanceof IntToken) && !(token instanceof BoolToken)) {
                onlyPrimitiveTypes = false;
            }
            newTokens.addAll(token.termRewritingSolving(substitutions));
        }
        tokens = newTokens;
        if(onlyPrimitiveTypes) {
            StringBuilder stringBuilder = new StringBuilder(this + " -> ");
            for(IToken token : tokens){
                stringBuilder.append(token).append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            substitutions.add(stringBuilder.toString());
            substitutions.add(toString());
            return tokens;
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
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");
        for(IToken token : tokens){
            stringBuilder.append(token).append(" ");
        }
        return stringBuilder.append("}").toString();
    }

    @Override
    public IToken clone() {
        List<IToken> tokensClone = new LinkedList<>();
        for (IToken token : tokens) {
            tokensClone.add(token.clone());
        }
        return new QuotationToken(tokensClone);
    }
}
