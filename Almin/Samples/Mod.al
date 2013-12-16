int mod(int x, int y){
	while(x >= y){
		x = x - y;
	}
	return x;
}

main{
	printf("%d",mod(48,24));
}