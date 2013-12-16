.class public Bool
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

.method public static foo(I)V
    iload 0  ;Local/x
    ldc 1
    if_icmpeq L002
    goto L003
L002:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Yes!"
    ldc 0
    anewarray java/lang/Object

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    goto L004
L003:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "No"
    ldc 0
    anewarray java/lang/Object

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

L004:
    return


.limit locals 1
.limit stack  16
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Bool/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Bool/_standardIn LPascalTextIn;

    ldc 0
    istore 0 ;Local/i
    iload 0  ;Local/i
    invokestatic Bool/foo(I)V

    getstatic	Bool/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 4
.limit stack  16
.end method
