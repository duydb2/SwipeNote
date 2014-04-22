//
//  NoteListViewController.m
//  SwipeNote
//
//  Created by Duong Bao Duy on 4/21/14.
//  Copyright (c) 2014 Duong Bao Duy. All rights reserved.
//

#import "SwipeNoteAppDelegate.h"
#import "NoteListViewController.h"
#import "Note.h"

@implementation NoteListViewController

@synthesize detailController, notes;


- (id)initWithStyle:(UITableViewStyle)style
{
    self = [super initWithStyle:style];
    if (self) {
        // Custom initialization
        self.notes = [[NSMutableArray alloc] init];
        NSLog(@"note: %@", self->notes);
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    NSLog(@"viewDidLoad");
    
    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
    
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
    self.notes = [[NSMutableArray alloc] init];
    Note *note1 = [[Note alloc]initWith:@"dfadfad" content:@"Fdsafasfas"];
    Note *note2 = [[Note alloc]initWith:@"dadfafadfad" content:@"Fdsfad13421afasfas"];
    Note *note3 = [[Note alloc]initWith:@"dfa312312dfad" content:@"Fds312321afasfas"];
    Note *note4 = [[Note alloc]initWith:@"dfa312d123123fad" content:@"Fdsaf312312asfas"];
    Note *note5 = [[Note alloc]initWith:@"dfa123123dfad" content:@"Fdsafa3123123sfas"];
    [self.notes addObject:note1];
    [self.notes addObject:note2];
    [self.notes addObject:note3];
    [self.notes addObject:note4];
    [self.notes addObject:note5];
    NSLog(@"note: %@", self.notes);
    
//        [note1 release];
//        [note2 release];
//        [note3 release];
//        [note4 release];
//        [note5 release];

    
    self.navigationItem.leftBarButtonItem = self.editButtonItem;
}

-(void)viewDidUnload{
    self.notes = nil;
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    // Return the number of sections.
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
   
    return [self.notes  count];
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *CellIdentifier = @"Cell";
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if (cell == nil){
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier];
    }
    
    
    // Configure the cell...
    cell.textLabel.text = [[self.notes  objectAtIndex:indexPath.row] title];
    
    return cell;
}

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath{
    // Navigation logic
//    SwipeNoteAppDelegate *appDelegate = (SwipeNoteAppDelegate *) [[UIApplication sharedApplication] delegate];
//    Note *note = (Note *) [appDelegate.notes objectAtIndex:indexPath.row];
    Note *note = [self.notes objectAtIndex:indexPath.row];
    if (self.detailController == nil){
        self.detailController = [[DetailViewController alloc] initWithNibName:@"DetailViewController" bundle:nil]; //bundle:[NSBundle mainBundle]];
    }
    [self.navigationController pushViewController:detailController animated:YES];
    self.detailController.title = [note title];
    self.detailController.noteTitle.text = [note title];
    self.detailController.noteContent.text   = [note content];
}


/*
 // Override to support conditional editing of the table view.
 - (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath
 {
 // Return NO if you do not want the specified item to be editable.
 return YES;
 }
 */

/*
 // Override to support editing the table view.
 - (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath
 {
 if (editingStyle == UITableViewCellEditingStyleDelete) {
 // Delete the row from the data source
 [tableView deleteRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationFade];
 }
 else if (editingStyle == UITableViewCellEditingStyleInsert) {
 // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
 }
 }
 */

/*
 // Override to support rearranging the table view.
 - (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath
 {
 }
 */

/*
 // Override to support conditional rearranging of the table view.
 - (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath
 {
 // Return NO if you do not want the item to be re-orderable.
 return YES;
 }
 */

/*
 #pragma mark - Navigation
 
 // In a story board-based application, you will often want to do a little preparation before navigation
 - (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
 {
 // Get the new view controller using [segue destinationViewController].
 // Pass the selected object to the new view controller.
 }
 
 */

@end
