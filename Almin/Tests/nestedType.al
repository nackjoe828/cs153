TYPE:
	st1 {
		int i;
		int j;
	}
	
	st2 {
		st1 s;
	}
	
FUNC:
	main {
 	VAR:
 		st2 s2;
 		int x;
 	BODY:
 		s2.s.i = 3;	
 		s2.s.j = s2.s.i;	
 		x = s2.s.j;
 		printf("%d\n", x);
	}