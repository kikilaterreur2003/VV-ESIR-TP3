package com.mycompany.app.TP3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testIsBalancedEmptyString() {
        assertTrue(App.isBalanced(""));
    }
    @Test
    public void testIsBalancedNoBracket() {
        assertTrue(App.isBalanced("5sdSEf45s6a+*9sd5f"));
    }
    @Test
    public void testIsBalancedNormal() {
        assertTrue(App.isBalanced("()[]{}"));
    }
    @Test
    public void testIsBalancedImbricated() {
        assertTrue(App.isBalanced("([()])(){()()}"));
    }
    @Test
    public void testOpenBracketMissing() {
        assertFalse(App.isBalanced("())[]"));
    }
    @Test
    public void testClosingBracketMissing() {
    	assertFalse(App.isBalanced("(){()"));
    }
    @Test
    public void testWeirdImbrication() {
    	assertFalse(App.isBalanced("[(])"));
    }
    
    @Test
    public void testWeirdImbrication2() {
    	assertFalse(App.isBalanced("({)}"));
    }
    @Test
    public void testWeirdImbrication3() {
    	assertFalse(App.isBalanced("{[}]"));
    }
    @Test
    public void testInvertedBracket() {
    	assertFalse(App.isBalanced("}{"));
    }
    @Test
    public void testOpeningBracketMissingInImbrication() {
    	assertFalse(App.isBalanced("[]]()"));
    }
    


}
