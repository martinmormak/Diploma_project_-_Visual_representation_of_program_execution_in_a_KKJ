package org.core.tokens.functions;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.CombinationToken;
import org.core.tokens.quotation.CompositionToken;
import org.slang.KKJException;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ApplyOverToken implements IToken {
    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(stack.size() >= 2) {
            IToken pop1 = stack.pop();
            IToken pop2 = stack.pop();
            stack.push(pop1);
            if(pop2 instanceof IFunctionToken) {
                if(pop1 instanceof CompositionToken) {
                    return ((CompositionToken) pop1).getTokens();
                } else if(pop1 instanceof CombinationToken) {
                    return ((CombinationToken) pop1).getTokens();
                }
                return new LinkedList<>(List.of(pop1));
            } else {
                throw new KKJException("Expected IFunctionToken, IToken and get " + pop2.getClass().getSimpleName() + ", " + pop1.getClass().getSimpleName());
            }
        } else {
            throw new KKJException("In stack must be >= 2 items and is empty");
        }
    }

    @Override
    public IToken clone() {
        return new ApplyToken();
    }

    @Override
    public String toString() {
        return "APPLYOVER";
    }

    @Override
    public String toJSON() {
        return "APPLYOVER";
    }
}
