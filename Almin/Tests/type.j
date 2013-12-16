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

.method public static retstr()Ljava/lang/String;
    ldc "Hello"
    areturn


.limit locals 0
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
    x
    ldc 0,0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    dup
    y
    ldc 0,0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    dup
    z
    ldc 0,0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    astore 0 ;record/v1


;generating record/v2
    new  java/util/HashMap
    dup
    invokenonvirtual  java/util/HashMap/<init>()V
    dup
    x
    ldc 0,0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    dup
    y
    ldc 0,0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    dup
    z
    ldc 0,0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    astore 1 ;record/v2

    aload 0  ;Local/v1
    ldc "x"
    ldc 1.0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 0  ;Local/v1
    ldc "y"
    ldc 2.0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 0  ;Local/v1
    ldc "z"
    ldc 3.0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 1  ;Local/v2
    ldc "x"
    ldc 3.0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 1  ;Local/v2
    ldc "y"
    ldc 2.0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 1  ;Local/v2
    ldc "z"
    ldc 1.0
    invokestatic   java/lang/Float.valueOf(F)Ljava/lang/Float;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 1  ;Local/v2
    ldc "z"
    fstore 2 ;Local/x

    getstatic	Type/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 4
.limit stack  16
.end method
