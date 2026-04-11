class Solution {
    public int[] countBits(int n) {
        int[] output = new int[n+1];
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count = 0;
            int num = i;
            while (num > 0) { //INFINITE LOOP HERE
                if ((num & 1) == 1) {
                    count++;
                }
                num /= 2; //EQUAL TO >> 1
            }
            output[i] = count;
        }
        return output;
    }
}
