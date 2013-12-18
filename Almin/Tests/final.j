.class public Final
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

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Final/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Final/_standardIn LPascalTextIn;

    ldc 0
    istore 0 ;Local/i
    ldc 1
    istore 1 ;Local/j
    ldc 2
    istore 2 ;Local/k
    iload 2  ;Local/k
    istore 1 ;Local/j
    istore 0 ;Local/i

    getstatic	Final/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 16
.limit stack  16
.end method
