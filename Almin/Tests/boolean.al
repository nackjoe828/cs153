bool foo(int x){
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
	bool[3] bools;
BODY:
	i = 1;
	
	if(foo(i)){
		printf("Yes!");
	}
	else{
		printf("No");
	}
}