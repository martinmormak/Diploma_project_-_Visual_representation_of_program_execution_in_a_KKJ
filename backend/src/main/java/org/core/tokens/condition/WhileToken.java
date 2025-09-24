package org.core.tokens.condition;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.QuotationToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class WhileToken implements IFunctionToken {
    private List<IToken> conditionBranch;
    private List<IToken> loopBranch;

    public WhileToken(List<IToken> conditionBranch, List<IToken> loopBranch) {
        this.conditionBranch = conditionBranch;
        this.loopBranch = loopBranch;
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(!stack.isEmpty()) {
            List<IToken> trueBranchClone = new LinkedList<>();
            List<IToken> conditionClone = new LinkedList<>();
            for(IToken token : loopBranch) {
                trueBranchClone.add(token.clone());
            }
            for(IToken token : conditionBranch) {
                conditionClone.add(token.clone());
            }
            loopBranch.add(new WhileToken(conditionClone, trueBranchClone));
            return List.of(new ConditionToken(new ArrayList<>(loopBranch), new ArrayList<>(conditionBranch), new ArrayList<>()));
        } else {
            throw new RuntimeException("In stack must be >= 1 items and is empty");
        }
    }

    @Override
    public IFunctionToken clone() {
        List<IToken> trueBranchClone = new LinkedList<>();
        List<IToken> conditionClone = new LinkedList<>();
        for(IToken token : loopBranch) {
            trueBranchClone.add(token.clone());
        }
        for(IToken token : conditionBranch) {
            conditionClone.add(token.clone());
        }
        return new WhileToken(trueBranchClone, conditionClone);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WHILE( ");
        stringBuilder.append(conditionBranch).append(", ");
        stringBuilder.append(loopBranch).append(" )");
        return stringBuilder.toString();
    }

    @Override
    public String toJSON() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"WHILE(\" ");
        stringBuilder.append(conditionBranch).append(", ");
        stringBuilder.append(loopBranch).append(" )");
        return stringBuilder.toString();
    }
}
