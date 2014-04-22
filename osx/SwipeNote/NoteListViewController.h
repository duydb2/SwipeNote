//
//  NoteListViewController.h
//  SwipeNote
//
//  Created by Duong Bao Duy on 4/21/14.
//  Copyright (c) 2014 Duong Bao Duy. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "DetailViewController.h"

@interface NoteListViewController : UITableViewController{
    DetailViewController *detailController;
}

@property (nonatomic, retain) NSMutableArray *notes;
@property (nonatomic, retain) DetailViewController *detailController;

@end
