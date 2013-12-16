TYPE:
Rectangle {
  int width;
  int height;
}

FUNC: 
int perimeter(Rectangle rec) {
VAR:

BODY:
  return (rec.width)*2 + (rec.height)*2;
}

int area(Rectangle rec) {
VAR:
BODY:
  return (rec.width)*(rec.height);
}

main {
VAR:
int x;
int y;
int z;
int counter;

BODY:
x = 50;
y = 200;
z = -100;
counter = 1;

Rectangle r1;          // valid
r1.width = x;
r1.height = y;    

Rectangle r2;          // invalid
r2.width = y;
r2.height = z;

	printf("Rectangle 1(%d,%d) Area: %d \n,r1.width,r1.height, area(r1));
	printf("Rectangle 1(%d,%d) Perimeter: %d \n,r1.width, r1.height, perimeter(r1));
	printf("Rectangle 2(%d,%d) Area: %d \n,r2.width, r2.height,area(r2));
	printf("Rectangle 2(%d,%d) Perimeter: %d \n,r2.width, r2.height,perimeter(r2));


}