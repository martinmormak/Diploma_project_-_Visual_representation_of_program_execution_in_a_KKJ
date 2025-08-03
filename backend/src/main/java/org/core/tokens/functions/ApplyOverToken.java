package org.core.tokens.functions;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.CombinationToken;
import org.core.tokens.quotation.CompositionToken;

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
                return List.of(pop1);
            } else {
                throw new RuntimeException("Expected IFunctionToken, IToken and get " + pop2.getClass().getSimpleName() + ", " + pop1.getClass().getSimpleName());
            }
        } else {
            throw new RuntimeException("In stack must be >= 2 items and is empty");
        }
    }

    @Override
    public String toString() {
        return "APPLY";
    }

    @Override
    public IToken clone() {
        return new ApplyToken();
    }
}
