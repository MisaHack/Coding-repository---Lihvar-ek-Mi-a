#include <stdio.h>
#include <math.h>


int main(){
   double ax;
   double ay;

   double bx;
   double by;

   scanf("%lf", &ax);
   scanf("%lf", &ay);

   scanf("%lf", &bx);
   scanf("%lf", &by);

   double aa= ax-bx;
   double bb = ay-by;

   double pow_a = pow(aa, 2);
   double pow_b = pow(bb, 2);

   double rez = sqrt(pow_a + pow_b);

   printf("%.5lf", rez);

   return 0;
}
