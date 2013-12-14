void proc1() {
// does nothing
}

// pow computes b^exp
real pow(real b, int exp) {
DECLARATION:
	int k;
	real ret;
STATEMENT:
	i = 0;
	ret = 1.0;
	while (i < exp) {
		ret = ret * b;
		i=i+1;
	}
	return ret;
}

main {
DECLARATION:
	real b;
	int exp;
STATEMENT:
	b = 0.0;
	exp = 0;
	while (exp < 10) 
	{
	DECLARATION:
		real ans;
	STATEMENT:
		ans = pow(b, exp);
		printf("%f^%d = %f", b, exp, ans);
		exp=exp+1;
	}
	if (exp == 0)
		exp = 4;
}


