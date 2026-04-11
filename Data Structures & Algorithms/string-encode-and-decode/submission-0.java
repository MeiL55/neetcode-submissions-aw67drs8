class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s: strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0; //pointer for each character
        while (i < str.length()) {
            int j = i;//pointer for each length
            while (str.charAt(j) != '#') {
                j++;
            }
            //j reaches to #
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1; //i reaches to the string
            j = i + length; //
            res.add(str.substring(i, j));//add the actual string to list
            i = j; //proceed to the next string
        }
        return res;
    }
}
