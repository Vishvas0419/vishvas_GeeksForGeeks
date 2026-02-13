// User function Template for Java

class Solution {
    int search(String pat, String txt) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : pat.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int cnt = map.size();
        int k = pat.length();
        int ans = 0;
        int i=0,j=0;
        while(j<txt.length())
        {
            char ch = txt.charAt(j);
            if(map.containsKey(ch)) 
            {
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch)==0) cnt--;
            }
            if(j-i+1==k)
            {
                if(cnt==0) ans++;
                if(map.containsKey(txt.charAt(i)))
                {
                    map.put(txt.charAt(i),map.getOrDefault(txt.charAt(i),0)+1);
                    if(map.get(txt.charAt(i))==1) cnt++;
                }
                i++;
            }
            j++;
            
        }
        return ans;
        
    }
}