.class public DateAnagram
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
    putstatic	DateAnagram/_runTimer LRunTimer;
    new	 PascalTextIn
    dup
    invokenonvirtual	PascalTextIn/<init>()V
    putstatic	DateAnagram/_standardIn LPascalTextIn;

    ldc 0
    istore 0 ;Local/i
    invokestatic DateAnagram/retstr()Ljava/lang/String;
    astore 1 ;Local/str
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iconst_4
invokestatic java/lang/Integer/toString(I)Ljava/lang/String;
    ldc 0
    anewarray java/lang/Object

    invokevirtual java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
   pop


    getstatic	DateAnagram/_runTimer LRunTimer;
    invokevirtual	RunTimer.printElapsedTime()V

    return

.limit locals 4
.limit stack  16
.end method
