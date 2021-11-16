package cn.my.chapter_3;

import java.security.InvalidParameterException;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试二叉查找树")
public class BSTTest {
	private BST<Character, Character> tree;

	@BeforeEach
	void init() {
		tree = new BST<>();
	}

	@Test
	@DisplayName("isEmpty")
	void isEmpty() {
		Assertions.assertTrue(tree.isEmpty());
	}

	@Test
	@DisplayName("size")
	void size() {
		Assertions.assertEquals(0, tree.size());
	}

	@Test
	@DisplayName("put")
	void put() {
		Assertions.assertThrows(InvalidParameterException.class, () -> {
			tree.put(null, 'C');
		});
		Character[] characters = { 'S', 'E', 'A', 'R', 'C', 'H', 'E', 'X' };
		for (Character c : characters) {
			tree.put(c, c);
		}
		Assertions.assertEquals(7, tree.size());
		Assertions.assertFalse(tree.isEmpty());
	}

	@Test
	@DisplayName("get")
	void get() {
		Assertions.assertNull(tree.get('A'));
		Character[] characters = { 'S', 'E', 'A', 'R', 'C', 'H', 'E', 'X' };
		for (Character c : characters) {
			tree.put(c, c);
		}
		Assertions.assertNull(tree.get('M'));
		Assertions.assertEquals('A', tree.get('A'));
	}

	@Test
	@DisplayName("toString")
	void str() {
		Assertions.assertEquals("", tree.toString());
		Character[] characters = { 'S', 'E', 'A', 'R', 'C', 'H', 'E', 'X' };
		for (Character c : characters) {
			tree.put(c, c);
		}
		StringBuilder builder = new StringBuilder();
		characters = new Character[] { 'S', 'E', 'A', 'R', 'C', 'H', 'X' };
		Arrays.sort(characters);
		for (Character c : characters) {
			builder.append(c);
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		Assertions.assertEquals(builder.toString(), tree.toString());
	}
}
