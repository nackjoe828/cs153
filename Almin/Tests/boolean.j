.class public Boolean
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

.method public static foo(I)Z
    iload 0  ;Local/x
    ldc 1
    if_icmpeq L002
    goto L003
L002:
    aload 1  ;Local/true
    ireturn


    goto L004
L003:
    aload 1  ;Local/false
    ireturn


L004:
.limit locals 1
.limit stack  16
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Boolean/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Boolean/_standardIn LPascalTextIn;


;generating array/bools
    ldc 3
    astore 0 ;array/bools

    ldc 1
    istore 1 ;Local/i
    iload 1  ;Local/i
    invokestatic Boolean/foo(I)Z
    goto L002
L001:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Yes!"
    ldc 0
    anewarray java/lang/Object

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    goto L003
L002:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "No"
    ldc 0
    anewarray java/lang/Object

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

L003:

    getstatic	Boolean/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 4
.limit stack  16
.end method
