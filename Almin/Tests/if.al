main {
DECLARATION:
	real b;
	int exp;
STATEMENT:
	b = 0.0;
	printf("%f\n",b);
	exp = 350;
	printf("%d\n",exp);
	b = 0.0 + 1.0 / 3.0;
	printf("%f\n",b);
	if(exp >= 300){
		b = 100.0;
	}else if(exp >= 200){
		b = 200.0;
	}else{
		b = 300.0;
	}
	printf("%f\n",b);
}


