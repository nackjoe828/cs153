.class public ReverseOrder
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LPascalTextIn;


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	ReverseOrder/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	ReverseOrder/_standardIn LPascalTextIn;


;generating array/original
    ldc 10
    newarray int
    astore 1 ;array/original


;generating array/reverse
    ldc 10
    newarray int
    astore 2 ;array/reverse

    ldc 0
    istore 0 ;Local/count
L002:
    iload 0  ;Local/count
    ldc 10
    if_icmplt L003
    goto L004
L003:
    aload 1 ;array/original
    iload 0  ;Local/count
    iload 0  ;Local/count
    iastore  ;array/original
    iload 0  ;Local/count
    ldc 1
    iadd
    istore 0 ;Local/count
    goto L002
L004:
L005:
    iload 0  ;Local/count
    ldc 0
    if_icmpge L006
    goto L007
L006:
    aload 2 ;array/reverse
    ldc 9
    iload 0  ;Local/count
    fsub
    aload 1  ;Local/original
    iload 0  ;Local/count
    iaload 
    iastore  ;array/reverse
    iload 0  ;Local/count
    ldc 1
    isub
    istore 0 ;Local/count
    goto L005
L007:
L008:
    iload 0  ;Local/count
    ldc 9
    if_icmplt L009
    goto L010
L009:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "original[%d] = %d"
    ldc 2
    anewarray java/lang/Object

    dup
    ldc 0
    iload 0  ;Local/count
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    dup
    ldc 1
    aload 1  ;Local/original
    iload 0  ;Local/count
    iaload 
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "reverse[%d] = %d"
    ldc 2
    anewarray java/lang/Object

    dup
    ldc 0
    iload 0  ;Local/count
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    dup
    ldc 1
    aload 2  ;Local/reverse
    iload 0  ;Local/count
    iaload 
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    goto L008
L010:

    getstatic	ReverseOrder/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 4
.limit stack  16
.end method
