grammar KKJ;
options { language = Java; }
@header
{

      package org.slang.lang.kkj;
      import java.util.*;

      import org.core.tokens.arithmetic.*;
      import org.core.tokens.condition.*;
      import org.core.tokens.constant.*;
      import org.core.tokens.functions.*;
      import org.core.tokens.interfaces.*;
      import org.core.tokens.logic.*;
      import org.core.tokens.quotation.*;
      import org.core.tokens.stack.*;
      import static org.slang.lang.kkj.KKJ.*;
    
}
dProgram returns [ Program _result ] :
   s=dSequence EOF { $_result = new Program.Prog($s._result); }
;
dSequence returns [ Sequence _result ] :
   s1=dSequence ' ' s2=dSequence { $_result = new Sequence.Seq($s1._result, $s2._result); }
|  c=dConstant { $_result = new Sequence.Cons($c._result); }
|  a=dArithmeticOperations { $_result = new Sequence.ArithmeticOp($a._result); }
|  l=dLogicalOperations { $_result = new Sequence.LogicalOp($l._result); }
|  s=dStackOperations { $_result = new Sequence.StackOp($s._result); }
|  f=dFunctionOperations { $_result = new Sequence.FunctionOp($f._result); }
|  o=dConditionsOperation { $_result = new Sequence.ConditionsOp($o._result); }
;
dConstant returns [ Constant _result ] :
   n=dNUM { $_result = new Constant.Num($n._result); }
|  'TRUE' { $_result = new Constant.True(); }
|  'FALSE' { $_result = new Constant.False(); }
;
dArithmeticOperations returns [ ArithmeticOperations _result ] :
   'ADD' { $_result = new ArithmeticOperations.Add(); }
|  'SUB' { $_result = new ArithmeticOperations.Sub(); }
|  'MUL' { $_result = new ArithmeticOperations.Mul(); }
|  'CMP' { $_result = new ArithmeticOperations.Cmp(); }
;
dLogicalOperations returns [ LogicalOperations _result ] :
   'NOT'{ $_result = new LogicalOperations.Not(); }
|  'AND' { $_result = new LogicalOperations.And(); }
|  'ISNEG'{ $_result = new LogicalOperations.IsNeg(); }
|  'ISPOS'{ $_result = new LogicalOperations.IsPos(); }
;
dStackOperations returns [ StackOperations _result ] :
   'CLEAR'{ $_result = new StackOperations.Clear(); }
|  'ID' { $_result = new StackOperations.Id(); }
|  'POP'{ $_result = new StackOperations.Pop(); }
|  'DUP'{ $_result = new StackOperations.Dup(); }
|  'OVER' { $_result = new StackOperations.Over(); }
|  'SWAP'{ $_result = new StackOperations.Swap(); }
|  'ROTL'{ $_result = new StackOperations.Rotl(); }
;
dFunctionOperations returns [ FunctionOperations _result ] :
   'COMPOSE'{ $_result = new FunctionOperations.Compose(); }
|  'APPLY' { $_result = new FunctionOperations.Apply(); }
|  'APPLYOVER'{ $_result = new FunctionOperations.ApplyOver(); }
|  '{ ' + s=dSequence  + ' }'{ $_result = new FunctionOperations.Quote($s._result); }
;
dConditionsOperation returns [ ConditionsOperation _result ] :
   'IF'{ $_result = new ConditionsOperation.Choose(); }
|  'WHILE' { $_result = new ConditionsOperation.While(); }
;
dNUM returns [ String _result ] : n=NUM { $_result = $n.text; } ;
dID returns [ String _result ] : i=ID { $_result = $i.text; } ;
dSTR returns [ String _result ] : s=STR { $_result = $s.text; } ;
NUM : [0-9]+ ;
ID : [a-zA-Z][a-zA-Z_0-9]* ;
STR : '"' (ESC|.)*? '"' ;
fragment ESC : '\\"' | '\\n' | '\\%' | '\\\\';
WHITESPACE  : [ \t\r\n\f]+ -> skip ;
LINECOMMENT : '//' .*? '\r'? ('\n' | EOF) -> skip ;
COMMENT     : '/*' .*? '*/' -> skip ;
ERROR : . ;
