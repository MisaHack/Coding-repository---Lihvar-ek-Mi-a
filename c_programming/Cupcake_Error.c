#include <stdio.h>

typedef union{
   float weight;
   int count;
}cupcake;

int main(){
  cupcake c = {2}; //we gave value to the wrong field

  printf("Cupcakes quantity: %i\n",c.count); //this is a mistake

  return 0;
}
