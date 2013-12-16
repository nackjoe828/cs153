//Program to list prime numbers up to a given number

int mod(int x, int y){
	while(x >= y){
		x = x - y;
	}
	return x;
}

void printPrimeUpTo(int n){
VAR:
	int count;
	int x;
	int half;
	int flag;
	int printCount;
BODY:
	count = 2;
	printCount = 0;
	while (count <= n){
		flag = 1;
		half = count / 2;
		x = 2;
		while(x <= half){
			if(mod(count,x) == 0){
				flag = 0;
			}
			x = x + 1;
		}
		if(flag == 1){
			printCount = printCount + 1;
			printf("%8d",count);
			if(mod(printCount,10) == 0) printf("\n");
		}
		count = count + 1;
	}
}

main{
	printPrimeUpTo(100000);
}