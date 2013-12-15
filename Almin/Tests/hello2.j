.class public HelloWorld2
.super java/lang/Object


.method public static hello(II)V

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc " Hello World. %d, %d\n"
iconst_2
anewarray java/lang/Object
dup
iconst_0
iload 0
invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
aastore

dup
iconst_1
iload 1
invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
aastore

invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
pop

return


.limit locals 10
.limit stack 10
.end method

.method public static add(III)I

iload 0
iload 1
iadd
iload 2
iadd

ireturn


.limit locals 10
.limit stack 10
.end method


.method public static main([Ljava/lang/String;)V
iconst_1
iconst_2
iconst_3
invokestatic HelloWorld2/add(III)I
iconst_1
invokestatic HelloWorld2/hello(II)V
return
.limit locals 10
.limit stack 10
.end method