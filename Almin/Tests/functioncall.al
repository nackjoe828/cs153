// pow computes b^exp
real pow(real b, int exp) {
DECLARATION:
	real ret;
	int i;
STATEMENT:
	i = 0;
	ret = 1.0;
	while (i < exp) {
		ret = ret * b;
		printf("ret=%f\n",ret);
		i=i+1;
		printf("i=%d\n",i);
	}
	return ret;
}

real pow2(real b, int exp){
	if (exp == 0)
		return 1.0;
	return b * pow2(b, exp-1);
}

main {
DECLARATION:
	real b;
	real ans;
	int exp;
STATEMENT:
	b = 2;
	exp = 0;
	while (exp < 12) 
	{
		ans = pow2(b, exp);
		printf("ans=%.2f\n", ans);
		exp=exp+1;
		printf("exp=%d\n",exp);
	}
	//printf("%.2f\n", pow(b,exp));
	//if(1 < 1){printf("%d",1);}
	//else{printf("%d", 0);}
}


