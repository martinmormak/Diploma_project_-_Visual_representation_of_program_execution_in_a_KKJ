package org.core.tokens.condition;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ChooseToken implements IFunctionToken {
    private final List<IToken> trueBranch;
    private final List<IToken> falseBranch;

    public ChooseToken(List<IToken> trueBranch, List<IToken> falseBranch) {
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(!stack.isEmpty()) {
            List<IToken> condition = new LinkedList<>(List.of(stack.pop()));
            return new LinkedList<>(List.of(new ConditionToken(condition, trueBranch, falseBranch)));
        } else {
            throw new RuntimeException("In stack must be >= 1 items and is empty");
        }
    }

    @Override
    public IFunctionToken clone() {
        return new ChooseToken(trueBranch, falseBranch);
    }

    @Override
    public String toString() {
        return "CHOOSE";
    }

    @Override
    public String toJSON() {
        return "\"CHOOSE\"";
    }
}
