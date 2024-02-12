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
