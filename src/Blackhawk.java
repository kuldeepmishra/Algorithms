import java.util.Scanner;
import java.util.Stack;

public class Blackhawk {

	public static final char OPENING_BRACKET = '(';
	public static final char CLOSING_BRACKET = ')';
	public static final char POSITIVE = '+';
	public static final char NEGATIVE = '-';


	public static String BRule(String str) {
		Stack<Character> stack = new Stack<>();
		str = str.replaceAll(" ", "");
		char[] arr = str.toCharArray();

		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == CLOSING_BRACKET) {
				String resolvedStr = resolveExpression(stack);
				pushBackToStack(resolvedStr, stack);
			} else {
				stack.push(arr[i]);
			}
		}

		return getExpression(stack);
	}

	private static String getExpression(Stack<Character> stack) {
		String str = "";
		while(!stack.isEmpty()) {
			str = stack.pop()+str;
		}
		return str;
	}

	private static void pushBackToStack(String resolvedStr, Stack<Character> stack) {
		for(char c : resolvedStr.toCharArray()) {
			stack.push(c);
		}
	}

	private static String resolveExpression(Stack<Character> stack) {
		String s = "";
		while(!stack.isEmpty() && stack.peek() != OPENING_BRACKET) {
			s = stack.pop()+s;
		}

		//removing opening bracket
		if(!stack.isEmpty()) {
			stack.pop();
		}

		//getting next operator
		char ch = POSITIVE;
		if(!stack.isEmpty()) {
			ch = stack.pop();
		}
		return checkExpression(s, ch);
	}

	private static String checkExpression(String s, char ch) {
		if(ch == POSITIVE) {
			return ch+s;
		} else {
			String str = ch+"";
			for(char c : s.toCharArray()) {
				if(c == POSITIVE) {
					c = NEGATIVE;
				} else if(c == NEGATIVE) {
					c = POSITIVE;
				}
				str += c;
			}
			return str;
		}
	}



	public static void main (String[] args) {  
		Scanner s = new Scanner(System.in);
		System.out.print(BRule(s.nextLine())); 
		s.close();
	}

}