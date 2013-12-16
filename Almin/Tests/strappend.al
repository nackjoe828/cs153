main{
	VAR:
	string s1;
	string s2;
	int i;
	BODY:
	s1 = "Hello";
	s2 = "World";
	i = 8;
	s1 = i + 7 + s1;
	printf(s1);
}