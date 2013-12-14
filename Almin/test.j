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
    getstatic Test/exp I
    ldc 10
    if_icmpgt L002
    getstatic Test/b F
    getstatic Test/exp I
    invokestatic Test/pow(FI)F
    putstatic Test/ans F
    ldc "%f^%d = %f"
    getstatic Test/b F
    getstatic Test/exp I
    getstatic Test/ans F
    invokestatic Test/printf(nullFIF)
    getstatic Test/exp I
    ldc 1
    iadd
    putstatic Test/exp I
    getstatic Test/exp I
    ldc 0
    if_icmpeq L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifeq L005
    ldc 4
    putstatic Test/exp I
L005:


    return

.limit locals 4
.limit stack  16
.end method
