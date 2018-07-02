#include <stdio.h>

typedef struct island{
   char *name;
   char *opens;
   char *closes;
   struct island *next;
}island;


void display(island *start){
   island *i = start;

   for(;i != NULL; i = i->next){
      printf("Name: %s Open: %s-%s\n",i->name,i->opens,i->closes);
   }
}

int main(){
  island a = {"a","12","13",NULL};
  island b = {"b","9","10",NULL};
  island c = {"c","13","14",NULL};

  a.next = &b;
  b.next = &c;

  island d = {"d","8","16",NULL};
  b.next = &d;
  d.next = &c;

  display(&a);

  return 0;
}
