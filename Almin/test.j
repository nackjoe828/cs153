.class public Test
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
    putstatic Test/b F
    ldc 0
    putstatic Test/exp I
    ldc 10
    if_icmpgt L002
    putstatic Test/ans F
    ldc 1
    iadd
    putstatic Test/exp I
    ldc 0
    if_icmpeq L003
    iconst_0
    goto L004
L003:
    iconst_1
L005:
    ifeq L006
    ldc 4
    putstatic Test/exp I
L006:


    return

.limit locals 4
.limit stack  16
.end method
