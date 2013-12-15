.class public While
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
    ldc 0
    istore 1 ;Local/exp
L002:
    iload 1  ;Local/exp
    ldc 10
    if_icmplt L003
    goto L004
L003:
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

    iload 1  ;Local/exp
    ldc 1
    iadd
    istore 1 ;Local/exp
    goto L002
L004:


    return

.limit locals 4
.limit stack  16
.end method
