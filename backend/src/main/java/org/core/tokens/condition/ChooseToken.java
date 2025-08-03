package org.core.tokens.condition;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ChooseToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(stack.size()>=3) {
            List<IToken> falseBranch = new LinkedList<>(List.of(stack.pop()));
            List<IToken> trueBranch = new LinkedList<>(List.of(stack.pop()));
            List<IToken> condition = new LinkedList<>(List.of(stack.pop()));
            return new LinkedList<>(List.of(new ConditionToken(condition, trueBranch, falseBranch)));
        } else {
            throw new RuntimeException("In stack must be >= 3 items and is " + (stack.isEmpty() ? "empty" : stack.size()));
        }
    }

    @Override
    public String toString() {
        return "CHOOSE";
    }

    @Override
    public IFunctionToken clone() {
        return new ChooseToken();
    }
}
