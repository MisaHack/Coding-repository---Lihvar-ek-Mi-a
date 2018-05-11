#include <stdio.h>

int main(){
   char *cards = "JQK"; // Our program will break because String cannot be changed, but without warning 
   //const char *cards = "JQK"; this will give us ERROR -> String literals cannot be changed!
   //char cards[] = "JQK"; -> Now this WORKS!

   char card = cards[2];

   cards[2] = cards[1];
   cards[1] = cards[0];
   cards[0] = cards[2];
   cards[2] = cards[1];
   cards[1] = card;

   puts(cards);

   return 0;

}
