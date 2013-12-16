
main{
VAR:
	bool x;
	int i;
BODY:
	i = 0;
	if(foo(i)){
		printf("Yes!");
	}
	else{
		printf("No");
	}
}