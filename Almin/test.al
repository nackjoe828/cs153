void proc1() {
// does nothing
}

// pow computes b^exp
void pow(real b, int exp) {
DECLARATION:
	int i;
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
	while (exp < 10) {
		pow(b, exp);
		exp=exp+1;
	}
}


