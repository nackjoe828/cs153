.class public HelloWorld
.super java/lang/Object


.method public static hello()V

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc " Hello World. %d\n"
iconst_1
anewarray java/lang/Object
dup
iconst_0
iconst_2
invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
aastore
invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
pop

return


.limit locals 10
.limit stack 10
.end method


.method public static main([Ljava/lang/String;)V
invokestatic HelloWorld/hello()V
return
.limit locals 10
.limit stack 10
.end method