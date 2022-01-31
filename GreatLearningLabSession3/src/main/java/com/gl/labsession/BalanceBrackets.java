package com.gl.labsession;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String bracketExpression = "([[{}]]) ()";

		if (isBalanced(bracketExpression)) {
			System.out.println("Balanced Brackets");
		} else {
			System.out.println("Unbalanced Brackets");
		}

	}

	private static boolean isBalanced(String bracketExpression) {

		Stack<Character> stack = new Stack<Character>();

		// iterate through the characters
		for (int i = 0; i < bracketExpression.length(); i++) {

			// check if c is '(' '{' '['
			char character = bracketExpression.charAt(i);

			// push to stack
			if (character == '(' || character == '[' || character == '{') {
				stack.push(character);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}
			char c;
			// pop from the stack c= ( )
			switch (character) {

			case '}':
				c = stack.pop();
				if (c == '(' || c == '[')
					return false;
				break;

			case ')':
				c = stack.pop();
				if (c == '{' || c == '[')
					return false;
				break;

			case ']':
				c = stack.pop();
				if (c == '(' || c == '{')
					return false;
				break;
			

			}
		}

		return stack.isEmpty();
	}

}
