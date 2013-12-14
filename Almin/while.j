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
    putstatic While/b F
    ldc 0
    putstatic While/exp I
L002:
    getstatic While/exp I
    ldc 10
    if_icmpgt L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifne L005
    getstatic While/exp I
    ldc 1
    iadd
    putstatic While/exp I
    goto L002:
L005:


    return

.limit locals 4
.limit stack  16
.end method
