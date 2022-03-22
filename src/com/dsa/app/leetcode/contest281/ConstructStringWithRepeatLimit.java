package com.dsa.app.leetcode.contest281;

import java.util.Arrays;
import java.util.Collections;

public class ConstructStringWithRepeatLimit {
    public static void main(String[] args) {
        ConstructStringWithRepeatLimit obj = new ConstructStringWithRepeatLimit();
        obj.repeatLimitedString("cczazcc", 3);
    }

    public String repeatLimitedString(String s, int repeatLimit) {

        var chrArray = s.toCharArray();
        Arrays.sort(chrArray);

        if(s.length() < repeatLimit)
            return chrArray.toString();

        int slidingWindow = repeatLimit;
        Collections.reverse(Arrays.asList(chrArray));
        StringBuilder newStr = new StringBuilder(s.substring(0, slidingWindow));
        String prevValue = s.substring(0, slidingWindow);
        boolean prevBool = false;

        for(int index = 0; index < s.length(); index += slidingWindow){
            if(prevBool){
                 if(s.substring(index, index+ slidingWindow).equals(prevValue)){
                     //SWAP
                 }else{
                     newStr.append(s.charAt(index));
                     prevBool = false;
                 }

            }else{
                if(prevValue.equals(s.substring(index, index+ slidingWindow)))
                    prevBool = true;
                else
                    prevBool = false;
                newStr.append(s.charAt(index));
            }
        }
        return newStr.toString();
    }

}
