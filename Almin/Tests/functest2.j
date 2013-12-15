.class public Functest2
.super java/lang/Object


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static pow(FI)F
    fload 0  ;Local/b
    iload 1  ;Local/exp
    fadd
    freturn


.limit locals 2
.limit stack  16
.end method

.method public static main([Ljava/lang/String;)V

    ldc 9.0
    fstore 0 ;Local/b
    ldc 4
    istore 1 ;Local/exp
    fload 0  ;Local/b
    iload 1  ;Local/exp
    invokestatic Functest2/pow(FI)F


    return

.limit locals 4
.limit stack  16
.end method
