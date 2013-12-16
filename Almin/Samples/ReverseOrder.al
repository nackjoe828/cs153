main(){
VAR:
	int[10] original;
	int[10] reverse;
	int count;
BODY:
	count = 0;
	while(count < 10){
		original[count] = count;
		count = count + 1;
	}

	while(count >= 0){
		reverse[9 - count] = original[count];
		count = count - 1;
	}

	while(count < 9){
		printf("original[%d] = %d", count, original[count]);
		printf("reverse[%d] = %d", count, reverse[count]);
	}
}