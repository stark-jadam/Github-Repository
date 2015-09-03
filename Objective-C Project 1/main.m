//
//  main.m
//  Jonathanstarkp1
//
//  Created by Jonathan Stark on 10/28/14.
//  Copyright (c) 2014 Jonathan Stark. All rights reserved.
//

#import <Foundation/Foundation.h>

//defines a class, SimpleCalc, that inherits the NSObject class
@interface SimpleCalc : NSObject
//declares instance variables for 2 numbers
{
    int numberA;
    int numberB;
}

//defines methods for SimpleCalc class.
-(void) setA:(int *)A;  //defines method to set integer A
-(void) setB:(int *)B;  //defines method to set integer B
-(int) getA;   //defines method to get(return) integer A
-(int) getB;   //defines method to get(return) integer B
-(void) sum;   //defines method to print the sum of integers A and B
-(void) subtraction;   //defines method to print the difference between integers A and B

@end

//implements SimpleCalc class
@implementation SimpleCalc

//method to set integer A
-(void) setA:(int *)A
{
    numberA = *A;
}

//method to set integer B
-(void) setB:(int *)B
{
    numberB = *B;
}

//method to get(return) integer A
-(int) getA
{
    return numberA;
}

//method to get(return) integer B
-(int) getB
{
    return numberB;
}

//method to print the sum of integers A and B
-(void) sum
{
    NSLog(@"Sum: %i", numberA+numberB);
}

//method to print the difference between integers A and B
-(void) subtraction
    {
        NSLog(@"Subtraction: %i", numberA-numberB);
    }


@end

//main method of SimpleCalc class
int main(int argc, const char * argv[]) {
    @autoreleasepool {
        
        //test case 1
        int A = 15;  //creates integer variables
        int B = 5;
        SimpleCalc *test1 = [[SimpleCalc alloc] init];  //creates new SimpleCalc object
        [test1 setA:&A];  //sets integer A
        [test1 setB:&B];  //sets integer B
        NSLog(@"Integer A is currently set to: %i", [test1 getA]);  //gets integer A and prints it
        NSLog(@"Integer B is currently set to: %i", [test1 getB]);  //gets integer B and prints it
        [test1 sum];  //calls the sum method to print the sum of integers A and B
        [test1 subtraction];  //calls the subtraction method to print the difference between integers A and B
        
        //test case 2
        A = 2;  //creates integer variables
        B = 12;
        SimpleCalc *test2 = [[SimpleCalc alloc] init];  //creates new SimpleCalc object
        [test2 setA:&A];  //sets integer A
        [test2 setB:&B];  //sets integer B
        NSLog(@"Integer A is currently set to: %i", [test2 getA]);  //gets integer A and prints it
        NSLog(@"Integer B is currently set to: %i", [test2 getB]);  //gets integer B and prints it
        [test2 sum];  //calls the sum method to print the sum of integers A and B
        [test2 subtraction];  //calls the subtraction method to print the difference between integers A and B
        
        //test case 3
        A = 12;  //creates integer variables
        B = 15;
        SimpleCalc *test3 = [[SimpleCalc alloc] init];  //creates new SimpleCalc object
        [test3 setA:&A];  //sets integer A
        [test3 setB:&B];  //sets integer B
        NSLog(@"Integer A is currently set to: %i", [test3 getA]);  //gets integer A and prints it
        NSLog(@"Integer B is currently set to: %i", [test3 getB]);  //gets integer B and prints it
        [test3 sum];  //calls the sum method to print the sum of integers A and B
        [test3 subtraction];  //calls the subtraction method to print the difference between integers A and B
        
        //test case 4
        A = 4;  //creates integer variables
        B = 1;
        SimpleCalc *test4 = [[SimpleCalc alloc] init];  //creates new SimpleCalc object
        [test4 setA:&A];  //sets integer A
        [test4 setB:&B];  //sets integer B
        NSLog(@"Integer A is currently set to: %i", [test4 getA]);  //gets integer A and prints it
        NSLog(@"Integer B is currently set to: %i", [test4 getB]);  //gets integer B and prints it
        [test4 sum];  //calls the sum method to print the sum of integers A and B
        [test4 subtraction];  //calls the subtraction method to print the difference between integers A and B
        
        //test case 5
        A = 6;  //creates integer variables
        B = 0;
        SimpleCalc *test5 = [[SimpleCalc alloc] init];  //creates new SimpleCalc object
        [test5 setA:&A];  //sets integer A
        [test5 setB:&B];  //sets integer B
        NSLog(@"Integer A is currently set to: %i", [test5 getA]);  //gets integer A and prints it
        NSLog(@"Integer B is currently set to: %i", [test5 getB]);  //gets integer B and prints it
        [test5 sum];  //calls the sum method to print the sum of integers A and B
        [test5 subtraction];  //calls the subtraction method to print the difference between integers A and B
        
        CGFloat C;
        C = (CGFloat) A;
        
        
    }
    return 0;
}
