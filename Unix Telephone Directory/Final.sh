#!/bin/bash
trap "rm temp.txt; exit" 1 2 3
COLUMNS=0

if [[ "$1" = "" ]]; then 
	exit 2
fi

if [[ "$3" != "" ]]; then
	exit 2
fi 

if [[ "$2" = "" ]]; then
    echo "Searching by last name only may return multiple results"
fi

echo "Please specify a directory file"
read FILE

if [[ ! -f "$FILE" ]]; then
	echo "File does not exist"
	exit 2
fi

COLUMNS=$(awk -F' ' '{print NF; exit}' $FILE)
if [[ "$COLUMNS" -ne 3 ]]; then
	echo "File data is not configured properly"
	exit 2
fi

while :
do 
echo -e "Please choose an option \n A)  Add Entry \n D)  Delete Entry \n M)  Modify Entry \n I)  Display Entry \n P)  Display All Entries \n X)  Exit "

read n
case $n in
    A)  echo "Enter First Name:"
		read FIRST
	echo "Enter Last Name:"
		read LAST
	echo "Enter Phone Number:"
		read PHONE
	echo "$LAST $FIRST $PHONE" >>$FILE
	echo "Entry Successfully Added";;
    D)  echo "Enter First Name:"
		read FIRST
	echo "Enter Last Name:"
		read LAST
	egrep -vw "$LAST $FIRST" $FILE > temp.txt
	cp temp.txt $FILE
	echo "Entry Successfully Deleted";;
    M)  echo "Enter First Name:"
		read FIRST
	echo "Enter Last Name:"
		read LAST
	echo "Enter New First Name:"
		read NFIRST
	echo "Enter New Last Name:"
		read NLAST
	echo "Enter New Phone Number:"
		read NPHONE
	egrep -vw "$LAST $FIRST" $FILE > temp.txt
	cp temp.txt $FILE
	echo "$NLAST $NFIRST $NPHONE" >>$FILE
	echo "Entry Successfully Modified";;
    I)   echo "Enter First Name:"
		read FIRST
	echo "Enter Last Name:"
		read LAST
	egrep "$LAST $FIRST" $FILE;;
    P) cat $FILE;;
    X) exit;;
    *) echo "invalid option";;
esac
done