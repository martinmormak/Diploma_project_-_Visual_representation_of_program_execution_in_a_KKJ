package org.core.tokens.condition;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.QuotationToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class WhileToken implements IFunctionToken {

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(stack.size()>=2) {
            List<IToken> trueBranch = new LinkedList<>(List.of(stack.pop()));
            List<IToken> condition = new LinkedList<>(List.of(stack.pop()));
            List<IToken> trueBranchClone = new LinkedList<>();
            List<IToken> conditionClone = new LinkedList<>();
            for(IToken token : trueBranch) {
                trueBranchClone.add(token.clone());
            }
            for(IToken token : condition) {
                conditionClone.add(token.clone());
            }
            trueBranch.addAll(List.of(new QuotationToken(conditionClone), new QuotationToken(trueBranchClone), new WhileToken()));
            return List.of(new ConditionToken(new ArrayList<>(condition), new ArrayList<>(trueBranch), new ArrayList<>()));
        } else {
            throw new RuntimeException("In stack must be >= 2 items and is " + (stack.isEmpty() ? "empty" : stack.size()));
        }
    }

    @Override
    public String toString() {
        return "WHILE";
    }

    @Override
    public IFunctionToken clone() {
        return new WhileToken();
    }
}
