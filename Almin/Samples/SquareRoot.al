//Program to list prime numbers up to a given number
real avg(real x, real y){
	return (x+y)/2.0;
}

real sqrt (real n){
VAR:
	real guess;
	real temp;
	real delta;
	int count;
BODY:
	guess = 1.0;
	delta = 1;
	count = 0;

	while (delta > 0.0001) {
		temp = n/guess;
		//printf("temp%f",temp);
		guess = avg(guess, temp);
		delta = guess*guess - n;
		if(delta < 0.0) delta = delta - delta * 2.0;
		//printf("%fguess%f\n",n,guess);
		count = count + 1;
	}
	return guess;
}

main{
VAR:
	real r;
BODY:
	r = 1.0;
	while (r <= 100.0){
		printf("sqrt(%.0f) = %f\n",r,sqrt(r));
		r = r + 1;
	}
}