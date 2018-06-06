#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Console input: MultipleFIles_Console mermaid mermaid.csv Elvis elvises.csv the_rest.csv
//order of input doesn't matter if your code read it properly

int main(int argc, char *argv[]){
   char line[80];

   if(argc != 6){
      printf("Your command doesn't have 5 arguments!");
      return 1;
   }

   FILE *in = fopen("spooky_new_2.csv","r");

   //we can check for errors in this way
   /*
   FILE *in;
   if(!(in = fopen("spooky_new_2.csv","r"))){
      fprintf(stderr,"There was a problem reading a file.\n");
      return 1;
   }
   */

   FILE *file1 = fopen(argv[2], "w");
   FILE *file2 = fopen(argv[4], "w");
   FILE *file3 = fopen(argv[5], "w");

   while(fscanf(in,"%79[^\n]\n",line) == 1){
      if(strstr(line, argv[1]))
         fprintf(file1,"%s\n",line);
      else if(strstr(line, argv[3]))
         fprintf(file2,"%s\n",line);
      else
         fprintf(file3,"%s\n",line);
   }

   fclose(file1);
   fclose(file2);
   fclose(file3);

   return 0;
}
