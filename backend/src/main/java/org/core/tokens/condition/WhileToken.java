package org.core.tokens.condition;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.CombinationToken;
import org.core.tokens.quotation.QuotationToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class WhileToken implements IFunctionToken {

    public WhileToken() {
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(stack.size()>=2) {
            List<IToken> branch = new ArrayList<>();
            branch.add(stack.pop());
            List<IToken> condition = new ArrayList<>();
            condition.add(stack.pop());
            List<IToken> branchClone = new LinkedList<>();
            List<IToken> conditionClone = new LinkedList<>();
            for(IToken token : branch) {
                branchClone.add(token.clone());
            }
            for(IToken token : condition) {
                conditionClone.add(token.clone());
            }
            List<IToken> loopBranch = List.of(
                    new CombinationToken(branch),
                    new QuotationToken(conditionClone),
                    new QuotationToken(branchClone),
                    new WhileToken()
            );
            return List.of(new ConditionToken(condition, loopBranch, List.of(new IDToken())));
        } else {
            throw new RuntimeException("In stack must be >= 2 items and is empty");
        }
    }

    @Override
    public IFunctionToken clone() {
        return new WhileToken();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WHILE");
        return stringBuilder.toString();
    }

    @Override
    public String toJSON() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"WHILE\"");
        return stringBuilder.toString();
    }
}
