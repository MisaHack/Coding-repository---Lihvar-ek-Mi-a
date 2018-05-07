#include <stdio.h>

int main(){
   int x1;
   int x2;

   printf("Insert first number --- ");
   scanf("%i",&x1);

   printf("Insert second number --- ");
   scanf("%i",&x2);

   printf("%i - %i = %i\n", x1, x2, (x1-x2));

   return 0;
}
