boolean foo(int x){
	if(x == 1){
		return true;
	}
	else{
		return false;
	}
}

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