.class public FactorialRecursion
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

.method public static fact(I)I
    iload 0  ;Local/n
    ldc 1
    if_icmpeq L002
    goto L003
L002:
    ldc 1
    ireturn


L003:
    iload 0  ;Local/n
    ldc 1
    isub
    invokestatic FactorialRecursion/fact(I)I
    iload 0  ;Local/n
    imul
    istore 1 ;Local/result
    iload 1  ;Local/result
    ireturn


.limit locals 2
.limit stack  16
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	FactorialRecursion/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	FactorialRecursion/_standardIn LPascalTextIn;

    ldc 10
    istore 0 ;Local/x
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "x = %d, fact(x) = %d\n"
    ldc 2
    anewarray java/lang/Object

    dup
    ldc 0
    iload 0  ;Local/x
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    dup
    ldc 1
    iload 0  ;Local/x
    invokestatic FactorialRecursion/fact(I)I
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop


    getstatic	FactorialRecursion/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 4
.limit stack  16
.end method
