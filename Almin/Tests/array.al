void foo(int x) 
{
	printf("x=%d\n",x);
}

main {
VAR:
	int[10] i;
	int x;
	int y;
BODY:
	x = 0;
     while(x < 10){
     	i[x] = x * 10;
     	y = i[x];
     	foo(i[x]);
     	//printf("i[%d]=%d\n",x, y);
     	x = x + 1;
     }
}