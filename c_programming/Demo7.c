#include <stdio.h>
#include <stdlib.h>

int main(){
   char card_name[3];

   puts("Enter card name: ");
   scanf("%2s", card_name);

   int val = 0;

   if(card_name[0] == 'K'){
      val = 10;
   }
   else if(card_name[0] == 'Q'){
      val = 10;
   }
   else if(card_name[0] == 'J'){
      val = 10;
   }
   else if(card_name[0] == 'A'){
      val = 11;
   }
   else{
      val = atoi(card_name);
   }

   /* Check if the value is 3 to 6 */
   if((3 <= val) && (val <=6))
      puts("Count has gone up");

   /* Otherwise check if card was 10,J,Q or K */
   if((val == 10) || (card_name[0] == 'J') || (card_name[0] == 'Q') || (card_name[0] == 'K'))
      puts("Count has gone down");

   return 0;
}
