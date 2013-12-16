
TYPE:
	vector { 
		real x;
		real y;
		real z; 
	}

FUNC:

	string retstr(){
	return "Hello";
	}

	main {
	VAR: 
		vector v1;
		vector v2;
		real x;
	BODY:
		v1.x = 1.0;
		v1.y = 2.0;
		v1.z = 3.0;
		
		v2.x = 3.0;
		v2.y = 2.0;
		v2.z = 1.0;
		x = v2.z;
		
		//v = v1 + v2;
	}