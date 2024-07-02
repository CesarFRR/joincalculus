grammar JoinCalc;

// Reglas de sintaxis
program : sent_list?;

sent_list : sent (sent)* ;

sent : declar ';'
          | assign ';'
          | expr ';'
          | sent_if
          | sleep ';'
          | println ';'
          | print';'
          | channel_decl ';'
          | channel_send ';'
          | process_decl
          | process_run ';'
          | process_stop ';'
          | spawn ';'
          | sent_for
          | sent_while
          | sent_break ';'
          | sent_continue ';'
          ;

print: 'print' '(' expr ')';


assign : ID '=' expr ;
sleep : 'wait' '(' expr ')' ;
random: 'random' '(' expr ',' expr ')';
spawn : 'spawn'  '(' ID ',' expr ')' ;
declar : type ID ('=' expr)? ;

channel_decl : 'channel' ID ( ',' ID)* ;
channel_send : 'send' ID '(' expr ')' ;
channel_receive : 'receive' ID '()' ;

process_decl : 'process' ID '{' sent_list? '}' ;
process_run : ID '.' 'run' '()' ;
process_stop : 'stop' '()' ;

is_empty : 'isEmpty' '(' expr ')' ;

println : 'println' '(' expr ')' ;

type : 'int' | 'float' | 'string' | 'boolean' ;

expr
     : INT       #litInt
     | FLOAT     #litFloat
     | STRING    #litString
     | BOOLEAN   #litBoolean
     | is_empty  #fnIsEmpty
     | '-' expr  #negExpr
     | ID        #id
     | random   #fnRandom
     | channel_receive #fnReceive
     | expr '*' expr   #opMult
     | expr '/' expr   #opDiv
     | expr '+' expr   #opSuma
     | expr '-' expr   #opResta
     | expr '%' expr   #opMod
     | expr '^' expr   #opPot
     | '!' expr    #notBool
     | expr operators_bool expr #opBool
     | expr '||' expr #orBool
     | expr '&&' expr #andBool
     | '(' expr ')'    #innerExpr
     ;

operators_bool:
      '!='
    | '=='
    | '<='
    | '>='
    | '<'
    | '>'
    ;
sent_if : 'if' '(' expr ')' '{' sent_list? '}' ('else' '{' sent_list? '}' )?;
sent_for : 'for' '(' declar ';' expr ';' assign ')' '{' sent_list? '}';
sent_while : 'while' '(' expr ')' '{' sent_list? '}';
sent_break : 'break' ;
sent_continue : 'continue' ;

// Reglas léxicas (tokens)
BOOLEAN : 'true' | 'false' ;
ID      : [a-zA-Z]+[0-9a-zA-Z_]* ;
INT     : [0-9]+ ;
STRING  : '"' (~["\\] | '\\' .)* '"' ;
FLOAT   : [0-9]+'.'[0-9]+ ;
// implementar los comentarios los cuales comienzan con // o tambien con # y terminan con un salto de linea
COMMENT : '//' .*? '\n' -> skip ;
WS      : [ \t\r\n]+ -> skip ;