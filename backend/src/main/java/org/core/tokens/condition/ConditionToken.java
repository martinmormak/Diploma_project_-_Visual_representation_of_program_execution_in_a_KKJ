package org.core.tokens.condition;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;

import java.util.List;
import java.util.Stack;

public class ConditionToken implements IFunctionToken {
    private List<IToken> condition;
    private List<IToken> trueBranch;
    private List<IToken> falseBranch;

    public ConditionToken(List<IToken> condition, List<IToken> trueBranch, List<IToken> falseBranch) {
        this.condition = condition;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if (!condition.isEmpty()) {
            List<IToken> result = condition.removeFirst().stackSolving(stack);
            if (result != null && !result.isEmpty()) {
                condition.addAll(0, result);
            }
            return List.of(this);
        }
        if(stack.peek() instanceof BoolToken) {
            BoolToken condition = (BoolToken) stack.pop();
            if (condition.getValue() == true) {
                return trueBranch;
            } else {
                return falseBranch;
            }
        } else {
            throw new RuntimeException("Expected BoolToken and get " + stack.peek().getClass().getSimpleName());
        }
    }

    @Override
    public IFunctionToken clone() {
        return new ConditionToken(condition,trueBranch,falseBranch);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CONDITION( ");
        stringBuilder.append(condition).append(", ");
        stringBuilder.append(trueBranch).append(", ");
        stringBuilder.append(falseBranch).append(" )");
        return stringBuilder.toString();
    }

    @Override
    public String toJSON() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"CONDITION(\" ");
        stringBuilder.append(condition).append(", ");
        stringBuilder.append(trueBranch).append(", ");
        stringBuilder.append(falseBranch).append(" \")\"");
        return stringBuilder.toString();
    }
}
