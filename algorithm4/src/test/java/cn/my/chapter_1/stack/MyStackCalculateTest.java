package cn.my.chapter_1.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 栈的应用
 * 
 * 计算算数表达式
 * 
 * 支持+、-、*、/运算符与sqrt求平方根的运算符
 * 
 * 解决思路，用两个栈，一个栈保存运算符、一个栈保存操作数。
 * 
 * 表达式由运算符和操作数组成，根据以下4种情况，从左到右逐个将这些实体送入栈中处理：
 * 
 * 1.将操作数压入操作数栈
 * 
 * 2.将运算符压如运算符栈
 * 
 * 3.忽略左括号
 * 
 * 4.遇到右括号时，弹出一个运算符，弹出所需数量的操作数，将运算符和操作数的运算结果压入操作数栈。
 * 
 * 5.处理完最后一个右括号后，操作数栈中只有一个值，这个值就是最终的运算结果。
 */
@DisplayName("测试使用栈，实现简单算数表达式的运算")
public class MyStackCalculateTest {

	private static final char[] OPS = { '+', '-', '*', '/' };

	private static final String SQRT = "sqrt";

	private static final char LEFT = '(';

	private static final char RIGHT = ')';

	@Test
	void test1() {
		String a = "(1+((2+3)*(4*5)))";
		double result = 101d;
		Assertions.assertEquals(result, cal(a));
	}

	@Test
	void test2() {
		String a = "((4+((2*10)+(3*10)))+sqrt(9))";
		double result = 57d;
		Assertions.assertEquals(result, cal(a));
	}

	private boolean isOps(char c) {
		for (char o : OPS) {
			if (c == o) {
				return true;
			}
		}
		return false;
	}

	private boolean isSqrt(char c) {
		return c == 's';
	}

	private boolean isLeft(char c) {
		return c == LEFT;
	}

	private boolean isRight(char c) {
		return c == RIGHT;
	}

	private Double cal(String a) {
		if (Objects.isNull(a)) {
			throw new IllegalArgumentException();
		}

		// 操作数栈
		Stack<Double> valStack = new Stack<>();
		// 运算符栈
		Stack<String> opStack = new Stack<>();
		int n = 0;
		while (n < a.length()) {
			char ch = a.charAt(n);
			if (isOps(ch)) {
				opStack.push(String.valueOf(ch));
				n = n + 1;
				continue;
			}
			if (isSqrt(ch)) {
				if (n + 4 > a.length()) {
					throw new IndexOutOfBoundsException();
				}
				opStack.push(SQRT);
				n = n + 4;
				continue;
			}
			if (isLeft(ch)) {
				n = n + 1;
				continue;
			}
			if (isRight(ch)) {
				String ops = opStack.pop();
				switch (ops) {
				case "+":
					Double d1 = valStack.pop() + valStack.pop();
					valStack.push(d1);
					break;
				case "-":
					Double d2 = valStack.pop() - valStack.pop();
					valStack.push(d2);
					break;
				case "*":
					Double d3 = valStack.pop() * valStack.pop();
					valStack.push(d3);
					break;
				case "/":
					Double d4 = valStack.pop() / valStack.pop();
					valStack.push(d4);
					break;
				case SQRT:
					Double d5 = Math.sqrt(valStack.pop());
					valStack.push(d5);
					break;
				default:
					break;
				}
				n = n + 1;
				continue;
			}
			List<String> valList = new ArrayList<>();
			valList.add(String.valueOf(ch));
			int next = n + 1;
			int j = 0;
			while (next < a.length() && !isOps(a.charAt(next)) && !isSqrt(a.charAt(next)) && !isLeft(a.charAt(next))
					&& !isRight(a.charAt(next))) {
				valList.add(String.valueOf(a.charAt(next)));
				next = next + 1;
				j = j + 1;
			}
			String val = "";
			for (String s : valList) {
				val = val + s;
			}
			valStack.push(Double.valueOf(val));
			n = n + 1 + j;
		}
		return valStack.pop();
	}
}
