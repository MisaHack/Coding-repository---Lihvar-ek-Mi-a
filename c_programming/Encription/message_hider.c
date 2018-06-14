#include <stdio.h>
#include "encryption.h"

int main(){
   char msg[80];

   while(fgets(msg,80,stdin)){
      encryption(msg);

      printf("%s", msg);
   }

   return 0;
}
