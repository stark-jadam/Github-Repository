//
//  SongList.m
//  Final
//
//  Created by Jonathan Stark on 12/13/14.
//  Copyright (c) 2014 Jonathan Stark. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "SongList.h"
#import "Song.h"

@implementation SongList : NSObject

@synthesize songList;

-(void) addSong:(Song*) name
{
    [songList arrayByAddingObject:name];  //adds a song object to the array
}
-(void) printToFile
{
    [[NSFileManager defaultManager] createFileAtPath:@"/Mysongs.txt" contents:nil attributes:nil];
    for(int i = 0; i < [songList count]; i++){
        NSString *songTitle = [songList[i] getSongName];
        NSString *artist = [songList[i] getArtist];
        [songTitle writeToFile:@"/Mysongs.txt" atomically:YES encoding:NSUTF8StringEncoding error:nil];
        [artist writeToFile:@"/Mysongs.txt" atomically:YES encoding:NSUTF8StringEncoding error:nil];
    }
}

-(void) sort
{
    NSSortDescriptor *sortDescriptor;
    sortDescriptor = [[NSSortDescriptor alloc] initWithKey:@"artist"
                                                 ascending:YES];
    NSArray *sortDescriptors = [NSArray arrayWithObject:sortDescriptor];
    NSArray *sortedArray;
    sortedArray = [songList sortedArrayUsingDescriptors:sortDescriptors];
    songList = sortedArray;
    
}

@end
