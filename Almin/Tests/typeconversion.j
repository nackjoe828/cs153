.class public Typeconversion
.super java/lang/Object


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

    ldc 2
    i2f
    fstore 1 ;Local/r
    ldc 8
    istore 0 ;Local/i
    fload 1  ;Local/r
    iload 0  ;Local/i
    i2f
    fadd
    fstore 1 ;Local/r
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "%.2f\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    fload 1  ;Local/r
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    ldc 2
    i2f
    fstore 1 ;Local/r
    fload 1  ;Local/r
    iload 0  ;Local/i
    i2f
    fsub
    fstore 1 ;Local/r
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "%.2f\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    fload 1  ;Local/r
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    ldc 2
    i2f
    fstore 1 ;Local/r
    fload 1  ;Local/r
    iload 0  ;Local/i
    i2f
    fmul
    fstore 1 ;Local/r
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "%.2f\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    fload 1  ;Local/r
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    ldc 2
    i2f
    fstore 1 ;Local/r
    fload 1  ;Local/r
    iload 0  ;Local/i
    i2f
    fdiv
    fstore 1 ;Local/r
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "%.2f\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    fload 1  ;Local/r
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop



    return

.limit locals 4
.limit stack  16
.end method
