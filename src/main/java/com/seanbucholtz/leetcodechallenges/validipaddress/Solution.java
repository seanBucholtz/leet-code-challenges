package com.seanbucholtz.leetcodechallenges.validipaddress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    private enum IpType {
        IPv4(4, ".", "\\.", "^[0-9]{1,3}$"),
        IPv6(8, ":", ":","^[A-Za-z0-9]{4}|0{1,4}$"),
        Neither(-1, null, null, null);

        int length;
        CharSequence delimiter;
        String splitRegex;
        String groupRegex;


        IpType(int length, CharSequence delimiter, String splitRegex, String groupRegex) {
            this.length = length;
            this.delimiter = delimiter;
            this.splitRegex = splitRegex;
            this.groupRegex = groupRegex;
        }
    }

    public String validIPAddress(String IP) {
        boolean hasIPv4Delimiter = IP.contains(IpType.IPv4.delimiter);
        boolean hasIPv6Delimiter = IP.contains(IpType.IPv6.delimiter);
        IpType probableType;
        if(hasIPv4Delimiter && !hasIPv6Delimiter) {
            probableType = IpType.IPv4;
        }
        else if(hasIPv6Delimiter && !hasIPv4Delimiter) {
            probableType = IpType.IPv6;
        }
        else {
            return IpType.Neither.toString();
        }

        String[] ipArr = IP.split(probableType.splitRegex);
        if(ipArr.length != IpType.IPv4.length && ipArr.length != IpType.IPv6.length) {
            return IpType.Neither.toString();
        }

        Pattern pattern = Pattern.compile(probableType.groupRegex);

        for(String segment : ipArr) {
            Matcher matcher = pattern.matcher(segment);
            boolean matches = matcher.matches();
            if(!matches || (probableType == IpType.IPv4 && segment.startsWith("0"))) {
                return IpType.Neither.toString();
            }
            if(probableType == IpType.IPv4) {
                int number = Integer.valueOf(segment);
                if(number < 0 || number > 255) {
                    return IpType.Neither.toString();
                }
            }
        }
        return probableType.toString();
    }
}
