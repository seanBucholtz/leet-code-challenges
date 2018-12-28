package com.seanbucholtz.leetcodechallenges.uniqueemailaddresses;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Unique Email Addresses
 */
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new LinkedHashSet<String>(emails.length);
        for(String email : emails) {
            String[] emailSegments = email.split("@");
            String localName = emailSegments[0];
            localName = localName.replaceAll("\\.", "");
            int plusCharIndex = localName.indexOf('+');
            if(plusCharIndex > -1) {
                localName = localName.substring(0, plusCharIndex);
            }
            String domainName = emailSegments[1];
            String uniqueEmail = localName + "@" + domainName;
            uniqueEmails.add(uniqueEmail);
        }
        return uniqueEmails.size();
    }
}
