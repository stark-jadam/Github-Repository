//
//  roster.cpp
//  ClassRosterProject
//
//  Created by Adam Stark on 5/13/24.
//

#include "student.h"
#include "degree.h"
#include "roster.h"
#include <string>
#include <array>
#include <cstring>
#include <iostream>
using namespace std;



    Roster::~Roster(){
        
    }
    
    Roster::Roster(const string *studentData){
    
        string id;
        string fName;
        string lName;
        string emailAddress;
        int studentAge;
        int daysCourse1;
        int daysCourse2;
        int daysCourse3;
        DegreeProgram dProgram ;
        
        //parse the studentData input
        for(int i = 0; i < 5; i++){
            string studentDataEntry = studentData[i];
            char* stringToken = studentDataEntry.data();
            id = strtok(stringToken, ",");
            fName = strtok(NULL, ",'");
            lName = strtok(NULL, ",'");
            emailAddress = strtok(NULL, ",'");
            studentAge = stoi(strtok(NULL, ","));
            daysCourse1 = stoi(strtok(NULL, ","));
            daysCourse2 = stoi(strtok(NULL, ","));
            daysCourse3 = stoi(strtok(NULL, ","));
            string degreeString = strtok(NULL, ",'");
            
            //if statements to create proper DegreeProgram object
            if(degreeString == "SECURITY"){
                dProgram = SECURITY;
            };
            if(degreeString == "NETWORK"){
                dProgram = NETWORK;
            };
            if(degreeString == "SOFTWARE"){
                dProgram = SOFTWARE;
            };
            
            
            
            add(id, fName, lName, emailAddress, studentAge, daysCourse1, daysCourse2, daysCourse3, dProgram);
        }
    }
    

    
    //creates a student and adds them to the roster
    void Roster::add(string studentID, string firstName, string lastName, string emailAddress, int age, int daysInCourse1, int daysInCourse2, int daysInCourse3, DegreeProgram degreeProgram){
        
        classRosterArray[classRosterArraySize] = new Student(studentID, firstName, lastName, emailAddress, age, daysInCourse1, daysInCourse2, daysInCourse3, degreeProgram);
        
        classRosterArraySize++;
        
    }
    
    //removes a student from the roster based on studentID
    void Roster::remove(string studentID){
        
        //stores the original length of classRosterArraySize for later comparison
        int arrayStartSize = classRosterArraySize;
        
        //loop through the classRosterArray to find the matching studentID and update the array to remove the element
        for (int i = 0; i < classRosterArraySize; i++){
            if(classRosterArray[i]->getStudentID() == studentID){
                for(int j = i; j < classRosterArraySize-1; j++){
                    classRosterArray[j] = classRosterArray[j+1];
                }
                classRosterArraySize--;
            }
        }
        
        
        //prints an error message if the original classRosterArraySize equals the ending clsssRosterArraySize
        if(arrayStartSize == classRosterArraySize){
            cerr << "The following Student ID was not found:  " << studentID << endl;
        }
        
    }
    
    //prints all the students information in the classRosterArrsy
    void Roster::printAll(){
        cout << "All Students:" << endl << endl;
        for(int i = 0; i < classRosterArraySize; i++){
            classRosterArray[i]->print();
        }
        
    }
    //prints the average days in 3 courses
    void Roster::printAverageDaysInCourse(string studentID){
        
        int averageDays;
        for(int i = 0; i < classRosterArraySize; i++){
            if(classRosterArray[i]->getStudentID() == studentID){
                array<int,3> daysInCourse = classRosterArray[i]->getDaysInCourse();
                averageDays = ((daysInCourse[0] + daysInCourse[1] + daysInCourse[2])/3);
                cout << "Average Days in Course for Student " << classRosterArray[i]->getStudentID() << ":  " << averageDays << endl;
            }
        }
        
    }

    //prints all invalid email addresses
    void Roster::printInvalidEmails(){
        
        cout << "Invalid Emails:" << endl << endl;
        string email;
        for(int i = 0; i < classRosterArraySize; i++){
            email = classRosterArray[i]->getEmail();
            if (email.find('@') == string::npos || email.find('.') == string::npos ||
                email.find(' ') != string::npos){
                  
                cout << email << endl;
            }
        }
        
    }
    
    //prints all student information in a particular degree program
    void Roster::printByDegreeProgram(DegreeProgram degreeProgram){
        
        cout << "Students in Degree Program:" << endl << endl;
        for(int i = 0; i < classRosterArraySize; i++){
            if(classRosterArray[i]->getDegreeProgram() == degreeProgram){
                classRosterArray[i]->print();
            }
        }
        
    }
    

    

