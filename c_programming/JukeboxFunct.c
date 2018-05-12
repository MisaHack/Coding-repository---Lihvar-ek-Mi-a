//Header files
#include <stdio.h>
#include <string.h>

//Global variable is_found
int is_found = 0;

//Global array variable song_list
char song_list[][80] = {
   "Song1",
   "Song2",
   "Song3",
   "Song4",
   "Song5",
 };

//Function for finding matching song name
void find_track(char search_for[]){
    for(int i=0; i < 5; i++){
       if(strstr(song_list[i], search_for)){
          printf("Song playing %i: %s\n", i, song_list[i]);
          is_found = 1;
       }
    }

    if(is_found == 0)
       printf("Your song doesn't exist!");
}

//Main function where program starts
int main(){
   char search_for[80];

   printf("Enter song name: ");
   //fgets(search_for, 5, stdin); -> for some reason this function doesn't work
   scanf("%79s", search_for);

   find_track(search_for);

   return 0;
}
