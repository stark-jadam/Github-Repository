//
//  student.h
//  ClassRosterProject
//
//  Created by Adam Stark on 5/11/24.
//

#ifndef student_h
#define student_h
#include "degree.h"
#include <string>
#include <array>
#include <cstring>
#include <iostream>
using namespace std;

class Student {
    
    
    string studentID;
    string firstName;
    string lastName;
    string email;
    int age;
    array<int, 3> daysInCourse;
    DegreeProgram degreeProgram;
    
public:
    //constructor
    
    Student(string studentIdentifier, string fName, string lName, string emailAddress, int a, int daysInCourse1, int daysInCourse2, int daysInCourse3, DegreeProgram dProgram);
    
    
    
    
    //getter methods for instance variables
    
    string getStudentID();
    
    string getFirstName();
    
    string getLastName();
    
    string getEmail();
    
    int getAge();
    
    array<int, 3> getDaysInCourse();
    
    DegreeProgram getDegreeProgram();
    
    //setter methods for instance variables
    
    void setStudentID(string id);
    
    void setFirstName(string fName);
    
    void setLastName(string lName);
    
    void setEmail(string e);
    
    void setAge(int a);
    
    void setDaysInCourse(int b, int c, int d);
    
    void setDegreeProgram(DegreeProgram degree);
    
    //print method to print specific student data to the console
    
    void print();
    
};

#endif /* student_h */

