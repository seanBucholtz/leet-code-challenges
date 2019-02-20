package com.seanbucholtz.leetcodechallenges.replacespace;


public class Solution {

    public String replaceSpaces(char[] input, int inputLength) {
//        return this.replaceSpacesBrute0(input, inputLength, "%20");
        return urlEncode(input, inputLength);
    }



    public String replaceSpacesBrute0(char[] input, int inputLength, String replacement) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i < input.length; i++) {
            char c = input[i];
            boolean isSpace = Character.isWhitespace(c);
            if(isSpace && (index == 0 || index >= inputLength - 1 )) {
                continue;
            }
            else if(isSpace) {
                sb.append(replacement);
            }
            else {
                sb.append(c);
            }
            index ++;
        }
        return sb.toString();
    }

    public String urlEncode(char[] input, int trueLength) {
        int bufferSize = input.length - trueLength;
        int lastBufferIndex = input.length - 1;
        for(int i = input.length; i >= 0; i--) {
            boolean outsideBuffer = bufferSize + (i - input.length) < 0;
            if(outsideBuffer) {
                char c = input[i];
                boolean isSpace = Character.isWhitespace(c);
                if(isSpace) {
                    input[lastBufferIndex] = '0';
                    input[lastBufferIndex - 1] = '2';
                    input[lastBufferIndex - 2] = '%';
                    lastBufferIndex = lastBufferIndex - 3;
                }
                else {
                    input[lastBufferIndex] = c;
                    lastBufferIndex--;
                }
            }
        }
        return new String(input);
    }

//    public String replaceSpacesBrute1(char[] input, int inputLength, String replacement) {
//        int numberOfSpaces = 0;
//        boolean foundNonSpace = false;
//        int tempSpacesCount = 0;
//        for(char c : input) {
//            if(Character.isWhitespace(c)) {
//                if(foundNonSpace) {
//                    tempSpacesCount ++;
//                }
//            }
//            else {
//                foundNonSpace = true;
//
//                if(tempSpacesCount > 0) {
//                    numberOfSpaces += tempSpacesCount;
//                    tempSpacesCount = 0;
//                }
//            }
//        }
//
//        byte[] rtnBytes = new byte[inputLength + (numberOfSpaces * (replacement.length() - 1))];
//        int rtnBytesIndex = 0;
//        for(int i = 0; i < input.length; i++) {
//            char c = input[i];
//            boolean isSpace = Character.isWhitespace(c);
//
//        }
//    }
}
