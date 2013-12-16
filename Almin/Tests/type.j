.class public Type
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
    putstatic	Type/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Type/_standardIn LPascalTextIn;


;generating record/v1
    new  java/util/HashMap
    dup
    invokenonvirtual  java/util/HashMap/<init>()V
    dup
    ldc "x"
    ldc 0
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    astore 1 ;record/v1

    aload 1 ;record/v1
    ldc "x"
    ldc 2
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 1  ;Local/v1
    ldc "x"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    istore 0 ;Local/a
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "v1.x=%d"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    aload 1  ;Local/v1
    ldc "x"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop


    getstatic	Type/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 4
.limit stack  16
.end method
