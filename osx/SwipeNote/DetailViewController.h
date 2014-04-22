//
//  DetailViewController.h
//  SwipeNote
//
//  Created by Duong Bao Duy on 4/21/14.
//  Copyright (c) 2014 Duong Bao Duy. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DetailViewController : UIViewController {
    UITextField *noteTitle;
    UITextField *noteContent;
}

@property (nonatomic, retain) IBOutlet UITextField *noteTitle;
@property (nonatomic, retain) IBOutlet UITextField *noteContent;

@end
