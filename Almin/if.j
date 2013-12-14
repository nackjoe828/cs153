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
    putstatic If/b F
    ldc 0
    ldc 5
    imul
    putstatic If/exp I
    ldc 0.0
    ldc 1.0
    ldc 3.0
    fdiv
    fadd
    putstatic If/b F
    ldc 0
    if_icmpgt L002
    iconst_0
    goto L003
L002:
    iconst_1
L003:
    ifeq L004
    ldc 100.0
    putstatic If/b F
L004:


    return

.limit locals 4
.limit stack  16
.end method
