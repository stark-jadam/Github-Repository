//
//  student.cpp
//  ClassRosterProject
//
//  Created by Adam Stark on 5/11/24.
//

#include "student.h"
#include "degree.h"
#include "roster.h"
#include <string>
#include <array>
#include <cstring>
#include <iostream>
using namespace std;



    
    //constructor
    
Student::Student(string studentIdentifier, string fName, string lName, string emailAddress, int a, int daysInCourse1, int daysInCourse2, int daysInCourse3, DegreeProgram dProgram)
    {
    
         setStudentID(studentIdentifier);
         setFirstName(fName);
         setLastName(lName);
         setEmail(emailAddress);
         setAge(a);
         setDaysInCourse(daysInCourse1, daysInCourse2, daysInCourse3);
         setDegreeProgram(dProgram);
         
    }
    
    
    
    
    //getter methods for instance variables
    
    string Student::getStudentID(){
        return studentID;
    }
    
    string Student::getFirstName(){
        return firstName;
    }
    
    string Student::getLastName(){
        return lastName;
    }
    
    string Student::getEmail(){
        return email;
    }
    
    int Student::getAge(){
        return age;
    }
    
    array<int, 3> Student::getDaysInCourse(){
        return daysInCourse;
    }
    
    DegreeProgram Student::getDegreeProgram(){
        return degreeProgram;
    }
    
    //setter methods for instance variables
    
    void Student::setStudentID(string id){
        studentID = id;
    }
    
    void Student::setFirstName(string fName){
        firstName = fName;
    }
    
    void Student::setLastName(string lName){
        lastName = lName;
    }
    
    void Student::setEmail(string e){
        email = e;
    }
    
    void Student::setAge(int a){
        age = a;
    }
    
    void Student::setDaysInCourse(int b, int c, int d){
        daysInCourse = {b, c, d};
    }
    
    void Student::setDegreeProgram(DegreeProgram degree){
        degreeProgram = degree;
    }
    
    //print method to print specific student data to the console
    
    void Student::print(){
        
        cout << getStudentID() << '\t';
        cout << "First Name:  " << getFirstName() << '\t';
        cout << "Last Name:  " << getLastName() << '\t';
        cout << "Age:  " << getAge() << '\t';
        cout << "daysInCourse:  {" << getDaysInCourse()[0] << ", " << getDaysInCourse()[1] << ", " << getDaysInCourse()[2] << "}  ";
        
        string degreeString;
        if(getDegreeProgram() == SECURITY){
            degreeString = "Security";
        };
        if(getDegreeProgram() == NETWORK){
            degreeString = "Network";
        };
        if(getDegreeProgram() == SOFTWARE){
            degreeString = "Software";
        };
        cout << "Degree Program:  " << degreeString << endl;
    }
    

