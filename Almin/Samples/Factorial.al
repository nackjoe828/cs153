int factrecur(int n){
VAR:
	int result;
BODY:
	if(n == 1){
		return 1;
	}

	result = factrecur(n-1) * n;
	return result;
}

int factnonrecur(int n){
VAR:
	int result;
	int count;
BODY:
	result = 1;
	count = 1;
	while(count <= n){
		result = result * count;
		count = count + 1;
	}
	return result;
}

main{
VAR:
	int x;
BODY:
	x = 10;
	printf("x = %d, factrecur(x) = %d\n", x, factrecur(x));
	printf("x = %d, factnonrecur(x) = %d\n", x, factnonrecur(x));
}