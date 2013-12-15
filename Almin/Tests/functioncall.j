.class public Functioncall
.super java/lang/Object


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static proc1()
.limit locals 0
.limit stack  16
.end method

.method public static pow(FI)F
    ldc 0
    putstatic Functioncall/i I
    ldc 1.0
    putstatic Functioncall/ret F
L002:
    getstatic Functioncall/i I
    getstatic Functioncall/exp I
    if_icmpgt L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifne L005
    getstatic Functioncall/ret F
    getstatic Functioncall/b F
    fmul
    putstatic Functioncall/ret F
    getstatic Functioncall/i I
    ldc 1
    fadd
    putstatic Functioncall/i I
    goto L002
L005:
    getstatic Functioncall/ret F
.limit locals 4
.limit stack  16
.end method

.method public static main([Ljava/lang/String;)V

    ldc 0.0
    putstatic Functioncall/b F
    ldc 0
    putstatic Functioncall/exp I
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
    getstatic Functioncall/b F
    getstatic Functioncall/exp I
    invokestatic Functioncall/pow(FI)F
    putstatic Functioncall/b F
    getstatic Functioncall/exp I
    ldc 1
    iadd
    putstatic Functioncall/exp I
    goto L002
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
    ldc 4
    putstatic Functioncall/exp I
L008:


    return

.limit locals 4
.limit stack  16
.end method
