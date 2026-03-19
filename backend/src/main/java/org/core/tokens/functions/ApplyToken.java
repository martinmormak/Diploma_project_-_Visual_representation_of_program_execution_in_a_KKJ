package org.core.tokens.functions;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.CombinationToken;
import org.core.tokens.quotation.CompositionToken;
import org.slang.KKJException;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ApplyToken implements IToken {
    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(!stack.isEmpty()) {
            IToken pop1 = stack.pop();
            if(pop1 instanceof IFunctionToken) {
                if(pop1 instanceof CompositionToken) {
                    return ((CompositionToken) pop1).getTokens();
                } else if(pop1 instanceof CombinationToken) {
                    return ((CombinationToken) pop1).getTokens();
                }
                return new LinkedList<>(List.of(pop1));
            } else {
                throw new KKJException("Expected IFunctionToken and get " + pop1.getClass().getSimpleName());
            }
        } else {
            throw new KKJException("In stack must be >= 1 items and is empty");
        }
    }

    @Override
    public IToken clone() {
        return new ApplyToken();
    }

    @Override
    public String toString() {
        return "APPLY";
    }

    @Override
    public String toJSON() {
        return "APPLY";
    }
}
