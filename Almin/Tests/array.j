.class public Array
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
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "x=%d\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    iload 0  ;Local/x
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    return


.limit locals 1
.limit stack  16
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Array/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Array/_standardIn LPascalTextIn;


;generating array/i
    ldc 10
    newarray int
    astore 0 ;array/i

    ldc 0
    istore 1 ;Local/x
L002:
    iload 1  ;Local/x
    ldc 10
    if_icmplt L003
    goto L004
L003:
    aload 0 ;array/i
    iload 1  ;Local/x
    iload 1  ;Local/x
    ldc 10
    imul
    iastore  ;array/i
    aload 0  ;Local/i
    iload 1  ;Local/x
    iaload 
    istore 2 ;Local/y
    aload 0  ;Local/i
    iload 1  ;Local/x
    iaload 
    invokestatic Array/foo(I)V
    iload 1  ;Local/x
    ldc 1
    iadd
    istore 1 ;Local/x
    goto L002
L004:

    getstatic	Array/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 4
.limit stack  16
.end method
