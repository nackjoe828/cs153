.class public Assign
.super java/lang/Object


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

    getstatic Assign/i I
    getstatic Assign/j I
    getstatic Assign/i I
    getstatic Assign/i I
    if_icmpgt L002
    ldc 1000
    iadd


    return

.limit locals 4
.limit stack  16
.end method
