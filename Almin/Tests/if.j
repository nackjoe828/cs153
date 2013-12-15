.class public If
.super java/lang/Object


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

    ldc 0.0
    fstore 0 ;Local/b
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "%f\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    fload 0  ;Local/b
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    ldc 0
    ldc 5
    imul
    istore 1 ;Local/exp
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

    ldc 0.0
    ldc 1.0
    ldc 3.0
    fdiv
    fadd
    fstore 0 ;Local/b
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "%f\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    fload 0  ;Local/b
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    iload 1  ;Local/exp
    ldc 0
    if_icmpge L002
    iconst_0
    goto L003
L002:
    iconst_1
L003:
    ifeq L004
    ldc 100.0
    fstore 0 ;Local/b
L004:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "%f\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    fload 0  ;Local/b
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop



    return

.limit locals 4
.limit stack  16
.end method
