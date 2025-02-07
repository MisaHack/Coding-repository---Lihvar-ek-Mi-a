#include <stdio.h>

int main(){
   float latitude;
   float longitude;
   char info[80];
   int started = 0;

   puts("data=[");
   while(scanf("%f, %f, %79[^\n]", &latitude,&longitude,info) == 3){
      if(started){
         printf(",\n");
      }
      else{
         started = 1;
      }

      if((latitude < -90)||(90 < latitude)){
         printf("Invlalid latitude: %f", latitude);
         return 2;
      }
      if((longitude < -180)||(180 < longitude)){
         printf("Invalid longitude: %f", longitude);
         return 2;
      }

      printf("{latitude: %f, longitude: %f, info: '%s' }", latitude, longitude, info);
   }
   puts("\n]");

   return 0;
}
