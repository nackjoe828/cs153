.class public Strappend
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
    putstatic	Strappend/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Strappend/_standardIn LPascalTextIn;

    ldc "Hello"
    astore 1 ;Local/s1
    ldc "World"
    astore 2 ;Local/s2
    ldc 8
    istore 0 ;Local/i
    new java/lang/StringBuilder
    dup
    aload 1  ;Local/s1
    invokenonvirtual java/lang/StringBuilder/<init>(Ljava/lang/String;)V
    iload 0  ;Local/i
    invokevirtual java/lang/StringBuilder/append(I)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;
    ldc 7
    iadd
    astore 1 ;Local/s1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1  ;Local/s1
    ldc 0
    anewarray java/lang/Object

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop


    getstatic	Strappend/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 4
.limit stack  16
.end method
