//
//  roster.hpp
//  ClassRosterProject
//
//  Created by Adam Stark on 5/13/24.
//

#ifndef roster_h
#define roster_h



#include "degree.h"
#include <string>
#include <array>
#include <cstring>
#include <iostream>
using namespace std;

class Roster {


public:
    
    //instance variables
    int classRosterArraySize = 0;
    Student *classRosterArray[];

    

    //destructor
    ~Roster();
    //constructor
    Roster(const string *studentData);
    

    
    //creates a student and adds them to the roster
    void add(string studentID, string firstName, string lastName, string emailAddress, int age, int daysInCourse1, int daysInCourse2, int daysInCourse3, DegreeProgram degreeProgram);
    
    //removes a student from the roster based on
    void remove(string studentID);
    
    //prints all the students information in the classRosterArrsy
    void printAll();
    
    //prints the average number of days in the 3 courses
    void printAverageDaysInCourse(string studentID);

    //prints all invalid emails
    void printInvalidEmails();
    
    //prints student data for a particular degree program
    void printByDegreeProgram(DegreeProgram degreeProgram);
    
    
};

#endif /* roster_h */
