//
//  main.m
//  SwipeNote2
//
//  Created by Duong Bao Duy on 4/21/14.
//  Copyright (c) 2014 Duong Bao Duy. All rights reserved.
//

#import <UIKit/UIKit.h>

#import "SwipeNoteAppDelegate.h"

int main(int argc, char * argv[])
{
    NSAutoreleasePool *pool = [[NSAutoreleasePool alloc] init];
    int retVal = UIApplicationMain(argc, argv,nil,nil);
    [pool release];
    return retVal;
//    @autoreleasepool {
//        return UIApplicationMain(argc, argv, nil, NSStringFromClass([SwipeNoteAppDelegate class]));
//    }
}
