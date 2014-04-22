//
//  AppDelegate.h
//  SwipeNote2
//
//  Created by Duong Bao Duy on 4/21/14.
//  Copyright (c) 2014 Duong Bao Duy. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface SwipeNoteAppDelegate : UIResponder <UIApplicationDelegate> {
    UIWindow *window;
    UINavigationController *navigationController;
//    NSMutableArray *notes;
}

@property (nonatomic,retain) IBOutlet UIWindow *window;
@property (nonatomic,retain) IBOutlet UINavigationController *navigationController;
//@property (nonatomic, retain) NSMutableArray *notes;

@end
