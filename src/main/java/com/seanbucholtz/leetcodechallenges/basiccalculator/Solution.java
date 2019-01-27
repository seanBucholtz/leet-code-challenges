package com.seanbucholtz.leetcodechallenges.basiccalculator;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 224. Basic Calculator
 */
class Solution {

    private static final Pattern GROUP_PATTERN = Pattern.compile("\\(([ 0-9\\+-]+)\\)");

    /**
     * Basic calculator to evaluate a simple expression string.
     *
     * @param s may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative
     *          integers and empty spaces
     * @return the result of the expression
     */
    public int calculate(String s) {
        return Integer.parseInt(reduceAndSum(s));
    }

    String reduceAndSum(String expression) {
        expression = expression.trim();
        Matcher matcher = GROUP_PATTERN.matcher(expression);
        if(!matcher.find()) {
            return sum(expression);
        }

        // ------------ Java 8 compatible ------------------ //
        StringBuffer stringBuffer = new StringBuffer();
        matcher.appendReplacement(stringBuffer, sum(matcher.group(1)));
        while(matcher.find()) {
            matcher.appendReplacement(stringBuffer, sum(matcher.group(1)));
        }
        matcher.appendTail(stringBuffer);
        expression = stringBuffer.toString();
        // ------------ Java 8 compatible ------------------ //

        // ------------ Java 11 ------------------ //
//        expression = matcher.replaceAll(expressionMatch -> {
//            String subExpression = expressionMatch.group(1);
//            return sum(subExpression);
//        });
        // ------------ Java 11 ------------------ //

        return reduceAndSum(expression);
    }

    String sum(String expression) {
        expression = expression.trim();

        List<Integer> integers = new LinkedList<>();
        String[] operands = expression.split("\\+");

        // all operands are assumed to be positive unless proven otherwise later
        for(String operand : operands) {

            if(operand.contains("-")) {

                // some or all of the values in this composite operand are negative
                String[] negativeOperands = operand.split("-");
                String first = negativeOperands[0];

                if(first.length() > 0) {
                    // the first operand of the composite is positive because the first index was populated
                    integers.add(Integer.parseInt(first.trim()));
                }

                // add the remaining negative values
                boolean negativeNegativeFound = false;
                for(int i = 1; i < negativeOperands.length; i++) {

                    String val = negativeOperands[i];

                    if(val.length() == 0) {
                        negativeNegativeFound = true;
                        continue;
                    }

                    if(negativeNegativeFound) {
                        integers.add(Integer.parseInt(val.trim()));
                        negativeNegativeFound = false;
                        continue;
                    }

                    integers.add(Integer.parseInt(val.trim()) * -1);
                }
            }
            else {
                integers.add(Integer.parseInt(operand.trim()));
            }
        }

        Integer sum = integers.size() > 0 ? 0 : null;
        for(Integer integer : integers) {
            sum += integer;
        }

        return String.valueOf(sum);
    }

}
