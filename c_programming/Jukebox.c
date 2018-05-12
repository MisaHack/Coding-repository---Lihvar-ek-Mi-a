#include <stdio.h>
#include <string.h>

int main(){
    char input[80];
    int true = 0;

    char song_list[][80] = {"Song1",
                            "Song2",
                            "Song3",
                            "Song4",
                            "Song5",};

    //printf("Size of song_list -> %i\n", sizeof(song_list)); -> 400 is answer
    puts("----------JUKEBOX----------");
    printf("Insert name of the song that you want to listen: ");
    //fgets(input, 80, stdin); //-> for some reason it doesn't work
    scanf("%79s",input);

    for(int i=0; i < 5; i++){
       if(strstr(song_list[i], input)){
          printf("Song you picked: %s\n", song_list[i]);
          true = 1;
       }
    }

    if(true == 0)
       printf("Song you picked: doesn't exist.");

    return 0;

}
