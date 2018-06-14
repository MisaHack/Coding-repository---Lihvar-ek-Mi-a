#include <stdio.h>

void encryption(char *message){
   char c;

   while(*message){
      *message = *message ^ 31;
      message++;
   }
}

int main(){
   FILE *out = fopen("out.txt","w");

   char msg[] = "Programming in C is so awesome!";

   encryption(msg);

   fprintf(out,"%s\n",msg);

   encryption(msg);

   printf("%s\n",msg);

   return 0;
}
