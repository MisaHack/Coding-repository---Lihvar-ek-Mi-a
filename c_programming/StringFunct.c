#include <stdio.h>

void fortune_cookie(char msg[]){
   printf("Message reads: %s\n", msg);
   printf("msg has length of %i bytes\n", sizeof(msg));
}

int main(){
   char quote [] = "Cookies make you fat!";

   fortune_cookie(quote);

   printf("The quote string is stored at: %p\n", quote);

   printf("Size of array quote is %i. (including NIL sign)", sizeof(quote));

   return 0;
}
