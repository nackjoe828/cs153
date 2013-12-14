.class public For
.super java/lang/Object


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

    getstatic For/i I
    ldc 0
    getstatic For/i I
    ldc 10
    if_icmpgt L002
    getstatic For/i I
    getstatic For/i I
    ldc 1
    iadd
L003:
    getstatic For/j I
    ldc 10
    getstatic For/j I
    ldc 5
    getstatic For/j I
    ldc 1
    getstatic For/j I
    getstatic For/i I
