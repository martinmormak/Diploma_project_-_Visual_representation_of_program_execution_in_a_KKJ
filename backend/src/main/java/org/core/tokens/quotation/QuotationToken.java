package org.core.tokens.quotation;

import org.core.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class QuotationToken implements IToken {
    private List<IToken> tokens;

    public QuotationToken(List<IToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        stack.push(new CombinationToken(tokens));
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
