.class public While
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
    putstatic	While/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	While/_standardIn LPascalTextIn;

    ldc 0.0
    fstore 0 ;Local/b
    ldc 0
    istore 1 ;Local/exp
L002:
    iload 1  ;Local/exp
    ldc 10
    if_icmplt L003
    goto L004
L003:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "%d\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    iload 1  ;Local/exp
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    iload 1  ;Local/exp
    ldc 1
    iadd
    istore 1 ;Local/exp
    goto L002
L004:

    getstatic	While/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 4
.limit stack  16
.end method
