#include <stdio.h>

int main(){
   char food[5];
   printf("Enter favourite food: ");
   scanf("%s", food); //if input is too long program crashes
   printf("Favourite food: %s\n", food);

   return 0;
}
