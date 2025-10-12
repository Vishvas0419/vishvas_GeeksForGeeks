class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int firstNegIndex = -1; // stores index of first negative number in window

        while (j < arr.length) {
            // if current element is negative and we don't have one yet, set it
            if (arr[j] < 0 && firstNegIndex == -1) {
                firstNegIndex = j;
            }
            if (j - i + 1 < k) j++;
            else if (j - i + 1 == k) {
                // if we have a valid negative index inside window
                if (firstNegIndex >= i && firstNegIndex <= j) {
                    result.add(arr[firstNegIndex]);
                } else {
                    result.add(0);
                }
                // before sliding the window, check if we’re removing the current first negative
                if (firstNegIndex == i) {
                    firstNegIndex = -1; // reset it
                    // find next negative index (only move forward, no backward scan)
                    for (int x = i + 1; x <= j; x++) {
                        if (arr[x] < 0) {
                            firstNegIndex = x;
                            break;
                        }
                    }
                }
                i++;j++;
            }
        }
        return result;
    }
}
