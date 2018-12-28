package com.seanbucholtz.leetcodechallenges.validnumber;

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean isNumber = false;
        boolean sciNotationFound = false;
        boolean decimalFound = false;
        boolean decimalHasNumberNeighbor = false;
        boolean prevCharIsSign = false;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++)
        {
            char c = arr[i];
            if(!Character.isDigit(c))
            {
                if(Character.compare(c, 'e') == 0 || Character.compare(c, 'E') == 0)
                {
                    isNumber = false;
                    if(sciNotationFound || prevCharIsSign || (decimalFound && !decimalHasNumberNeighbor) || i == 0)
                        break;
                    else
                        sciNotationFound = true;

                    prevCharIsSign = false;
                }
                else if(Character.compare(c, '.') == 0)
                {
                    if(decimalFound || sciNotationFound)
                    {
                        isNumber = false;
                        break;
                    }
                    else
                    {
                        decimalFound = true;
                        if(i > 0)
                            decimalHasNumberNeighbor = (Character.isDigit(arr[i-1]));
                        if(i < arr.length-1)
                            decimalHasNumberNeighbor = (decimalHasNumberNeighbor || Character.isDigit(arr[i+1]));
                    }
                    prevCharIsSign = false;
                }
                else if(Character.compare(c, '-') == 0 || Character.compare(c, '+') == 0)
                {
                    prevCharIsSign = true;
                    isNumber = false;
                    if(i == arr.length-1 || (i > 0 && Character.compare(arr[i-1], 'e') != 0))
                        break;
                }
                else
                {
                    isNumber = false;
                    break;
                }
            }
            else
            {
                isNumber = true;
                prevCharIsSign = false;
            }
        }
        return isNumber;
    }
}
