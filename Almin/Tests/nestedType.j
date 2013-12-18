.class public NestedType
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
    putstatic	NestedType/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	NestedType/_standardIn LPascalTextIn;


;generating record/s2
    new  java/util/HashMap
    dup
    invokenonvirtual  java/util/HashMap/<init>()V
    dup
    ldc "s"

;generating record/s
    new  java/util/HashMap
    dup
    invokenonvirtual  java/util/HashMap/<init>()V
    dup
    ldc "i"
    ldc 0
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    dup
    ldc "j"
    ldc 0
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    astore 0 ;record/s
;done generating record/s

    aload 0 ;record/s
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    astore 1 ;record/s2
;done generating record/s2

    aload 0 ;record/s
    dup
    ldc "i"
    ldc 3
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 0 ;record/s
    dup
    ldc "j"
    aload 0 ;Record/s
    ldc "i"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer.intValue()I
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 0 ;Record/s
    ldc "j"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer.intValue()I
    istore 2 ;Local/x
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "%d\n"
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    iload 2  ;Local/x
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop


    getstatic	NestedType/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 16
.limit stack  16
.end method
