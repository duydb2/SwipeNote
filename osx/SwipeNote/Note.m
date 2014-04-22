//
//  Note.m
//  SwipeNote
//
//  Created by Duong Bao Duy on 4/21/14.
//  Copyright (c) 2014 Duong Bao Duy. All rights reserved.
//

#import "Note.h"

@implementation Note

@synthesize title;
@synthesize content;

-(id)initWith:(NSString *)t content:(NSString *)c{
    self.title = t;
    self.content = c;
    return self;
}

- (void)dealloc
{
    [title release];
    [content release];
    [super dealloc];
}

@end
