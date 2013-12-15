
TYPE:
	vector { 
		real x;
		real y;
		real z; 
	}

VAR:
	vector v;

FUNC:
	main {
	VAR: 
		vector v1;
		vector v2;
		vector v3;
	BODY:
		v1.x = 1;
		v1.y = 2;
		v1.z = 3;
		
		v2.x = 3;
		v2.y = 2;
		v2.z = 1;
		
		v = v1 + v2;
	}