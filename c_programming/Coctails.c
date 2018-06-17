#include <stdio.h>

typedef union{
   float lemon;
   int lime_pieces;
}lemon_lime;



typedef struct{
   float tequila;
   float cointreau;
   lemon_lime citrus;
}margarita;

void mix_1(float a,float b, float c){
   printf("%2.1f measures of tequila\n%2.1f measures of cointreau\n%2.1f measures of juice\n\n",a,b,c);
}


void mix_2(float a,float b, float c){
   printf("%2.1f measures of tequila\n%2.1f measures of cointreau\n%2.1f measures of juice\n\n",a,b,c);
}


void mix_3(float a,float b, int c){
   printf("%2.1f measures of tequila\n%2.1f measures of cointreau\n%i measures of juice\n\n",a,b,c);
}

int main(){
  margarita m = {2.0,1.0,{2}};
  margarita m2 = {2.0,1.0,{0.5}};
  margarita m3 = {2.0,1.0,{.lime_pieces=1}};

  mix_1(m.tequila,m.cointreau,m.citrus.lemon);
  mix_2(m2.tequila,m2.cointreau,m2.citrus.lemon);
  mix_3(m3.tequila,m3.cointreau,m3.citrus.lime_pieces);

  return 0;
}
