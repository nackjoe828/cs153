.class public Type
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
    fstore 0 ;Local/v1
    ldc 2
    fstore 0 ;Local/v1
    ldc 3
    fstore 0 ;Local/v1
    ldc 3
    fstore 1 ;Local/v2
    ldc 2
    fstore 1 ;Local/v2
    ldc 1
    fstore 1 ;Local/v2
    fload 0  ;Local/v1
    fload 1  ;Local/v2
    iadd
    fstore 2 ;Local/v3


    return

.limit locals 4
.limit stack  16
.end method
