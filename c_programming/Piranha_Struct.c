#include <stdio.h>

struct fish{
   const char *name;
   const char *species;
   int teeth;
   int age;
};

void catalog(struct fish f){
   printf("%s is %s with a %i teeth. He is %i old.\n",
          f.name,f.species,f.teeth,f.age);
}

void label(struct fish f){
   printf("Name:%s\nSpecies:%s\nTeeth:%i\nAge:%i",
          f.name,f.species,f.teeth,f.age);
}

int main(){
   struct fish snappy = {"Spappy","Piranha",69,4};
   struct fish misa = {"Misa","Human",32,28};

   catalog(snappy);
   label(snappy);

   catalog(misa);
   label(misa);

    return 0;
}
