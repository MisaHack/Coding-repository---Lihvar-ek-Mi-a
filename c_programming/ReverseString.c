#include <stdio.h>
#include <string.h>

void print_reverse(char *s){
   //size of array c
   size_t len = strlen(s);

   char *t = s + len - 1;

   printf("Reverse word: ");

   while(t >= s){
      printf("%c", *t);
      t = t - 1;
   }
   puts("");

}

int main(){
   char input[20];

   printf("Enter word: ");
   scanf("%19s", input);

   print_reverse(input);

   return 0;
}
