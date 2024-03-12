PART 1 <br>

1. Student: I'm a little confused with what is happening with my code when I run my ListExamples file using grade.sh as I keep getting a "test timed out after 500 milliseconds" error. I think this is because of something in my code that is taking too long to run but I'm not sure where to look. <br>
<img width="871" alt="Screen Shot 2024-03-12 at 09 41 11" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/b79c7ca0-16cd-4250-a6a7-e4621445585c"> <br>

2. TA: Thanks for bringing this up! Something that may help when trying to understand where the code went wrong is that if we look at the lines under "test timed out after 500 milliseconds" we can see at what line and which file that there was an error. For this bug we can see "ListExamples.java:43" which means that we should probably take a look at line 43 in `ListExamples.java`. There may be something in this line that is not functioning properly as you thought so make sure to check what variables you may be updating/changing. Something else to note is that when we see a "test timed out" error there may be some kind of infinite loop you should check for. This means maybe you did not update a variable properly which could lead to this symptom.

3. Student: Thank you for your reply! I see now that in my while loop on line 43, I was updating `index1 += 1` instead of `index2 += 1`. This would cause an infinite loop because in my while loop check, I am checking `while(index2 < list2.size())` but I wasn't updating `index2` so `index2` will always be less than `list2.size()` which means the while loop will run forever. But when making sure that `index2` is being updated to `index2 += 1`, then `index2` will eventually be greater than `list2.size()` thus the while loop will stop and properly add the indices from `index2` in `list2` to `result`. <br>
<img width="431" alt="Screen Shot 2024-03-12 at 10 08 59" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/84bd1f52-6679-4015-ac28-5934c7e4c4d2"> <br>

4. Setup:
   The directory structure within the `/home/list-examples-grader/` directory:
   - grading-area/
     - lib/
       - hamcrest-core-1.3.jar
       - junit-4.13.2.jar
     - IsMoon.class
     - junit-output.txt
     - ListExamples.class
     - ListExamples.java
     - StringChecker.class
     - TestListExamples.class
     - TestListExamples.java
   - lib/
     - hamcrest-core-1.3.jar
     - junit-4.13.2.jar
   - student-submission/
     - ListExamples.java
   - grade.sh
   - GradeServer.java
   - Server.java
   - TestListExamples.java

    `grade.sh`:
    ```
    CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'
    
    rm -rf student-submission
    rm -rf grading-area
    
    mkdir grading-area
    
    git clone $1 student-submission
    echo 'Finished cloning'
    
    # Draw a picture/take notes on the directory structure that's set up after
    # getting to this point
    
    # Then, add here code to compile and run, and do any post-processing of the
    # tests
    
    if [ -f student-submission/ListExamples.java ]
    then
        cp student-submission/ListExamples.java TestListExamples.java grading-area/
        # echo "Missing ListExamples.java"
        # exit
    else 
        echo "Missing student/ListExamples.java, did you misname the file or forget to include it?"
        exit 1
    fi
    
    cp -r lib grading-area
    
    cd grading-area
    
    javac -cp $CPATH *.java 
    
    if [ $? -ne 0 ]
    then 
        echo "The program failed to compile, see complie errors above"
        exit 1
    fi
    
    java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > junit-output.txt
    
    cat junit-output.txt
    ```
    
    `ListExamples.java`:
    ```
    import java.util.ArrayList;
    import java.util.List;
    
    interface StringChecker { boolean checkString(String s); }
    
    class ListExamples {
    
      // Returns a new list that has all the elements of the input list for which
      // the StringChecker returns true, and not the elements that return false, in
      // the same order they appeared in the input list;
      static List<String> filter(List<String> list, StringChecker sc) {
        List<String> result = new ArrayList<>();
        for(String s: list) {
          if(sc.checkString(s)) {
            result.add(0, s);
          }
        }
        return result;
      }
    
    
      // Takes two sorted list of strings (so "a" appears before "b" and so on),
      // and return a new list that has all the strings in both list in sorted order.
      static List<String> merge(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        int index1 = 0, index2 = 0;
        while(index1 < list1.size() && index2 < list2.size()) {
          if(list1.get(index1).compareTo(list2.get(index2)) < 0) {
            result.add(list1.get(index1));
            index1 += 1;
          }
          else {
            result.add(list2.get(index2));
            index2 += 1;
          }
        }
        while(index1 < list1.size()) {
          result.add(list1.get(index1));
          index1 += 1;
        }
        while(index2 < list2.size()) {
          result.add(list2.get(index2));
          index1 += 1;
        }
        return result;
      }
    
    
    }
    ```
Full command line: `bash grade.sh https://github.com/ucsd-cse15l-f22/list-methods-lab3` <br>

To fix this bug we need to go to line 43 in `ListExamples.java` and change `index1 += 1` to `index2 += 1` since updating `index1` will cause an infinite loop because this while loop is checking for `index2 < list2.size()`, not `index1 < list1.size()`

PART 2 <br>

Something that I learned the second half of this quarter was doing everything from terminal. I thought it was cool that we could do so much in terminal which is something I didn't know from before. It was cool that we could edit files in vim and then push that change back to main like on github and then we would be able to see those changes as well. Another thing was how we used jdb and how we could stop at a certain line to see what was happening at that point. It was cool seeing how we could use this to debug and figure our certain things about how our code runs.
