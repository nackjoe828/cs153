
//a method that takes two vector type variables, and return one vector with each field added

TYPE:
	vector { 
		int x;
		int y;
	}

FUNC:
	vector add(vector x, vector y){
	VAR:
		vector result;
	BODY:
		result.x = x.x + y.x;
		result.y = x.y + y.y;
		return result;
	}

	main {
	VAR: 
		vector v1;
		vector v2;
		vector v3;
	BODY:
		v1.x = 2;
		v1.y = 4;
		v2.x = 3;
		v2.y = 8;

		printf("v1.x=%d,v1.y=%d\n",v1.x,v1.y);
		printf("v2.x=%d,v2.y=%d\n",v2.x,v2.y);

		v3 = add(v1,v2);

		printf("v3.x=%d,v3.y=%d\n",v3.x,v3.y);
	}