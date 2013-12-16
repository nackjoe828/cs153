
TYPE:
	vector { 
		int x;
		real y;
		string z;
	}

FUNC:
	vector foo(vector x){

		return x;
	}

	main {
	VAR: 
		vector v1;
		int a;
	BODY:
		v1.z = "hello%d";

		printf(v1.z,3);

		/*
		v1.x = 2;
		//a = v1.x;

		v1 = foo(v1);

		printf("v1.x=%d,v1.y=%f\n",v1.x,v1.y);
		
		//v = v1 + v2;
		*/
	}