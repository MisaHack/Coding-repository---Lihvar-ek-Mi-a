#include <stdio.h>
#include <math.h>

int main(){
   double x1;
   double y1;

   double x2;
   double y2;

   double x3;
   double y3;

   scanf("%lf", &x1);
   scanf("%lf", &y1);
   scanf("%lf", &x2);
   scanf("%lf", &y2);
   scanf("%lf", &x3);
   scanf("%lf", &y3);

   double a = x1 * (y2 - y3);
   double b = x2 * (y3 - y1);
   double c = x3 * (y1 - y2);

   double area = fabs((a+b+c)/2.0);

   printf("%lf", area);


   return 0;
}
