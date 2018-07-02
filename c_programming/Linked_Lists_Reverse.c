#include <stdio.h>

typedef struct Node{
   char data;
   struct Node *next;
}Node;

void display(Node *start){
   Node *i = start;

   for(;i != NULL; i = i->next){
      printf("%c->", i->data);
   }
}

void reverseNodes(Node* head,int indexA,int indexB){
   Node *i = head;

   Node *prethodni_a = NULL;
   Node *ispred_b = NULL;
   Node *a = NULL;
   Node *b = NULL;

   int j = 1;

   for(;i != NULL; i = i->next){
      if((j+1) == indexA){
        prethodni_a = i;
      }
      if(j == indexA){
         a = i;
      }


      if((j-1) == indexB){
        ispred_b = i;
      }
      if(j == indexB){
         b = i;
      }

      j++;
   }

   Node *prev = NULL;
   Node *current = a;
   Node *next = NULL;

   while(current != ispred_b){
      next = current -> next;
      current->next = prev;
      prev = current;
      current = next;
   }

   if(indexA != 1){
   prethodni_a->next = b;
   a->next=ispred_b;
   }
   else{
      head = b;
   }

}

int main(){
  Node a = {'a',NULL};
  Node b = {'b',NULL};
  Node c = {'c',NULL};
  Node d = {'d',NULL};
  Node e = {'e',NULL};
  Node f = {'f',NULL};

  a.next = &b;
  b.next = &c;
  c.next = &d;
  d.next = &e;
  e.next = &f;

  reverseNodes(&a,1,6);

  display(&a);

  return 0;
}
