package org.core.tokens.condition;

import org.core.tokens.constant.BoolToken;
import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.slang.KKJException;

import java.util.LinkedList;
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
            return new LinkedList<>(List.of(this));
        }
        if(stack.peek() instanceof BoolToken) {
            BoolToken condition = (BoolToken) stack.pop();
            if (condition.getValue() == true) {
                return trueBranch;
            } else {
                return falseBranch;
            }
        } else {
            throw new KKJException("Expected BoolToken and get " + stack.peek().getClass().getSimpleName());
        }
    }

    @Override
    public IFunctionToken clone() {
        List<IToken> conditionClone = new LinkedList<>();
        for (IToken token : condition) {
            conditionClone.add(token.clone());
        }

        List<IToken> trueBranchClone = new LinkedList<>();
        for (IToken token : trueBranch) {
            trueBranchClone.add(token.clone());
        }

        List<IToken> falseBranchClone = new LinkedList<>();
        for (IToken token : falseBranch) {
            falseBranchClone.add(token.clone());
        }

        return new ConditionToken(conditionClone,trueBranchClone,falseBranchClone);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CONDITION( ");
        stringBuilder.append(condition).append(" ");
        stringBuilder.append(trueBranch).append(" ");
        stringBuilder.append(falseBranch).append(" )");
        return stringBuilder.toString();
    }

    @Override
    public String toJSON() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CONDITION|- ");
        for (IToken iToken : condition) {
            stringBuilder.append(iToken.toJSON()).append(" ");
        }
        for (IToken iToken : trueBranch) {
            stringBuilder.append(iToken.toJSON()).append(" ");
        }
        for (IToken iToken : falseBranch) {
            stringBuilder.append(iToken.toJSON()).append(" ");
        }
        stringBuilder.append("-|");
        return stringBuilder.toString();
    }
}
