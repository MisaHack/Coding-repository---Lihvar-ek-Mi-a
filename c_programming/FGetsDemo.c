#include <stdio.h>

int main(){
   char food[5];

   printf("Enter your favourite food: ");

   fgets(food, sizeof(food),stdin); // "food" is array variable, not pointer variable

   printf("Favourite: %s\n", food);

   return 0;

}
