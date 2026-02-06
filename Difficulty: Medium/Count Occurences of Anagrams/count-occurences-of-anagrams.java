// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        int[]PatFreq = new int[26];
        int[]textFreq = new int[26];
        int count = 0;
        int k = pat.length();
        for(int i=0;i<pat.length();i++)
        {
            char ch = pat.charAt(i);
            PatFreq[ch-'a']++;
        }
        for(int i=0;i<k;i++)
        {
            char ch = txt.charAt(i);
            textFreq[ch-'a']++;
        }
        if(Arrays.equals(PatFreq,textFreq))
        {
            count++;
        }
        for(int i=1;i<=txt.length()-k;i++)
        {
            char prevChar = txt.charAt(i-1);
            char lastElem = txt.charAt(i+k-1);
            textFreq[prevChar-'a']--;
            textFreq[lastElem-'a']++;
            if(Arrays.equals(PatFreq,textFreq))
            {
                count++;
            }
        }
        return count;
        
    }
}