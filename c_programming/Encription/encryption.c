#include "encryption.h"

void encryption(char *message){
   char c;

   while(*message){
      *message = *message ^ 31;
      message++;
   }
}
