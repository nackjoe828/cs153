TYPE:
	st1 {
		int i;
		int j;
	}
	
	st2 {
		int i;
		st1 s;
	}
	
FUNC:
	main {
 	VAR:
 		st2 s2;
 	BODY:
 		s2.s.i = 1;
 		s2.i = 10;		
	}