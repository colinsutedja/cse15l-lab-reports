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
      newArray[i] = arr[arr.length - i - 1];
    }
    return newArray;
  }

@Test
  public void testReversedSize3() {
    int[] input1 = {1, 2, 3};
    assertArrayEquals(new int[]{3, 2, 1}, ArrayExamples.reversed(input1));
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
(base) colin@Colins-MacBook-Pro docsearch % grep -i  "Cabin" technical/911report/chapter-1.txt     
    While Atta had been selected by CAPPS in Portland, three members of his hijacking team-Suqami, Wail al Shehri, and Waleed al Shehri-were selected in Boston. Their selection affected only the handling of their checked bags, not their screening at the checkpoint. All five men cleared the checkpoint and made their way to the gate for American 11. Atta, Omari, and Suqami took their seats in business class (seats 8D, 8G, and 10B, respectively). The Shehri brothers had adjacent seats in row 2 (Wail in 2A, Waleed in 2B), in the firstclass cabin. They boarded American 11 between 7:31 and 7:40. The aircraft pushed back from the gate at 7:40.
    At 7:50, Majed Moqed and Khalid al Mihdhar boarded the flight and were seated in 12A and 12B in coach. Hani Hanjour, assigned to seat 1B (first class), soon followed. The Hazmi brothers, sitting in 5E and 5F, joined Hanjour in the first-class cabin.
    The four men boarded the plane between 7:39 and 7:48. All four had seats in the first-class cabin; their plane had no business-class section. Jarrah was in seat 1B, closest to the cockpit; Nami was in 3C, Ghamdi in 3D, and Haznawi in 6B.
    They were planning to hijack these planes and turn them into large guided missiles, loaded with up to 11,400 gallons of jet fuel. By 8:00 A.M. on the morning of Tuesday, September 11,2001, they had defeated all the security layers that America's civil aviation security system then had in place to prevent a hijacking. The Hijacking of American 11 American Airlines Flight 11 provided nonstop service from Boston to Los Angeles. On September 11, Captain John Ogonowski and First Officer Thomas McGuinness piloted the Boeing 767. It carried its full capacity of nine flight attendants. Eighty-one passengers boarded the flight with them (including the five terrorists).22 The plane took off at 7:59. Just before 8:14, it had climbed to 26,000 feet, not quite its initial assigned cruising altitude of 29,000 feet. All communications and flight profile data were normal. About this time the "Fasten Seatbelt" sign would usually have been turned off and the flight attendants would have begun preparing for cabin service.
    Reports from two flight attendants in the coach cabin, Betty Ong and Madeline "Amy" Sweeney, tell us most of what we know about how the hijacking happened. As it began, some of the hijackers-most likely Wail al Shehri and Waleed al Shehri, who were seated in row 2 in first class-stabbed the two unarmed flight attendants who would have been preparing for cabin service.
    The hijackers quickly gained control and sprayed Mace, pepper spray, or some other irritant in the first-class cabin, in order to force the passengers and flight attendants toward the rear of the plane. They claimed they had a bomb.
    Boston Center knew of a problem on the flight in part because just before 8:25 the hijackers had attempted to communicate with the passengers. The microphone was keyed, and immediately one of the hijackers said, "Nobody move. Everything will be okay. If you try to make any moves, you'll endanger yourself and the airplane. Just stay quiet." Air traffic controllers heard the transmission; Ong did not. The hijackers probably did not know how to operate the cockpit radio communication system correctly, and thus inadvertently broadcast their message over the air traffic control channel instead of the cabin public-address channel. Also at 8:25, and again at 8:29, Amy Sweeney got through to the American Flight Services Office in Boston but was cut off after she reported someone was hurt aboard the flight. Three minutes later, Sweeney was reconnected to the office and began relaying updates to the manager, Michael Woodward.
    United 175 pushed back from its gate at 7:58 and departed Logan Airport at 8:14. By 8:33, it had reached its assigned cruising altitude of 31,000 feet. The flight attendants would have begun their cabin service.
    The hijackers attacked sometime between 8:42 and 8:46. They used knives (as reported by two passengers and a flight attendant), Mace (reported by one passenger), and the threat of a bomb (reported by the same passenger). They stabbed members of the flight crew (reported by a flight attendant and one passenger). Both pilots had been killed (reported by one flight attendant). The eyewitness accounts came from calls made from the rear of the plane, from passengers originally seated further forward in the cabin, a sign that passengers and perhaps crew had been moved to the back of the aircraft. Given similarities to American 11 in hijacker seating and in eyewitness reports of tactics and weapons, as well as the contact between the presumed team leaders, Atta and Shehhi, we believe the tactics were similar on both flights.
    American 77 pushed back from its gate at 8:09 and took off at 8:20. At 8:46, the flight reached its assigned cruising altitude of 35,000 feet. Cabin service would have begun. At 8:51, American 77 transmitted its last routine radio communication. The hijacking began between 8:51 and 8:54. As on American 11 and United 175, the hijackers used knives (reported by one passenger) and moved all the passengers (and possibly crew) to the rear of the aircraft (reported by one flight attendant and one passenger). Unlike the earlier flights, the Flight 77 hijackers were reported by a passenger to have box cutters. Finally, a passenger reported that an announcement had been made by the "pilot" that the plane had been hijacked. Neither of the firsthand accounts mentioned any stabbings or the threat or use of either a bomb or Mace, though both witnesses began the flight in the first-class cabin.
    Callers reported that a passenger had been stabbed and that two people were lying on the floor of the cabin, injured or dead-possibly the captain and first officer. One caller reported that a flight attendant had been killed.

```
The command `-i` is for ignoring case sensitive words so when we put in the key `Among` or `Cabin` since we have `-i` option it will ignore the upper case A and C and also look for both Among and among and Cabin and cabin. This is useful if we want to check for all instances for a certain key without worrying about case sensitivity. <br>


```
(base) colin@Colins-MacBook-Pro docsearch % grep -o  "Plane" technical/911report/chapter-1.txt
Plane
(base) colin@Colins-MacBook-Pro docsearch % grep -o  "food" technical/911report/chapter-1.txt
(base) colin@Colins-MacBook-Pro docsearch % 
```
The command `-o` is for printing only the matched parts of a matching line. So when we use it here we can see the key value being printed if it is matched in a line in the .txt. This is useful for if we need to check if a key value is in a file we are looking through and check what it prints. In the second example we can see that `food` was not matched in the file which is why it did not get printed unlike `Plane` because `Plane` was matched in the file. <br>

```
(base) colin@Colins-MacBook-Pro docsearch % grep -c  "plane" technical/911report/chapter-1.txt
71
(base) colin@Colins-MacBook-Pro docsearch % grep -c "passenger" technical/911report/chapter-1.txt    
40
```
The command `-c` is for printing the count of matching lines in the file. This is a similar function to if we did the command `grep "plane" technical/911report/chapter-1.txt | wc -l` which also prints out the number of matching lines in the file. This is useful if we want to see how many lines match our key value instead of having to do `| wc -l` which is less things to type. <br>

```
(base) colin@Colins-MacBook-Pro docsearch % grep -n "among" technical/911report/chapter-1.txt
200:    The cockpit voice recorder captured the sounds of the passenger assault muffled by the intervening cockpit door. Some family members who listened to the recording report that they can hear the voice of a loved one among the din. We cannot identify whose voices can be heard. But the assault was sustained.
(base) colin@Colins-MacBook-Pro docsearch % grep -n "Among" technical/911report/chapter-1.txt
8:    For those heading to an airport, weather conditions could not have been better for a safe and pleasant journey. Among the travelers were Mohamed Atta and Abdul Aziz al Omari, who arrived at the airport in Portland, Maine.
640:    Among the sources that reflect other important events of that morning, there is no documentary evidence for this call, but the relevant sources are incomplete. Others nearby who were taking notes, such as the Vice President's chief of staff, Scooter Libby, who sat next to him, and Mrs. Cheney, did not note a call between the President and Vice President immediately after the Vice President entered the conference room.
```
The command `-n` is for printing out the line number of where the match was found along with the actual line in the file. This is useful to scroll through the file and know exactly where each match happens and at which line in the file. It would make scrolling through the file faster as you can go straight to the line. <br>
