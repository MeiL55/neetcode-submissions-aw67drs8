class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int ithbit = (n >> i) & 1;
            System.out.println(i + "," + ithbit);
            res |=  (ithbit << (31 - i));
        }
        return res;
    }
}
