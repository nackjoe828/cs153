.class public SquareRoot
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

.method public static avg(FF)F
    fload 0  ;Local/x
    fload 1  ;Local/y
    fadd
    ldc 2.0
    fdiv
    freturn


.limit locals 2
.limit stack  16
.end method

.method public static sqrt(F)F
    ldc 1.0
    fstore 3 ;Local/guess
    ldc 1
    i2f
    fstore 2 ;Local/delta
    ldc 0
    istore 1 ;Local/count
L002:
    fload 2  ;Local/delta
    ldc 1.0E-4
    fcmpl
    ifgt L003
    goto L004
L003:
    fload 0  ;Local/n
    fload 3  ;Local/guess
    fdiv
    fstore 4 ;Local/temp
    fload 3  ;Local/guess
    fload 4  ;Local/temp
    invokestatic SquareRoot/avg(FF)F
    fstore 3 ;Local/guess
    fload 3  ;Local/guess
    fload 3  ;Local/guess
    fmul
    fload 0  ;Local/n
    fsub
    fstore 2 ;Local/delta
    fload 2  ;Local/delta
    ldc 0.0
    fcmpl
    iflt L005
    goto L006
L005:
    fload 2  ;Local/delta
    fload 2  ;Local/delta
    ldc 2.0
    fmul
    fsub
    fstore 2 ;Local/delta
L006:
    iload 1  ;Local/count
    ldc 1
    iadd
    istore 1 ;Local/count
    goto L002
L004:
    fload 3  ;Local/guess
    freturn


.limit locals 5
.limit stack  16
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	SquareRoot/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	SquareRoot/_standardIn LPascalTextIn;

    ldc 1.0
    fstore 0 ;Local/r
L002:
    fload 0  ;Local/r
    ldc 100.0
    fcmpl
    ifle L003
    goto L004
L003:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "sqrt(%.0f) = %f\n"
    ldc 2
    anewarray java/lang/Object

    dup
    ldc 0
    fload 0  ;Local/r
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    dup
    ldc 1
    fload 0  ;Local/r
    invokestatic SquareRoot/sqrt(F)F
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    fload 0  ;Local/r
    ldc 1
    i2f
    fadd
    fstore 0 ;Local/r
    goto L002
L004:

    getstatic	SquareRoot/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 16
.limit stack  16
.end method
