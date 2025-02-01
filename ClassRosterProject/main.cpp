//
//  main.cpp
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

int main(int argc, const char * argv[]) {
    //Print out to the screen, via my application, the course title, the programming language used, my WGU student ID, and my name
    cout << "SCRIPTING AND PROGRAMMING - APPLICATIONS — C867" << endl;
    cout << "Language Used:  C++" << endl;
    cout << "Student ID:  011834711" << endl;
    cout << "Name:  Jonathan Stark" << endl;
   
    //declares an array for the input student data
    const string studentData[] =
    {"A1,John,Smith,John1989@gm ail.com,20,30,35,40,SECURITY", "A2,Suzan,Erickson,Erickson_1990@gmailcom,19,50,30,40,NETWORK", "A3,Jack,Napoli,The_lawyer99yahoo.com,19,20,40,33,SOFTWARE", "A4,Erin,Black,Erin.black@comcast.net,22,50,58,40,SECURITY", "A5,Jonathan,Stark,jsta586@wgu.edu,38,23,9,42,SOFTWARE"};
    cout << endl;
    
   //Create an instance of the Roster class called classRoster and add each student to classRoster
    Roster *classRoster = new Roster(studentData);
    cout << endl;
    
    //prints all information stored in the class roster
    classRoster->printAll();
    cout << endl;
    
    //prints all invalid student emails
    classRoster->printInvalidEmails();
    cout << endl;
    
    //loops through the elements of the classRosterArrsy and prints the averageDaysInCourse based on the studentID of each element
    for(int i = 0; i < classRoster->classRosterArraySize; i++){
        classRoster->printAverageDaysInCourse(classRoster->classRosterArray[i]->getStudentID());
    }
    cout << endl;
    
    //prints each student in the SOFTWARE degree program
    classRoster->printByDegreeProgram(SOFTWARE);
    cout << endl;
    
    //removes the student with studentID == "A3"
    classRoster->remove("A3");
    cout << endl;
    
    //prints all student data with student A3 removed
    classRoster->printAll();
    cout << endl;
    
    //attempts to remove the student with studentID == "A3" again, resulting in an error being thrown
    classRoster->remove("A3");
    cout << endl;
 
    //Implement the destructor to release the memory that was allocated dynamically in Roster.
    delete classRoster;
    
    return 0;
}
