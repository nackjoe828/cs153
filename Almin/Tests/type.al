
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
	}