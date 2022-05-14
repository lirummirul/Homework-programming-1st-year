package FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int pFreq[];
    public boolean  isAnagram(){
        // for(int num : pFreq) System.out.println(" num is "+num);
        for(int num : pFreq) if(num!=0)return false;
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length())return new ArrayList<>();
        pFreq=new int[26];
        int count=0;
        List<Integer> list=new ArrayList<>();
        for(char c : p.toCharArray())pFreq[c-'a']++;
        for(int i=0;i<p.length()-1;i++)pFreq[s.charAt(i)-'a']--;
        for(int i=p.length()-1,j=0;i<s.length();i++){
            pFreq[s.charAt(i)-'a']--;
            // System.out.println("yes "+i+" no "+j);
            while(i-j+1>p.length())
                pFreq[s.charAt(j++)-'a']++;
            if(isAnagram())list.add(j);
        }
        return list;
    }
}