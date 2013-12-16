TYPE:
	st {
		int[5] x;
		int[5] y;
	}
FUNC:
main {
VAR:
	st[5] a;
BODY:
     a[3].x[1] = 1;
     a[3].y[1] = 3;
}