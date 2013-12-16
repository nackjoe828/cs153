.class public Vector
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

.method public static add(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;

;generating record/result
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
    ldc 0
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    astore 2 ;record/result

    aload 2 ;record/result
    ldc "x"
    aload 0  ;Local/x
    ldc "x"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    aload 1  ;Local/y
    ldc "x"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    iadd
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 2 ;record/result
    ldc "y"
    aload 0  ;Local/x
    ldc "y"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    aload 1  ;Local/y
    ldc "y"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    iadd
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 2  ;Local/result
    areturn


.limit locals 3
.limit stack  16
.end method

.method public static main([Ljava/lang/String;)V

    new	 RunTimer
    dup
    invokenonvirtual	RunTimer/<init>()V
    putstatic	Vector/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	Vector/_standardIn LPascalTextIn;


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
    ldc 0
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    astore 0 ;record/v1


;generating record/v2
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
    ldc 0
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    astore 1 ;record/v2


;generating record/v3
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
    ldc 0
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    astore 2 ;record/v3

    aload 0 ;record/v1
    ldc "x"
    ldc 2
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 0 ;record/v1
    ldc "y"
    ldc 4
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 1 ;record/v2
    ldc "x"
    ldc 3
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 1 ;record/v2
    ldc "y"
    ldc 8
    invokestatic   java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual  java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "v1.x=%d,v1.y=%d\n"
    ldc 2
    anewarray java/lang/Object

    dup
    ldc 0
    aload 0  ;Local/v1
    ldc "x"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    dup
    ldc 1
    aload 0  ;Local/v1
    ldc "y"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "v2.x=%d,v2.y=%d\n"
    ldc 2
    anewarray java/lang/Object

    dup
    ldc 0
    aload 1  ;Local/v2
    ldc "x"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    dup
    ldc 1
    aload 1  ;Local/v2
    ldc "y"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop

    aload 0  ;Local/v1
    aload 1  ;Local/v2
    invokestatic Vector/add(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;
    astore 2 ;record/v3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "v3.x=%d,v3.y=%d\n"
    ldc 2
    anewarray java/lang/Object

    dup
    ldc 0
    aload 2  ;Local/v3
    ldc "x"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    dup
    ldc 1
    aload 2  ;Local/v3
    ldc "y"
    invokevirtual  java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast      java/lang/Integer
    invokevirtual  java/lang/Integer.intValue()I
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aastore

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop


    getstatic	Vector/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 16
.limit stack  16
.end method
