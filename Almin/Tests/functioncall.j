.class public Functioncall
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

.method public static pow(FI)F
    ldc 0
    istore 2 ;Local/i
    ldc 1.0
    fstore 3 ;Local/ret
L002:
    iload 2  ;Local/i
    iload 1  ;Local/exp
    if_icmplt L003
    goto L004
L003:
    fload 3  ;Local/ret
    fload 0  ;Local/b
    fmul
    fstore 3 ;Local/ret
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "ret=%f\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    fload 3  ;Local/ret
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    iload 2  ;Local/i
    ldc 1
    iadd
    istore 2 ;Local/i
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "i=%d\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    iload 2  ;Local/i
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    goto L002
L004:
    fload 3  ;Local/ret
    freturn


.limit locals 4
.limit stack  16
.end method

.method public static pow2(FI)F
    iload 1  ;Local/exp
    ldc 0
    if_icmpeq L002
    goto L003
L002:
    ldc 1.0
    freturn


L003:
    fload 0  ;Local/b
    fload 0  ;Local/b
    iload 1  ;Local/exp
    ldc 1
    isub
    invokestatic Functioncall/pow2(FI)F
    fmul
    freturn


.limit locals 2
.limit stack  16
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Functioncall/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Functioncall/_standardIn LPascalTextIn;

    ldc 2
    i2f
    fstore 1 ;Local/b
    ldc 0
    istore 2 ;Local/exp
L002:
    iload 2  ;Local/exp
    ldc 12
    if_icmplt L003
    goto L004
L003:
    fload 1  ;Local/b
    iload 2  ;Local/exp
    invokestatic Functioncall/pow2(FI)F
    fstore 0 ;Local/ans
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "ans=%.2f\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    fload 0  ;Local/ans
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    iload 2  ;Local/exp
    ldc 1
    iadd
    istore 2 ;Local/exp
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "exp=%d\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    iload 2  ;Local/exp
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    goto L002
L004:

    getstatic	Functioncall/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 4
.limit stack  16
.end method
