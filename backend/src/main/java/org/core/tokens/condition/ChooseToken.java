package org.core.tokens.condition;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ChooseToken implements IFunctionToken {

    public ChooseToken() {
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(stack.size()>=3) {
            IToken falseBranch = stack.pop();
            IToken trueBranch = stack.pop();
            IToken condition = stack.pop();

            if(condition instanceof BoolToken) {
                if (((BoolToken) condition).getValue() == true) {
                    stack.push(trueBranch);
                    return new LinkedList<>();
                } else {
                    stack.push(falseBranch);
                    return new LinkedList<>();
                }
            } else {
                throw new RuntimeException("Condition must be BoolToken and is " + condition.getClass().getSimpleName());
            }
        } else {
            throw new RuntimeException("In stack must be >= 3 items and is empty");
        }
    }

    @Override
    public IFunctionToken clone() {
        return new ChooseToken();
    }

    @Override
    public String toString() {
        return "CHOOSE";
    }

    @Override
    public String toJSON() {
        return "CHOOSE";
    }
}
