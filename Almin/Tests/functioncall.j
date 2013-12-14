.class public Functioncall
.super java/lang/Object


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

    getstatic Functioncall/b F
    ldc 0.0
    getstatic Functioncall/exp I
    ldc 0
L002:
    getstatic Functioncall/exp I
    ldc 10
    if_icmpgt L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifne L005
    getstatic Functioncall/ans F
    getstatic Functioncall/b F
    getstatic Functioncall/exp I
    invokestatic Functioncall/pow(FI)F
    getstatic Functioncall/exp I
    getstatic Functioncall/exp I
    ldc 1
    iadd
    goto L002:
L005:
    getstatic Functioncall/exp I
    ldc 0
    if_icmpeq L006
    iconst_0
    goto L007
L006:
    iconst_1
L007:
    ifeq L008
    getstatic Functioncall/exp I
    ldc 4
L008:


    return

.limit locals 4
.limit stack  16
.end method
