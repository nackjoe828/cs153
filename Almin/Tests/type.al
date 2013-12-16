
TYPE:
	vector { 
		int x;
	}

FUNC:
	main {
	VAR: 
		vector v1;
		int a;
	BODY:
		v1.x = 2;
		a = v1.x;

		printf("v1.x=%d",v1.x);
		
		//v = v1 + v2;
	}