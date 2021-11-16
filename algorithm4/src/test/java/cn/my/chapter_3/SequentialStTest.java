package cn.my.chapter_3;

import java.security.InvalidParameterException;
import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试基于链表实现的泛型符号表")
public class SequentialStTest {

	private SequentialSt<String, Integer> st;

	private SequentialSt<Character, Integer> s;

	@BeforeEach
	void init() {
		st = new SequentialSt<>();
		s = new SequentialSt<>();
	}

	@Test
	@DisplayName("put")
	void put() {
		Assertions.assertEquals(0, st.size());
		Assertions.assertTrue(st.isEmpty());
		int n = 10;
		for (int i = 0; i < n; i++) {
			st.put(String.valueOf(i), i);
			Assertions.assertEquals((i + 1), st.size());
			Assertions.assertFalse(st.isEmpty());
		}

		st.put("0", 99);
		Assertions.assertEquals(10, st.size());
		st.put("10", 10);
		Assertions.assertEquals(11, st.size());
		Assertions.assertThrows(InvalidParameterException.class, () -> {
			st.put(null, null);
		});
	}

	@Test
	@DisplayName("get")
	void get() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			st.get(null);
		});
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			st.get("1");
		});
		int n = 10;
		for (int i = 0; i < n; i++) {
			st.put(String.valueOf(i), i);
		}
		Assertions.assertNull(st.get("99"));
		Assertions.assertEquals(9, st.get("9"));
	}

	@Test
	@DisplayName("delete")
	void delete() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			st.delete("1");
		});
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			st.delete(null);
		});
		int n = 10;
		for (int i = 0; i < n; i++) {
			st.put(String.valueOf(i), i);
		}
		st.delete("99");
		Assertions.assertEquals(10, st.size());
		st.delete("0");
		Assertions.assertEquals(9, st.size());
		st.delete("9");
		Assertions.assertEquals(8, st.size());
	}

	@Test
	@DisplayName("toString")
	void string() {
		int n = 10;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			st.put(String.valueOf(i), i);
			builder.append("{");
			builder.append(i);
			builder.append(":");
			builder.append(i);
			builder.append("}");
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		Assertions.assertEquals(builder.toString(), st.toString());
	}

	@Test
	@DisplayName("contains")
	void contains() {
		int n = 10;
		for (int i = 0; i < n; i++) {
			st.put(String.valueOf(i), i);
		}
		Assertions.assertTrue(st.contains("0"));
		Assertions.assertThrows(NoSuchElementException.class, () -> st.contains(null));
		st.delete("0");
		Assertions.assertFalse(st.contains("0"));
	}

	@Test
	@DisplayName("min")
	void min() {
		Character[] characters = { 'A', 'D', 'E', 'B', 'C' };
		for (Character ch : characters) {
			s.put(ch, (int) ch);
		}
		Assertions.assertEquals('A', s.min());
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			st.min();
		});
	}

	@Test
	@DisplayName("max")
	void max() {
		Character[] characters = { 'A', 'D', 'E', 'B', 'C' };
		for (Character ch : characters) {
			s.put(ch, (int) ch);
		}
		Assertions.assertEquals('E', s.max());
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			st.max();
		});
	}

	@Test
	@DisplayName("deleteMin")
	void deleteMin() {
		Character[] characters = { 'A', 'D', 'E', 'B', 'C' };
		for (Character ch : characters) {
			s.put(ch, (int) ch);
		}
		s.deleteMin();
		Assertions.assertEquals(4, s.size());
		Assertions.assertEquals('B', s.min());
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			st.deleteMin();
		});
	}

	@Test
	@DisplayName("deleteMax")
	void deleteMax() {
		Character[] characters = { 'A', 'D', 'E', 'B', 'C' };
		for (Character ch : characters) {
			s.put(ch, (int) ch);
		}
		s.deleteMax();
		Assertions.assertEquals(4, s.size());
		Assertions.assertEquals('D', s.max());
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			st.deleteMax();
		});
	}

	@Test
	@DisplayName("select")
	void select() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			st.select(100);
		});
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			st.select(-1);
		});
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			st.select(0);
		});
		Character[] characters = { 'A', 'B', 'C', 'D', 'E' };
		for (Character ch : characters) {
			s.put(ch, (int) ch);
		}
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.select(5);
		});
		Assertions.assertEquals('C', s.select(2));
	}

	@Test
	@DisplayName("floor")
	void floor() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.floor('A');
		});
		Character[] characters = { 'A', 'D', 'C', 'B', 'H', 'E', 'G' };
		for (Character ch : characters) {
			s.put(ch, (int) ch);
		}
		Assertions.assertEquals('E', s.floor('F'));
		Assertions.assertEquals('G', s.celling('F'));
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.celling('I');
		});
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.floor('1');
		});
	}

	@Test
	@DisplayName("rank")
	void rank() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.rank('A');
		});
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.rank(null);
		});
		Character[] characters = { 'A', 'D', 'C', 'B', 'H', 'E', 'G' };
		for (Character ch : characters) {
			s.put(ch, (int) ch);
		}
		Assertions.assertEquals(0, s.rank('A'));
		Assertions.assertEquals(2, s.rank('C'));
	}

	@Test
	@DisplayName("size")
	void size() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.size('A', 'C');
		});
		Character[] characters = { 'A', 'D', 'C', 'B', 'H', 'E', 'G' };
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.size(null, 'C');
		});
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.size('A', null);
		});
		for (Character ch : characters) {
			s.put(ch, (int) ch);
		}
		Assertions.assertEquals(0, s.size('G', 'A'));
		Assertions.assertEquals(4, s.size('B', 'E'));
	}

	@Test
	@DisplayName("keys")
	void keys() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.keys();
		});
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.keys('A', 'C');
		});
		Character[] characters = { 'A', 'D', 'C', 'B', 'H', 'E', 'G' };
		for (Character ch : characters) {
			s.put(ch, (int) ch);
		}
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			s.keys('C', 'A');
		});

		Character[] chs = new Character[3];
		int i = 0;
		for (Character c : s.keys('A', 'C')) {
			chs[i] = c;
			i++;
		}
		Arrays.sort(chs);

		Character[] t = { 'A', 'B', 'C' };
		i = 0;
		for (Character c : chs) {
			Assertions.assertEquals(t[i], c);
			i++;
		}

		List<Character> list = new ArrayList<>();
		Collections.addAll(list, characters);
		for (Character c : s.keys()) {
			list.remove(c);
		}
		Assertions.assertEquals(0, list.size());
	}
}
