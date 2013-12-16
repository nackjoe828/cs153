int fact(int n){
VAR:
	int result;
BODY:
	if(n == 1){
		return 1;
	}

	result = fact(n-1) * n;
	return result;
}

main{
VAR:
	int x;
BODY:
	x = 10;
	printf("x = %d, fact(x) = %d\n", x, fact(x));
}