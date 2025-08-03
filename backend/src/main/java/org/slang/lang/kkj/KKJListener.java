// Generated from lang/kkj/KKJ.g4 by ANTLR 4.13.0


      package org.slang.lang.kkj;
      import java.util.*;
      import static org.slang.lang.kkj.KKJ.*;
    

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KKJParser}.
 */
public interface KKJListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KKJParser#dProgram}.
	 * @param ctx the parse tree
	 */
	void enterDProgram(KKJParser.DProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link KKJParser#dProgram}.
	 * @param ctx the parse tree
	 */
	void exitDProgram(KKJParser.DProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link KKJParser#dSequence}.
	 * @param ctx the parse tree
	 */
	void enterDSequence(KKJParser.DSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link KKJParser#dSequence}.
	 * @param ctx the parse tree
	 */
	void exitDSequence(KKJParser.DSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link KKJParser#dConstant}.
	 * @param ctx the parse tree
	 */
	void enterDConstant(KKJParser.DConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link KKJParser#dConstant}.
	 * @param ctx the parse tree
	 */
	void exitDConstant(KKJParser.DConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link KKJParser#dArithmeticOperations}.
	 * @param ctx the parse tree
	 */
	void enterDArithmeticOperations(KKJParser.DArithmeticOperationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KKJParser#dArithmeticOperations}.
	 * @param ctx the parse tree
	 */
	void exitDArithmeticOperations(KKJParser.DArithmeticOperationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KKJParser#dLogicalOperations}.
	 * @param ctx the parse tree
	 */
	void enterDLogicalOperations(KKJParser.DLogicalOperationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KKJParser#dLogicalOperations}.
	 * @param ctx the parse tree
	 */
	void exitDLogicalOperations(KKJParser.DLogicalOperationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KKJParser#dStackOperations}.
	 * @param ctx the parse tree
	 */
	void enterDStackOperations(KKJParser.DStackOperationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KKJParser#dStackOperations}.
	 * @param ctx the parse tree
	 */
	void exitDStackOperations(KKJParser.DStackOperationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KKJParser#dFunctionOperations}.
	 * @param ctx the parse tree
	 */
	void enterDFunctionOperations(KKJParser.DFunctionOperationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KKJParser#dFunctionOperations}.
	 * @param ctx the parse tree
	 */
	void exitDFunctionOperations(KKJParser.DFunctionOperationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KKJParser#dConditionsOperation}.
	 * @param ctx the parse tree
	 */
	void enterDConditionsOperation(KKJParser.DConditionsOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KKJParser#dConditionsOperation}.
	 * @param ctx the parse tree
	 */
	void exitDConditionsOperation(KKJParser.DConditionsOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KKJParser#dNUM}.
	 * @param ctx the parse tree
	 */
	void enterDNUM(KKJParser.DNUMContext ctx);
	/**
	 * Exit a parse tree produced by {@link KKJParser#dNUM}.
	 * @param ctx the parse tree
	 */
	void exitDNUM(KKJParser.DNUMContext ctx);
	/**
	 * Enter a parse tree produced by {@link KKJParser#dID}.
	 * @param ctx the parse tree
	 */
	void enterDID(KKJParser.DIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link KKJParser#dID}.
	 * @param ctx the parse tree
	 */
	void exitDID(KKJParser.DIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link KKJParser#dSTR}.
	 * @param ctx the parse tree
	 */
	void enterDSTR(KKJParser.DSTRContext ctx);
	/**
	 * Exit a parse tree produced by {@link KKJParser#dSTR}.
	 * @param ctx the parse tree
	 */
	void exitDSTR(KKJParser.DSTRContext ctx);
}