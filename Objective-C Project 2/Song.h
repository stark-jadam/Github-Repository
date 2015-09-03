//
//  Header.h
//  Final
//
//  Created by Jonathan Stark on 12/13/14.
//  Copyright (c) 2014 Jonathan Stark. All rights reserved.
//

#ifndef Final_Header_h
#define Final_Header_h

@interface Song : NSObject
{
    NSString *songName;
    NSString *artist;
}

@property(nonatomic) NSString* songName;
@property(nonatomic) NSString* artist;

-(NSString*) getSongName;  //gets song name
-(NSString*) getArtist;  //gets artist
-(void) setArtist:(NSString *)artist;
-(void) setSongName:(NSString *)songName;

@end

#endif
