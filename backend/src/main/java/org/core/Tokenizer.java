package org.core;

import org.core.tokens.arithmetic.AddToken;
import org.core.tokens.arithmetic.CmpToken;
import org.core.tokens.arithmetic.MulToken;
import org.core.tokens.arithmetic.SubToken;
import org.core.tokens.condition.ChooseToken;
import org.core.tokens.condition.WhileToken;
import org.core.tokens.constant.BoolToken;
import org.core.tokens.constant.IntToken;
import org.core.tokens.functions.ApplyOverToken;
import org.core.tokens.functions.ApplyToken;
import org.core.tokens.functions.ComposeToken;
import org.core.tokens.interfaces.IToken;
import org.core.tokens.logic.AndToken;
import org.core.tokens.logic.IsNegToken;
import org.core.tokens.logic.IsPosToken;
import org.core.tokens.logic.NotToken;
import org.core.tokens.quotation.QuotationToken;
import org.core.tokens.stack.*;

import java.util.LinkedList;
import java.util.List;

public class Tokenizer {
    public List<IToken> getTokenList(String input) {
        int quotations = 0;
        if (input == null || input.isEmpty()) {
            return new LinkedList<>();
        }
        String[] inputTokens = input.split(" ");
        List<List<IToken>> programs = new LinkedList<>();
        List<IToken> tokenList = new LinkedList<>();
        for (String token : inputTokens) {
            if(token.matches("-?\\d+")) {
                tokenList.add(new IntToken(token));
            } else if(token.toUpperCase().matches("TRUE|FALSE")) {
                tokenList.add(new BoolToken(token));
            } else if(token.toUpperCase().matches("ADD")) {
                IToken iToken = new AddToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("MUL")) {
                IToken iToken = new MulToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("SUB")) {
                IToken iToken = new SubToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("CMP")) {
                IToken iToken = new CmpToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("NOT")) {
                IToken iToken = new NotToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("AND")) {
                IToken iToken = new AndToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("ISPOS")) {
                IToken iToken = new IsPosToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("ISNEG")) {
                IToken iToken = new IsNegToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("CLEAR")) {
                IToken iToken = new ClearToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("POP")) {
                IToken iToken = new PopToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("DUP")) {
                IToken iToken = new DupToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("OVER")) {
                IToken iToken = new OverToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("SWAP")) {
                IToken iToken = new SwapToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("ROTL")) {
                IToken iToken = new RotlToken();
                tokenList.add(iToken);
            } else if (token.toUpperCase().matches("APPLY")) {
                IToken iToken = new ApplyToken();
                tokenList.add(iToken);
            } else if (token.toUpperCase().matches("COMPOSE")) {
                IToken iToken = new ComposeToken();
                tokenList.add(iToken);
            } else if (token.toUpperCase().matches("APPLYOVER")) {
                IToken iToken = new ApplyOverToken();
                tokenList.add(iToken);
            } else if(token.toUpperCase().matches("CHOOSE")) {
                IToken iToken = new ChooseToken();
                tokenList.add(iToken);
            } else if (token.toUpperCase().matches("WHILE")) {
                IToken iToken = new WhileToken();
                tokenList.add(iToken);
            } else if (token.equals("{")) {
                programs.add(tokenList);
                tokenList = new LinkedList<>();
                quotations++;
            } else if (token.equals("}")) {
                quotations--;
                IToken iToken = new QuotationToken(tokenList);
                tokenList = new LinkedList<>();
                tokenList.add(iToken);
                tokenList.addAll(0, programs.removeLast());
            } else {
                throw new RuntimeException(tokenList.toString());
            }
        }
        if(quotations > 0) {
            throw new RuntimeException(tokenList.toString());
        }
        return tokenList;
    }

    /*private List<IToken> getTokenList(List<IToken> tokenList, List<Class<? extends IToken>> expectedTokenList) {
        List<IToken> subTokenList = new LinkedList<>();
        int classIndex = expectedTokenList.size()-1;
        List<Class<? extends IToken>> getTokenList = new LinkedList<>();
        for (int tokenIndex = tokenList.size()-1; tokenIndex>=0; tokenIndex--) {
            IToken token = tokenList.removeLast();
            subTokenList.addFirst(token);
            List<Class<? extends IToken>> availabelTokenList = token.getAvailableTokenList();
            getTokenList.addAll(availabelTokenList);
        }
        for(int availableClassToken=getTokenList.size()-1; availableClassToken>=0; availableClassToken--){
            if(getTokenList.get(availableClassToken) != expectedTokenList.get(classIndex) && expectedTokenList.get(classIndex) != IToken.class) {
                StringBuilder stringBuilder = new StringBuilder("Expected: ..., ");
                for(Class<? extends IToken> tokenClass: expectedTokenList) {
                    stringBuilder.append(tokenClass.getSimpleName()).append(", ");
                }
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                stringBuilder.append(" but get: ");
                for(int availableTokenIndex=getTokenList.size()-1; availableTokenIndex>=0; availableTokenIndex--){
                    stringBuilder.append(getTokenList.get(availableTokenIndex).getSimpleName()).append(", ");
                }
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                throw new RuntimeException(stringBuilder.toString());
            }
            classIndex--;
            if(classIndex<0){
                return subTokenList;
            }
        }
        return subTokenList;
    }*/

    /*private List<IToken> getTokenList(List<IToken> tokenList) {
        List<IToken> subTokenList = new LinkedList<>();
        for (int tokenIndex = tokenList.size()-1; tokenIndex>=0; tokenIndex--) {
            IToken token = tokenList.removeLast();
            subTokenList.addFirst(token);
            List<Class<? extends IToken>> availabelTokenList = token.getAvailableTokenList();
        }
        return subTokenList;
    }*/
}
