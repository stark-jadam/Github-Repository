//
//  SongList.h
//  Final
//
//  Created by Jonathan Stark on 12/13/14.
//  Copyright (c) 2014 Jonathan Stark. All rights reserved.
//

#ifndef Final_SongList_h
#define Final_SongList_h
#import "Song.h"

@interface SongList : NSObject{
    NSArray *songList;
}

@property NSArray* songList;

-(void) addSong:(Song*) name;  //adds a song object to the array
-(void) printToFile;
-(void) sort;

@end

#endif
