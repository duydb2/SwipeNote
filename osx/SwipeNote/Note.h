//
//  Note.h
//  SwipeNote
//
//  Created by Duong Bao Duy on 4/21/14.
//  Copyright (c) 2014 Duong Bao Duy. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Note : NSObject {
    NSString *title;
    NSString *content;
}

@property (nonatomic, copy) NSString *title;
@property (nonatomic, copy) NSString *content;

-(id) initWith:(NSString*)t content:(NSString*) c;

@end
