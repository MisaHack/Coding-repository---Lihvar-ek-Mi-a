//String Demo

#include <stdio.h>
int main(){
   //first way to create String
   char s1[4] = "Misaaa";// this is mistake because array length is 4 and we have 6 characters to put
   puts(s1);

   //second way to create String
   char s2[4] = {'4', '3', '2', '1'};
   puts(s2[3]);

   return 0;
}
