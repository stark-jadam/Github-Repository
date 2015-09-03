//
//  Song.m
//  Final
//
//  Created by Jonathan Stark on 12/13/14.
//  Copyright (c) 2014 Jonathan Stark. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Song.h"

@implementation Song : NSObject

@synthesize songName;
@synthesize artist;

-(NSString*) getSongName  //gets song name
{
     return songName;
}
-(NSString*) getArtist  //gets artist
{
    return artist;
}
-(void) setSongName:(NSString*) name  //gets song name
{
    songName = name;
}
-(void) setArtist:(NSString*) name  //gets artist
{
    artist = name;
}

@end

