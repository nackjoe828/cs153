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

.method public static foo(Ljava/util/HashMap;)Ljava/util/HashMap;
    aload 0  ;Local/x
    areturn


.limit locals 1
.limit stack  16
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
    dup
    ldc "y"
    ldc 0.0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    dup
    ldc "z"
    ldc ""
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    astore 1 ;record/v1
;done generating record/v1

    aload 1 ;record/v1
    aload 1  ;Local/v1
    ldc "z"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/lang/String
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1  ;Local/v1
    ldc "z"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/lang/String
    ldc 1
    anewarray java/lang/Object

    dup
    ldc 0
    ldc 3
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop


    getstatic	Type/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 16
.limit stack  16
.end method
