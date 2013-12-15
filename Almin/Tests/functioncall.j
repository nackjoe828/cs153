.class public Functioncall
.super java/lang/Object


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static pow(FI)F
    ldc 0
    istore 2 ;Local/i
    ldc 1.0
    fstore 3 ;Local/ret
L002:
    iload 2  ;Local/i
    iload 1  ;Local/exp
    if_icmpgt L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifne L005
    fload 3  ;Local/ret
    fload 0  ;Local/b
    fmul
    fstore 3 ;Local/ret
    iload 2  ;Local/i
    ldc 1
    iadd
    istore 2 ;Local/i
    goto L002
L005:
    fload 3  ;Local/ret
    freturn


.limit locals 4
.limit stack  16
.end method

.method public static main([Ljava/lang/String;)V

    ldc 0.0
    fstore 0 ;Local/b
    ldc 0
    istore 1 ;Local/exp
L002:
    iload 1  ;Local/exp
    ldc 10
    if_icmpgt L003
    iconst_0
    goto L004
L003:
    iconst_1
L004:
    ifne L005
    fload 0  ;Local/b
    iload 1  ;Local/exp
    invokestatic Functioncall/pow(FI)F
    fstore 0 ;Local/b
    iload 1  ;Local/exp
    ldc 1
    iadd
    istore 1 ;Local/exp
    goto L002
L005:
    iload 1  ;Local/exp
    ldc 0
    if_icmpeq L006
    iconst_0
    goto L007
L006:
    iconst_1
L007:
    ifeq L008
    ldc 4
    istore 1 ;Local/exp
L008:


    return

.limit locals 4
.limit stack  16
.end method
