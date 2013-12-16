.class public Mod
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

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Mod/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Mod/_standardIn LPascalTextIn;

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "%d"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    ldc 48
    ldc 24
    invokestatic Mod/mod(II)I
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop


    getstatic	Mod/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 16
.limit stack  16
.end method
