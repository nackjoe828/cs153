.class public Printf
.super java/lang/Object


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Hello%d%d%f\n"
    ldc 3
    anewarray java/lang/Object

    dup
    ldc 0
    ldc 2
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    dup
    ldc 1
    ldc 5
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    dup
    ldc 2
    ldc 2.5
    invokestatic java/lang/Float/valueOf(F)Ljava/lang/Float;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop



    return

.limit locals 4
.limit stack  16
.end method
