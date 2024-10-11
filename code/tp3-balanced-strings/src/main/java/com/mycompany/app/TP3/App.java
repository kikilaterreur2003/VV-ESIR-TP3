package com.mycompany.app.TP3;

import java.util.Stack;

/**
 * Hello world!
 */
public class App {
    public static boolean isBalanced(String str) {
    	Stack<Character> stack = new Stack<>();
    	for(int i = 0; str.length()>i; i++) {
    		
    		switch (str.charAt(i)) {
				case '(': 
					stack.push(')');
					break;
				case '{': 
					stack.push('}');
					break;
				case '[': 
					stack.push(']');
					break;
	
				case ')': 
					if(stack.size()==0 || stack.pop() != ')') {
						return false;
					}
					break;
				case '}': 
					if(stack.size()==0 || stack.pop() != '}') {
						return false;
					}
					break;
				case ']': 
					if(stack.size()==0 || stack.pop() != ']') {
						return false;
					}
					break;
			}

    	}
    	
    	return stack.size()==0;
    }
}
