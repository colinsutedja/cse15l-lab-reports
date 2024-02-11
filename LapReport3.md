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
<img width="962" alt="Screen Shot 2024-02-11 at 15 03 22" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/0854c0de-e7a1-48bf-88c2-e52ceccb6f47">
