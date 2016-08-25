##### PatternCounter

###### Problem Statement:
###### Write a program (source and unit tests) "PatternCounter" that reads an input document from a file (path provided as first command line argument) and calculates the number of occurrences of one of the 3 patterns based on the second command line argument:
###### 1: Counts occurrences of each unique word in the document
###### 2: Counts occurrences of each unique number in the document
###### 3: Counts occurrences of each unique phrase of three consecutive words in the document
 
###### It then prints each word, number or phrase and its count on standard output separated by a comma in a new line. For the purpose of this exercise, use space character as the de-limiter for words. String matching should be case sensitive. Here are some examples of output with a sample input file using different arguments: 
###### Contents of Input document (Input.txt): "1000 a big surprise 2000 hello is a big surprise 1000" 
PatternCounter Input.txt 1
a, 2
big, 2
surprise, 2
hello, 1
is, 1 
PatternCounter Input.txt 2
1000, 2
2000, 1 
PatternCounter Input.txt 3
1000 a big, 1
a big surprise, 2
big surprise 2000, 1
surprise 2000 hello, 1
2000 hello is, 1
hello is a, 1
is a big, 1
big surprise 1000, 1 
The output could be empty if there are less than 3 words in the document.

###### Tools/Technologies Used:
###### Java (version 8) – All the code is written Using Java
###### Maven (version 3.1) – Used Maven to manage build dependencies. All the dependencies are inside pom.xml file
###### Spring Using Annotations (version 4.3.1) – Used for Dependency Injection and Loose Coupling
###### Junit (version 4.12), Mockito (version 1.10.19) Testing Framework – For testing purposes
 
###### Build Instructions (Not Needed for JAR FileExecution):
###### mvn clean compile assembly:single
####### mvn package

###### Execution Instructions:

1. Clone the repository
2. Goto folder where JAR File is present Using following command:
cd <LocationWhereJARFileIsPresent>
2. Run the following command:
java -cp PatternCounter-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.dnyanshree.PatternCounter.PatternCounter Input 1

###### Available text files inside JAR:
######                      1.       Input.txt
######                      2.       MultipleLines.txt
######                      3.       InputNoPhrases.txt 
######                      
###### Design Pattern:

###### I used MVC (Model-View-Controller) pattern to make this project, focusing on segregation of classes based on what they are doing. All the classes are maintained in different packages.
Firstly, I created CountService.java Interface which define the required 3 methods to be implemented for PatternCounter Project. CountServiceImpl.java is a class that implements the methods defined in CountService.java interface.
Next, Display.java class is responsible for all the methods concerning displaying the output. This comes under view part of the MVC pattern.
Data from text file is manipulated inside InputData.java file that comes under model part of MVC. Here there was no need on putting any data into database so I used List and HashMap data structures for the most part.
CountController.java is responsible for handling the flow of the project, it calls necessary methods/classes. It is the controller part of MVC pattern.

###### Source code contains all Java and Test(JUnit) files.
