PART 1 <br>

Failure-inducing input: <br>
```
static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArray[arr.length - i - 1];
    }
    return arr;
  }

@Test
  public void testReversedSize3() {
    int[] input1 = {1, 2, 3};
    assertArrayEquals(new int[]{3, 2, 1}, ArrayExamples.reversed(input1));
  }
```

Input that doesn't induce a failure: <br>
```
static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArray[arr.length - i - 1];
    }
    return arr;
  }

@Test
  public void testReversedAllZeros() {
    int[] input1 = {0, 0, 0};
    assertArrayEquals(new int[]{0, 0, 0}, ArrayExamples.reversed(input1));
  }
```

Symptom: <br>
<img width="962" alt="Screen Shot 2024-02-11 at 15 03 22" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/0854c0de-e7a1-48bf-88c2-e52ceccb6f47"> <br>

<img width="961" alt="Screen Shot 2024-02-11 at 15 09 54" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/3352eddb-76d4-4222-9d66-80f634eb4f02"> <br>

Bug: <br>
```
static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArray[arr.length - i - 1];
    }
    return arr;
  }

static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      newArray[i] = arr[arr.length - i - 1];
    }
    return newArray;
  }
```

This fix in the second code block fixed the bug because the first block was assigning the array passed in `arr` with the values of `newArray` reversed which is the same length as `arr` but filled with all zeros. So when we are reversing the array, we are just reversing the array of all zeros, `newArray` which is where our bug comes from. But in the second code block, we change the array we are reversing through which is `arr` passed in. We then assign the values of `arr` starting from the end of the array and iterating towards the start and put those values into `newArray` which then correctly gives us the reverse order of values from `arr`

PART 2

```
(base) colin@Colins-MacBook-Pro docsearch % grep -i  "Among" technical/911report/chapter-1.txt        
    For those heading to an airport, weather conditions could not have been better for a safe and pleasant journey. Among the travelers were Mohamed Atta and Abdul Aziz al Omari, who arrived at the airport in Portland, Maine.
    The cockpit voice recorder captured the sounds of the passenger assault muffled by the intervening cockpit door. Some family members who listened to the recording report that they can hear the voice of a loved one among the din. We cannot identify whose voices can be heard. But the assault was sustained.
    Among the sources that reflect other important events of that morning, there is no documentary evidence for this call, but the relevant sources are incomplete. Others nearby who were taking notes, such as the Vice President's chief of staff, Scooter Libby, who sat next to him, and Mrs. Cheney, did not note a call between the President and Vice President immediately after the Vice President entered the conference room.
(base) colin@Colins-MacBook-Pro docsearch % grep -i  "Inside" technical/911report/chapter-1.txt
INSIDE THE FOUR FLIGHTS
    Because several passengers on United 93 described three hijackers on the plane, not four, some have wondered whether one of the hijackers had been able to use the cockpit jump seat from the outset of the flight. FAA rules allow use of this seat by documented and approved individuals, usually air carrier or FAA personnel. We have found no evidence indicating that one of the hijackers, or anyone else, sat there on this flight. All the hijackers had assigned seats in first class, and they seem to have used them. We believe it is more likely that Jarrah, the crucial pilot-trained member of their team, remained seated and inconspicuous until after the cockpit was seized; and once inside, he would not have been visible to the passengers.
    Inside the National Military Command Center, the deputy director of operations and his assistant began notifying senior Pentagon officials of the incident. At about 9:00, the senior NMCC operations officer reached out to the FAA operations center for information. Although the NMCC was advised of the hijacking of American 11, the scrambling of jets was not discussed.
The Pentagon Teleconferences. Inside the National Military Command Center, the deputy director for operations immediately thought the second strike was a terrorist attack. The job of the NMCC in such an emergency is to gather the relevant parties and establish the chain of command between the National Command Authority-the president and the secretary of defense- and those who need to carry out their orders.
    Inside the NMCC, the deputy director for operations called for an allpurpose "significant event" conference. It began at 9:29, with a brief recap: two aircraft had struck the World Trade Center, there was a confirmed hijacking of American 11, and Otis fighters had been scrambled. The FAA was asked to provide an update, but the line was silent because the FAA had not been added to the call. A minute later, the deputy director stated that it had just been confirmed that American 11 was still airborne and heading toward D.C. He directed the transition to an air threat conference call. NORAD confirmed that American 11 was airborne and heading toward Washington, relaying the erroneous FAA information already mentioned. The call then ended, at about 9:34.
    Once inside, Vice President Cheney and the agents paused in an area of the tunnel that had a secure phone, a bench, and television. The Vice President asked to speak to the President, but it took time for the call to be connected. He learned in the tunnel that the Pentagon had been hit, and he saw television coverage of smoke coming from the building.
```
The option `-i` is for ignoring case sensitive words so when we put in the key `Among` or `Inside` since we have `-i` option it will ignore the cases of whether it's upper case or lower case. This is useful if we want to check for all instances for a certain key without worrying about case sensitivity. We see when we have the key `Inside`, that `INSIDE` and `inside` were also included which wouldn't be if we didn't have `-i` <br>

```
(base) colin@Colins-MacBook-Pro docsearch % grep -o  "Plane" technical/911report/chapter-1.txt
Plane
(base) colin@Colins-MacBook-Pro docsearch % grep -o  "food" technical/911report/chapter-1.txt
(base) colin@Colins-MacBook-Pro docsearch % 
```
The option `-o` is for printing only the matched parts of a matching line. So when we use it here we can see the key value being printed if it is matched in a line in the file. This is useful for if we need to check if a key value is in a file we are looking through and check what it prints. In the second example we can see that `food` was not matched in the file which is why it did not get printed unlike `Plane` because `Plane` was matched in the file. <br>

```
(base) colin@Colins-MacBook-Pro docsearch % grep -c  "plane" technical/911report/chapter-1.txt
71
(base) colin@Colins-MacBook-Pro docsearch % grep -c "passenger" technical/911report/chapter-1.txt    
40
```
The option `-c` is for printing the count of matching lines in the file. This is a similar function to if we do the command `grep "plane" technical/911report/chapter-1.txt | wc -l` which also prints out the number of matching lines in the file. This is useful if we want to see how many lines match our key value instead of having to do `| wc -l` which is less things to type. <br>

```
(base) colin@Colins-MacBook-Pro docsearch % grep -n "among" technical/911report/chapter-1.txt
200:    The cockpit voice recorder captured the sounds of the passenger assault muffled by the intervening cockpit door. Some family members who listened to the recording report that they can hear the voice of a loved one among the din. We cannot identify whose voices can be heard. But the assault was sustained.
(base) colin@Colins-MacBook-Pro docsearch % grep -n "Among" technical/911report/chapter-1.txt
8:    For those heading to an airport, weather conditions could not have been better for a safe and pleasant journey. Among the travelers were Mohamed Atta and Abdul Aziz al Omari, who arrived at the airport in Portland, Maine.
640:    Among the sources that reflect other important events of that morning, there is no documentary evidence for this call, but the relevant sources are incomplete. Others nearby who were taking notes, such as the Vice President's chief of staff, Scooter Libby, who sat next to him, and Mrs. Cheney, did not note a call between the President and Vice President immediately after the Vice President entered the conference room.
```
The option `-n` is for printing out the line number of where the match was found along with the actual line in the file. This is useful to scroll through the file and know exactly where each match happens and at which line in the file. It would make scrolling through the file faster as you can go straight to the line of where the match is. <br>

Source: https://man7.org/linux/man-pages/man1/grep.1.html
