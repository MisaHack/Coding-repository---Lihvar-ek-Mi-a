#include <stdio.h>
#include <math.h>

int main(){
   int x1;
   int y1;

   int x2;
   int y2;

   scanf("%i", &x1);
   scanf("%i", &y1);

   scanf("%i", &x2);
   scanf("%i", &y2);

   int stranica_a = x1 - x2;
   int stranica_b = y1 - y2;

   int pow_a = pow(stranica_a, 2);
   int pow_b = pow(stranica_b, 2);

   double rez = sqrt(pow_a + pow_b);

   printf("%.2lf\n", rez);

   printf("%i\n", 2*abs(stranica_a)+2*abs(stranica_b));

   printf("%i\n", abs(stranica_a) * abs(stranica_b));


   return 0;

}
