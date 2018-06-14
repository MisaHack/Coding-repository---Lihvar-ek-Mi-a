#include <stdio.h>

/*Print out the catalog entry*/
void catalog(char *name, const char *species, int teeth, int age){
   printf("%s is %s with a %i teeth. He is %i old.\n", name,species,teeth,age);
}

/*Print the label for the tank*/
void label(char *name, const char *species, int teeth, int age){
   printf("Name:%s\nSpecies:%s\nTeeth:%i\nAge:%i", name,species,teeth,age);
}

int main(){
    catalog("Snappy","Piranha",69,9);
    label("Snappy","Piranha",69,9);

    return 0;

}
