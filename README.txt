Solution is based on partial Quicksort algorithm.
Code is supplied with comments.

Project root folder: topvalues

Source code:
 main\java\com\exercise\FindTopValues
 main\java\com\exercise\FindTopValuesImpl

Junit test cases:
 test\java\com\exercise\FindTopValuesTest

API usage:
 Assign instance of FindTopValuesImpl to a variable of type FindTopValues. From the variable following functions can be called::
  int findMaxValue(int[] anyOldOrderValues); 
  int[] findTopNValues(int[] anyOldOrderValues, int n);

Build:
 In order to take fresh build and run Junit test cases following command needs to be executed from the topvalues folder:
 mvn package
 (For above it is expected maven installed and the computer is connected to the internet.)

Stand alone execution:
 In order to run the application use the following command from the TopValues folder: 
 java -cp .\target\topvalues-1.0-SNAPSHOT.jar test.FindTopValuesImpl


Execution through Eclipse IDE:
 1. Create a new java project and use TopValues folder as the project source folder
 2. Run FindTopValuesImpl class
   
