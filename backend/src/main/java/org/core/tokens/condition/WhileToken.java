package org.core.tokens.condition;

import org.core.tokens.interfaces.IFunctionToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.quotation.CombinationToken;
import org.core.tokens.quotation.QuotationToken;
import org.slang.KKJException;

import java.util.*;

public class WhileToken implements IFunctionToken {

    public WhileToken() {
    }

    @Override
    public List<IToken> stackSolving(Stack<IToken> stack) {
        if(stack.size()>=2) {
            List<IToken> branch = new LinkedList<>();
            branch.add(stack.pop());
            List<IToken> condition = new LinkedList<>();
            condition.add(stack.pop());
            List<IToken> branchClone = new LinkedList<>();
            List<IToken> conditionClone = new LinkedList<>();
            for(IToken token : branch) {
                branchClone.add(token.clone());
            }
            for(IToken token : condition) {
                conditionClone.add(token.clone());
            }

            List<IToken> loopBranch = new LinkedList<>(List.of(new CombinationToken(new LinkedList<>(List.of(
                    new CombinationToken(branch),
                    new QuotationToken(conditionClone),
                    new QuotationToken(branchClone),
                    new WhileToken()
            )))));
            return new LinkedList<>(List.of(new ConditionToken(condition, loopBranch, List.of(new IDToken()))));
        } else {
            throw new KKJException("In stack must be >= 2 items and is empty");
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
        stringBuilder.append("WHILE");
        return stringBuilder.toString();
    }
}
