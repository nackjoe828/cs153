.class public PrimeNumber
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static mod(II)I
L002:
    iload 0  ;Local/x
    iload 1  ;Local/y
    if_icmpge L003
    goto L004
L003:
    iload 0  ;Local/x
    iload 1  ;Local/y
    isub
    istore 0 ;Local/x
    goto L002
L004:
    iload 0  ;Local/x
    ireturn


.limit locals 2
.limit stack  16
.end method

.method public static printPrimeUpTo(I)V
    ldc 2
    istore 1 ;Local/count
    ldc 0
    istore 4 ;Local/printCount
L002:
    iload 1  ;Local/count
    iload 0  ;Local/n
    if_icmple L003
    goto L004
L003:
    ldc 1
    istore 2 ;Local/flag
    iload 1  ;Local/count
    ldc 2
    idiv
    istore 3 ;Local/half
    ldc 2
    istore 5 ;Local/x
L005:
    iload 5  ;Local/x
    iload 3  ;Local/half
    if_icmple L006
    goto L007
L006:
    iload 1  ;Local/count
    iload 5  ;Local/x
    invokestatic PrimeNumber/mod(II)I
    ldc 0
    if_icmpeq L008
    goto L009
L008:
    ldc 0
    istore 2 ;Local/flag
L009:
    iload 5  ;Local/x
    ldc 1
    iadd
    istore 5 ;Local/x
    goto L005
L007:
    iload 2  ;Local/flag
    ldc 1
    if_icmpeq L010
    goto L011
L010:
    iload 4  ;Local/printCount
    ldc 1
    iadd
    istore 4 ;Local/printCount
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "%8d"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    iload 1  ;Local/count
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    iload 4  ;Local/printCount
    ldc 10
    invokestatic PrimeNumber/mod(II)I
    ldc 0
    if_icmpeq L012
    goto L013
L012:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "\n"
    ldc 0
    anewarray java/lang/Object

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

L013:
L011:
    iload 1  ;Local/count
    ldc 1
    iadd
    istore 1 ;Local/count
    goto L002
L004:
    return


.limit locals 6
.limit stack  16
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	PrimeNumber/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	PrimeNumber/_standardIn LPascalTextIn;

    ldc 100000
    invokestatic PrimeNumber/printPrimeUpTo(I)V

    getstatic	PrimeNumber/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 16
.limit stack  16
.end method
