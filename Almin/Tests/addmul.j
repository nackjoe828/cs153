.class public Addmul
.super java/lang/Object


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

    ldc 1
    istore 1 ;Local/i
    ldc 5.0
    fstore 2 ;Local/r
    iload 1  ;Local/i
    i2f
    fload 2  ;Local/r
    fadd
    fstore 0 ;Local/ans
    fload 0  ;Local/ans
    ldc 1
    i2f
    fmul
    ldc 4.0
    fadd
    ldc 2
    ldc 3
    imul
    i2f
    fadd
    fstore 0 ;Local/ans


    return

.limit locals 4
.limit stack  16
.end method
