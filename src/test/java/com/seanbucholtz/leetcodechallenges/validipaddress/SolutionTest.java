package com.seanbucholtz.leetcodechallenges.validipaddress;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void validIPAddress_0() {
        Solution s = new Solution();
        assertEquals("IPv4", s.validIPAddress("172.16.254.1"));
    }

    @Test
    public void validIPAddress_1() {
        Solution s = new Solution();
        assertEquals("IPv6", s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }

    @Test
    public void validIPAddress_2() {
        Solution s = new Solution();
        assertEquals("Neither", s.validIPAddress("256.256.256.256"));
    }

    @Test
    public void validIPAddress_3() {
        Solution s = new Solution();
        assertEquals("Neither", s.validIPAddress("172.16.254.01"));
    }

    @Test
    public void validIPAddress_4() {
        Solution s = new Solution();
        assertEquals("IPv6", s.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
    }

    @Test
    public void validIPAddress_5() {
        Solution s = new Solution();
        assertEquals("Neither", s.validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
    }

    @Test
    public void validIPAddress_6() {
        Solution s = new Solution();
        assertEquals("Neither", s.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
    }

    @Test
    public void validIPAddress_7() {
        Solution s = new Solution();
        assertEquals("Neither", s.validIPAddress("12..33.4"));
    }

    @Test
    public void validIPAddress_8() {
        Solution s = new Solution();
        assertEquals("Neither", s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}