Code is based on partial Quicksort algorithm. Code is supplied with comments.

Junit test case contains 2 test functions to test top value and top n values.

Extracting topvalues.zip will give project root folder: topvalues 

Source code:
 topvalues\main\java\com\exercise\FindTopValues
 topvalues\main\java\com\exercise\FindTopValuesImpl

Junit test cases:
 topvalues\test\java\com\exercise\FindTopValuesTest

API usage:
 Assign instance of FindTopValuesImpl to a variable of type FindTopValues. From the variable following functions can be called:
  int findMaxValue(int[] anyOldOrderValues); 
  int[] findTopNValues(int[] anyOldOrderValues, int n);

Build:
 In order to take fresh build and run Junit test cases following command needs to be executed from the topvalues folder:
 mvn package
 (For above it is expected maven installed and the computer is connected to the internet.)
