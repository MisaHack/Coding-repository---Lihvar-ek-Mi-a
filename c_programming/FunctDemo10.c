/* My first function! :)*/

#include <stdio.h>

int larger(int a,int b){
   if(a > b)
      return a;
   return b;
}

int main(){
   int greatest = larger(100,1000);

   printf("%i is the greatest!", greatest);

   return 0;
}
