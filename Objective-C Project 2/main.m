//
//  main.m
//  Final
//
//  Created by Jonathan Stark on 12/13/14.
//  Copyright (c) 2014 Jonathan Stark. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Song.h"
#import "SongList.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
       
        SongList *myList = [[SongList alloc] init];
        
        Song *song1 = [[Song alloc] init];
        [song1 setSongName:@"My Heart Will Go On"];
        [song1 setArtist:@"Celine Dion"];
        [myList addSong:song1];
        
        Song *song2 = [[Song alloc] init];
        [song2 setSongName:@"Tubthumper"];
        [song2 setArtist:@"Chumbawumba"];
        [myList addSong:song2];
        
        Song *song3 = [[Song alloc] init];
        [song3 setSongName:@"One more time"];
        [song3 setArtist:@"Brittany Spears"];
        [myList addSong:song3];
        
        Song *song4 = [[Song alloc] init];
        [song4 setSongName:@"All the small things"];
        [song4 setArtist:@"Blink 182"];
        [myList addSong:song4];
        
        Song *song5 = [[Song alloc] init];
        [song5 setSongName:@"Ride with me"];
        [song5 setArtist:@"Nelly"];
        [myList addSong:song5];
        
        Song *song6 = [[Song alloc] init];
        [song6 setSongName:@"Rude"];
        [song6 setArtist:@"magic!"];
        [myList addSong:song6];
        
        Song *song7 = [[Song alloc] init];
        [song7 setSongName:@"Holiday"];
        [song7 setArtist:@"Green Day"];
        [myList addSong:song7];
        
        Song *song8 = [[Song alloc] init];
        [song8 setSongName:@"Chicken Fried"];
        [song8 setArtist:@"Zac Brown Band"];
        [myList addSong:song8];
        
        Song *song9 = [[Song alloc] init];
        [song9 setSongName:@"Kamikazee"];
        [song9 setArtist:@"Twista"];
        [myList addSong:song9];
        
        Song *song10 = [[Song alloc] init];
        [song10 setSongName:@"In too deep"];
        [song10 setArtist:@"Sum 41"];
        [myList addSong:song10];
        
        [myList printToFile];
        NSLog(@"Unordered list printed to file");
        [myList sort];
        [myList printToFile];
        NSLog(@"Ordered list printed to file");
        
        
        
        
    }
    return 0;
}
