#include <stdio.h>


void backward(int *num){
   while(*num){
      *num = *num + 1;
      num++;
   }
}


int main(){
    int numbers[] = {1,2,3};

    backward(numbers);

    int size = sizeof(numbers)/sizeof(int);

    printf("%i\n", sizeof(numbers)/sizeof(int));

    char c;

    scanf("%c",c);

    if(('a' <= c) && (c <= 'z'))
       printf("Znak je slovo!");

    for(int i=0; i < size; i++){
        printf("%i,", numbers[i]);
    }

    return 0;

}
